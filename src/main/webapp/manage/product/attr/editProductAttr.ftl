<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="商品属性">
<style>
	.td_right{text-align: right;}
</style>
<script type="text/javascript">
	$(function() {
		 $("#code").focus();
	});
</script>
</head>

<body>
<#if e.id??>
    <#assign formAction="update">
	<#assign insertAction=false />
<#else >
	<#assign formAction="insert">
    <#assign insertAction=true />
</#if>

<form action="${basepath}/product/attr" id="form" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>商品属性编辑</strong>
				</td>
			</tr>
			<tr style="display:none;">
				<th>id</th>
				<td><input type="hidden" name="id" value="${e.id!""}"></td>
			</tr>
			<tr>
				<th class="td_right">商品分类</th>
				<td style="text-align: left;">
					<#if insertAction>
						<input type="text" name="categoryId" value="${e.categoryId!""}" id="categoryId"  data-rule="商品分类:required;categoryId;"/>
					<#else>
						<input type="text" name="categoryId" id="categoryId" value="${e.categoryId!""}" data-rule="商品分类:required;categoryId;"/>
					</#if>
				</td>
			</tr>
			<tr>
				<th class="td_right">名称</th>
				<td style="text-align: left;">
					<#if insertAction>
						<input type="text" name="attrName" value="${e.attrName!""}" id="attrName"  data-rule="商品属性名称:required;attrName;"/>
					<#else>
						<input type="text" name="attrName" id="attrName" value="${e.attrName!""}" data-rule="商品属性名称:required;attrName;"/>
					</#if>
				</td>
			</tr>
			<tr>
				<th class="td_right">是否必须</th>
				<td style="text-align: left;">
                    <#if insertAction>
                    <span class="add-on"></span>
                        <input type="text" name="isMandated" id="isMandated"/>
                    <#else>
                        <input type="text" name="isMandated" id="isMandated" value="${e.isMandated!""}"/>
                    </#if>
				</td>
			</tr>
            <tr>
                <th class="td_right">值类型</th>
                <td style="text-align: left;">
                	<#if insertAction>
                		<input type="text" name="valueType" id="valueType"/>
                	<#else>	
                		<input type="text" name="valueType" id="valueType" value="${e.valueType!""}"/>
                	</#if>
                </td>
            </tr>
            <tr>
                <th class="td_right">可选值列表</th>
                <td style="text-align: left;">
                	<#if insertAction>
                		<input type="text" name="optionsList" id="optionsList"/>
                	<#else>
                		<input type="text" name="optionsList" id="optionsList" value="${e.optionsList!""}"/>
                	</#if>
                </td>
            </tr>
            <tr>
                <th class="td_right">顺序</th>
                <td style="text-align: left;">
                	<#if insertAction>
                		<input type="text" name="ordinal" id="ordinal"/>
                	<#else>
                		<input type="text" name="ordinal" id="ordinal" value="${e.ordinal!""}"/>
                	</#if>
                </td>
            </tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<#if insertAction>
						<button method="insert" class="btn btn-success">
							<i class="icon-ok icon-white"></i> 新增
						</button>
                    <#else >
						<button method="update" class="btn btn-success">
							<i class="icon-ok icon-white"></i> 保存
						</button>
                    </#if>
				</td>
			</tr>
		</table>
</form>
</@page.pageBase>