package net.jeeshop.biz.product.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.biz.product.enums.ProductStatus;

public class Product extends BaseModel implements Serializable {
    /** 商品信息ID */
    private Long productInfoId;

    /** 商品名称 */
    private String productName;

    /** 市场价格 */
    private Double marketPrice;

    /** 成本价 */
    private Double costPrice;

    /** 销售价 */
    private Double price;

    /** 库存数 */
    private Integer storage;

    /** 主图 */
    private String mainImage;

    /** 点击数 */
    private Long hitCount;

    /** 是否新品 */
    private Boolean isNew;

    /** 是否热销 */
    private Boolean isHot;

    /** 商品关键字，逗号分隔 */
    private String keywords;

    /** 页面标题,商品名称+规格名称 */
    private String title;

    /** 商品状态 */
    private ProductStatus productStatus;

    private static final long serialVersionUID = 1L;

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public Long getHitCount() {
        return hitCount;
    }

    public void setHitCount(Long hitCount) {
        this.hitCount = hitCount;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
}