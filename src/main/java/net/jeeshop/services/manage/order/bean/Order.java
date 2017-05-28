package net.jeeshop.services.manage.order.bean;import java.io.Serializable;import java.util.List;import net.jeeshop.services.manage.orderdetail.bean.Orderdetail;import net.jeeshop.services.manage.orderlog.bean.Orderlog;import net.jeeshop.services.manage.orderpay.bean.Orderpay;import net.jeeshop.services.manage.ordership.bean.Ordership;import net.jeeshop.services.manage.product.bean.Product;public class Order extends net.jeeshop.services.common.Order implements Serializable {	private static final long serialVersionUID = 1L;	private String updateAmount;//是否修改过订单总金额	private Orderpay orderpay = new Orderpay();//支付记录	private String tradeNo;//支付宝交易号，以后用来发货	private List<Orderdetail> orderdetail;// 订单明细集合	private List<Product> productList;// 订单项对应的产品集合	private List<Orderpay> orderpayList;//支付记录	private Ordership ordership;//订单配送记录	private List<Orderlog> orderlogs;//订单日志记录	private boolean hasGift;//true:此订单包含赠品		@Deprecated	private String type;// 操作类型	private String updatePayMoneryRemark;//修改订单金额备注		/*	 * 查询条件	 *///	private String startDate;//订单开始时间//	private String endDate;//订单结束时间	private String statusStr;//订单状态的字符串形式	private String refundStatusStr;//订单退款状态的字符串形式	private String paystatusStr;//订单支付状态的字符串形式	public void clear() {		super.clear();		updateAmount = null;		updatePayMoneryRemark = null;		if (orderdetail != null) {			orderdetail.clear();		}		orderdetail = null;		if (productList != null) {			productList.clear();		}		productList = null;				if (orderpayList != null) {			orderpayList.clear();		}		orderpayList = null;				if(ordership!=null){			ordership.clear();			ordership = null;		}				hasGift = false;		type = null;				startDate = null;		endDate = null;				orderpay.clear();				if(this.orderlogs!=null && this.orderlogs.size() > 0){			for(int i=0;i<orderlogs.size();i++){				orderlogs.get(i).clear();			}			orderlogs.clear();		}		this.orderlogs = null;		statusStr = null;		refundStatusStr = null;		paystatusStr = null;		tradeNo=null;	}	public String getType() {		return type;	}	public void setType(String type) {		this.type = type;	}	public List<Product> getProductList() {		return productList;	}	public void setProductList(List<Product> productList) {		this.productList = productList;	}	public List<Orderpay> getOrderpayList() {		return orderpayList;	}	public void setOrderpayList(List<Orderpay> orderpayList) {		this.orderpayList = orderpayList;	}	public void setOrdership(Ordership ordership) {		this.ordership = ordership;	}//	public String getStartDate() {//		return startDate;//	}//	public void setStartDate(String startDate) {//		this.startDate = startDate;//	}//	public String getEndDate() {//		return endDate;//	}//	public void setEndDate(String endDate) {//		this.endDate = endDate;//	}	public Orderpay getOrderpay() {		return orderpay;	}	public void setOrderpay(Orderpay orderpay) {		this.orderpay = orderpay;	}	public List<Orderlog> getOrderlogs() {		return orderlogs;	}	public void setOrderlogs(List<Orderlog> orderlogs) {		this.orderlogs = orderlogs;	}	public String getStatusStr() {		return statusStr;	}	public void setStatusStr(String statusStr) {		this.statusStr = statusStr;	}	public String getPaystatusStr() {		return paystatusStr;	}	public void setPaystatusStr(String paystatusStr) {		this.paystatusStr = paystatusStr;	}	public String getUpdatePayMoneryRemark() {		return updatePayMoneryRemark;	}	public void setUpdatePayMoneryRemark(String updatePayMoneryRemark) {		this.updatePayMoneryRemark = updatePayMoneryRemark;	}	public String getTradeNo() {		return tradeNo;	}	public void setTradeNo(String tradeNo) {		this.tradeNo = tradeNo;	}	public String getRefundStatusStr() {		return refundStatusStr;	}	public void setRefundStatusStr(String refundStatusStr) {		this.refundStatusStr = refundStatusStr;	}	public String getUpdateAmount() {		return updateAmount;	}	public void setUpdateAmount(String updateAmount) {		this.updateAmount = updateAmount;	}	public List<Orderdetail> getOrderdetail() {		return orderdetail;	}	public void setOrderdetail(List<Orderdetail> orderdetail) {		this.orderdetail = orderdetail;	}	public Ordership getOrdership() {		return ordership;	}	public boolean isHasGift() {		return hasGift;	}	public void setHasGift(boolean hasGift) {		this.hasGift = hasGift;	}}