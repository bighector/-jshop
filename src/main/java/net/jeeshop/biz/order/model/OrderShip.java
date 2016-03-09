package net.jeeshop.biz.order.model;

import java.io.Serializable;
import net.jeeshop.biz.base.model.BaseModel;

public class OrderShip extends BaseModel implements Serializable {
    /** ä¼šå‘˜ID */
    private Long memberId;

    /** è®¢å�•ID */
    private Long orderId;

    /** æ”¶è´§äºº */
    private String receiver;

    /** çœ�ä»½ä»£ç � */
    private String province;

    /** åœ°å¸‚ä»£ç � */
    private String city;

    /** åŒºåŽ¿ä»£ç � */
    private String area;

    /** è�”ç³»åœ°å�€ */
    private String address;

    /** é‚®æ”¿ç¼–ç � */
    private String postcode;

    /** è�”ç³»ç”µè¯� */
    private String mobile;

    /** ç”µè¯�å�·ç � */
    private String phone;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}