package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class ProductImage extends BaseModel implements Serializable {
    /** 图片路径 */
    private String imagePath;

    /** 是否主图,1-是0-否 */
    private Boolean isMainImage;

    /** ID */
    private Long productInfoId;

    private static final long serialVersionUID = 1L;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Boolean getIsMainImage() {
        return isMainImage;
    }

    public void setIsMainImage(Boolean isMainImage) {
        this.isMainImage = isMainImage;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }
}