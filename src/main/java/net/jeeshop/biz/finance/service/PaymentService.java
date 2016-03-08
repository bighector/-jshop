package net.jeeshop.biz.finance.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import net.jeeshop.biz.finance.bean.PaymentBean;
import net.jeeshop.biz.finance.bean.PaymentItemBean;
import net.jeeshop.biz.finance.bean.PaymentResultBean;
import net.jeeshop.biz.finance.client.PaymentItemMapper;
import net.jeeshop.biz.finance.client.PaymentMapper;
import net.jeeshop.biz.finance.enums.PaymentStatus;
import net.jeeshop.biz.finance.enums.RefundStatus;
import net.jeeshop.biz.finance.model.Payment;
import net.jeeshop.biz.finance.model.PaymentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 支付服务
 * @author dylan
 * @date 16/3/8 21:41
 * Email: dinguangx@163.com
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private PaymentItemMapper paymentItemMapper;
    /**
     * 请求支付
     * @param paymentBean
     * @return
     */
    @Transactional
    public PaymentResultBean requestPayment(PaymentBean paymentBean) {
        //1. 创建payment&paymentItem
        Payment payment = buildPayment(paymentBean);
        paymentMapper.insert(payment);
        List<PaymentItem> paymentItems = buildPaymentItems(payment, paymentBean.getPaymentItems());
        for(PaymentItem item : paymentItems) {
            paymentItemMapper.insert(item);
        }
        //2. 进行支付
        //3. 支付结果通知(同步&异步)
        return new PaymentResultBean();
    }

    private Payment buildPayment(PaymentBean paymentBean) {
        Payment payment = new Payment();
        payment.setMemberId(paymentBean.getMemberId());
        payment.setOrderId(paymentBean.getOrderId());
        payment.setAmount(paymentBean.getAmount());
        payment.setRequestNum(paymentBean.getRequestNum());
        payment.setRefundedAmount(0.00);
        payment.setRemark(paymentBean.getRemark());
        payment.setPaymentStatus(PaymentStatus.INIT);
        payment.setRefundStatus(RefundStatus.NONE);
        payment.setCreateTime(new Date());
        payment.setUpdateTime(new Date());
        payment.setCreateAccount("FIN-SYS");
        payment.setUpdateAccount("FIN-SYS");
        return payment;
    }

    private List<PaymentItem> buildPaymentItems(final Payment payment, List<PaymentItemBean> paymentItems) {

        return Lists.transform(paymentItems, new Function<PaymentItemBean, PaymentItem>() {
            @Override
            public PaymentItem apply(PaymentItemBean input) {
                PaymentItem item = new PaymentItem();
                item.setMemberId(payment.getMemberId());
                item.setPaymentId(payment.getId());
                item.setPaymentType(input.getPaymentType());
//                item.setPaymentTypeId();
                item.setAmount(input.getAmount());
                item.setPaymentStatus(PaymentStatus.INIT);
                item.setRefundedAmount(0.00);
                item.setCreateTime(new Date());
                item.setUpdateTime(new Date());
                item.setCreateAccount("FIN-SYS");
                item.setUpdateAccount("FIN-SYS");
                return item;
            }
        });
    }
}
