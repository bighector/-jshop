package net.jeeshop.biz.product.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import net.jeeshop.biz.base.model.BaseModel;

public class ProductSpec extends BaseModel implements Serializable 
{
    private static final long serialVersionUID = 1L;
	
    /** 规格名称 */
    private String specification;

    /** 排序 */
    private Integer ordinal;

    /** 所属分类id */
    private Integer catagoryId;

    /** 所属分类名称 */
    private String catagoryName;

    /** 是否删除0:未删除;1:已删除 */
    private Integer isDel=0;
	
	/*规格值 - 后台到页面 */
	private List<ProductSpecVal> vaList;
	
	/*页面到后台*/
	String[]  specVals;
	Integer[] specOrders;

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName == null ? null : catagoryName.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

	public Integer[] getSpecOrders() {
		return specOrders;
	}

	public void setSpecOrders(Integer[] specOrders) {
		this.specOrders = specOrders;
	}
	
	public List<ProductSpecVal> getVaList() {
		return vaList;
	}

	public void setVaList(List<ProductSpecVal> list) {
		this.vaList = list;
	}

	public String[] getSpecVals() {
		return specVals;
	}

	public void setSpecVals(String[] specVals) {
		this.specVals = specVals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() 
	{
		return "ProductSpec [specification=" + specification + ", ordinal="
				+ ordinal + ", catagoryId=" + catagoryId + ", catagoryName="
				+ catagoryName + ", isDel=" + isDel + ", list=" + vaList
				+ ", specVals=" + Arrays.toString(specVals) + ", specOrders="
				+ Arrays.toString(specOrders) + "]";
	}

}