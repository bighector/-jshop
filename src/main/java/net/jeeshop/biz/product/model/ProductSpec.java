package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpec extends BaseModel implements Serializable 
{
    /** 规格id */
    private Long spId;

    /** 规格名称 */
    private String spName;

    /** 排序 */
    private Integer spSort;

    /** 所属分类id */
    private Integer classId;

    /** 所属分类名称 */
    private String className;

    /** 是否删除0:未删除;1:已删除 */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    public Integer getSpSort() {
        return spSort;
    }

    public void setSpSort(Integer spSort) {
        this.spSort = spSort;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

	@Override
	public String toString() {
		return "ProductSpec [spId=" + spId + ", spName=" + spName + ", spSort="
				+ spSort + ", classId=" + classId + ", className=" + className
				+ ", isDel=" + isDel + "]";
	}
}