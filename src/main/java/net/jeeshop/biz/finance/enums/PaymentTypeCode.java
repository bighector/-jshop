package net.jeeshop.biz.finance.enums;

/**
 * @author dylan
 * @date 16/3/8 23:03
 * Email: dinguangx@163.com
 */
public enum PaymentTypeCode {
    POINTS("积分"), DUMMY("模拟网关"), ALIPAY("支付宝"),  TENPAY("财付通"), OFFLINE("线下付款");
    private String desc;
    PaymentTypeCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
