/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class InsertSelectiveElementGenerator extends
        AbstractXmlElementGenerator {

    public InsertSelectiveElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("insert"); //$NON-NLS-1$

        answer.addAttribute(new Attribute(
                "id", introspectedTable.getInsertSelectiveStatementId())); //$NON-NLS-1$

        FullyQualifiedJavaType parameterType = introspectedTable.getRules()
                .calculateAllFieldsClass();

        answer.addAttribute(new Attribute("parameterClass", //$NON-NLS-1$
                parameterType.getFullyQualifiedName()));

        context.getCommentGenerator().addComment(answer);

        GeneratedKey gk = introspectedTable.getGeneratedKey();

        if (gk != null && gk.isPlacedBeforeInsertInIbatis2()) {
            IntrospectedColumn introspectedColumn = introspectedTable
                    .getColumn(gk.getColumn());
            // if the column is null, then it's a configuration error. The
            // warning has already been reported
            if (introspectedColumn != null) {
                // pre-generated key
                answer.addElement(getSelectKey(introspectedColumn, gk));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("insert into "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));

        XmlElement insertElement = new XmlElement("dynamic"); //$NON-NLS-1$
//        answer.addElement(insertElement);


        XmlElement valuesElement = new XmlElement("dynamic"); //$NON-NLS-1$
//        answer.addElement(valuesElement);
        //是否有insert替换的字段
        boolean hasInsertReplace = false;
        List<IntrospectedColumn> insertReplaceColumns = new ArrayList<IntrospectedColumn>();
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getAllColumns()) {
            if (introspectedColumn.isIdentity()) {
                // cannot set values on identity fields
                continue;
            }
            if(introspectedColumn.isInsertIgnore()) {
                continue;
            }

            XmlElement insertNotNullElement = new XmlElement("isNotEmpty"); //$NON-NLS-1$
            insertNotNullElement.addAttribute(new Attribute("prepend", ",")); //$NON-NLS-1$ //$NON-NLS-2$
            insertNotNullElement.addAttribute(new Attribute(
                    "property", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
            insertNotNullElement.addElement(new TextElement(
                    Ibatis2FormattingUtilities
                            .getEscapedColumnName(introspectedColumn)));

            XmlElement valuesNotNullElement = new XmlElement("isNotEmpty"); //$NON-NLS-1$
            valuesNotNullElement.addAttribute(new Attribute("prepend", ",")); //$NON-NLS-1$ //$NON-NLS-2$
            valuesNotNullElement.addAttribute(new Attribute(
                    "property", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
            if(StringUtility.stringHasValue(introspectedColumn.getInsertReplaceStr())) {
                hasInsertReplace = true;
                insertReplaceColumns.add(introspectedColumn);
//                valuesNotNullElement.addElement(new TextElement(introspectedColumn.getInsertReplaceStr()));
            } else {
                insertElement.addElement(insertNotNullElement);
                valuesNotNullElement.addElement(new TextElement(
                    Ibatis2FormattingUtilities
                            .getParameterClause(introspectedColumn)));
                valuesElement.addElement(valuesNotNullElement);
            }
        }

        if(hasInsertReplace) {
            // insert clause
            answer.addElement(new TextElement("("));
            StringBuilder sbInsert = new StringBuilder();
            for(IntrospectedColumn column : insertReplaceColumns) {
                sbInsert.append(column.getActualColumnName()).append(",");
            }
            sbInsert.deleteCharAt(sbInsert.length() - 1);//删除最后的逗号
            answer.addElement(new TextElement(sbInsert.toString()));
//            insertElement.addAttribute(new Attribute("prepend", ",")); //TODO 确认是否需要
            answer.addElement(insertElement);
            answer.addElement(new TextElement(")"));

            // values clause
            answer.addElement(new TextElement("values"));
            answer.addElement(new TextElement("("));
            StringBuilder sbValues = new StringBuilder();
            for(IntrospectedColumn column : insertReplaceColumns) {
                sbValues.append(column.getInsertReplaceStr()).append(",");
            }
            sbValues.deleteCharAt(sbValues.length() - 1);//删除最后的逗号
            answer.addElement(new TextElement(sbValues.toString()));
//            valuesElement.addAttribute(new Attribute("prepend", ",")); //TODO 确认是否需要
            answer.addElement(valuesElement);
            answer.addElement(new TextElement(")"));
        } else {
            insertElement.addAttribute(new Attribute("prepend", "(")); //$NON-NLS-1$ //$NON-NLS-2$
            answer.addElement(insertElement);
            answer.addElement(new TextElement("values")); //$NON-NLS-1$
            valuesElement.addAttribute(new Attribute("prepend", "(")); //$NON-NLS-1$ //$NON-NLS-2$
            answer.addElement(valuesElement);
            insertElement.addElement(new TextElement(")")); //$NON-NLS-1$
            valuesElement.addElement(new TextElement(")")); //$NON-NLS-1$
        }

        if (gk != null && !gk.isPlacedBeforeInsertInIbatis2()) {
            IntrospectedColumn introspectedColumn = introspectedTable
                    .getColumn(gk.getColumn());
            // if the column is null, then it's a configuration error. The
            // warning has already been reported
            if (introspectedColumn != null) {
                // pre-generated key
                answer.addElement(getSelectKey(introspectedColumn, gk));
            }
        }

        if (context.getPlugins().sqlMapInsertSelectiveElementGenerated(
                answer, introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
