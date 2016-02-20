package net.jeeshop.web.action.front.orders;import java.text.DecimalFormat;import java.util.LinkedList;import java.util.List;import java.util.Map;import net.jeeshop.core.FrontContainer;import net.jeeshop.core.kuaidi100Helper;import net.jeeshop.core.dao.page.PagerModel;import net.jeeshop.core.front.SystemManager;import net.jeeshop.services.front.account.bean.Account;import net.jeeshop.services.front.address.AddressService;import net.jeeshop.services.front.address.bean.Address;import net.jeeshop.services.front.area.bean.Area;import net.jeeshop.services.front.comment.CommentService;import net.jeeshop.services.front.comment.bean.Comment;import net.jeeshop.services.front.express.bean.Express;import net.jeeshop.services.front.order.OrderService;import net.jeeshop.services.front.order.bean.Order;import net.jeeshop.services.front.orderdetail.OrderdetailService;import net.jeeshop.services.front.orderdetail.bean.Orderdetail;import net.jeeshop.services.front.orderpay.OrderpayService;import net.jeeshop.services.front.orderpay.bean.Orderpay;import net.jeeshop.services.front.ordership.OrdershipService;import net.jeeshop.services.front.ordership.bean.Ordership;import net.jeeshop.services.front.product.ProductService;import net.jeeshop.services.front.product.bean.Product;import net.jeeshop.services.front.product.bean.ProductStockInfo;import net.jeeshop.web.action.front.FrontBaseController;import net.jeeshop.web.action.front.paygate.PayInfo;import net.jeeshop.web.util.RequestHolder;import org.apache.commons.lang.StringUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.*;import javax.servlet.http.HttpServletRequest;/** * 门户订单服务类 *  * @author Administrator *  */@Controller("frontOrderAction")@RequestMapping("order")public class OrderAction extends FrontBaseController<Order> {	private static final Logger logger = LoggerFactory.getLogger(OrderAction.class);	private static final long serialVersionUID = 1L;	@Autowired	private OrderService orderService;	@Autowired	private OrderdetailService orderdetailService;	@Autowired	private OrderpayService orderpayService;	@Autowired	private ProductService productService;	@Autowired	private CommentService commentService;	@Autowired	private OrdershipService ordershipService;	@Autowired	private AddressService addressService;	//	private List<Order> myOrders;//	private Map<String, Order> orderMap;////	private boolean is_test = false;//是否是测试状态//	private Product product;//用户进行评论时加载的商品信息//	private Comment comment;//用户是否进行过评价；如果此对象不为空，则用户进行过评价////	private String selectLeftMenu;//选中的个人中心的菜单项	@Override	public OrderService getService() {		return orderService;	}	public void setOrderService(OrderService orderService) {		this.orderService = orderService;	}	/**	 * 订单确认页面，点击这个页面的确认支付按钮则会跳转到支付宝等的支付页面	 * 	 * @return	 */	@RequestMapping("orderConfirm")	public String orderConfirm() {		return "/confirmOrder";	}	@RequestMapping(value = "pay", method = RequestMethod.POST)	public String pay(Order e, ModelMap model) throws Exception{		return insertAndPay(e, model);	}	/**	 * 创建订单，并跳转到支付页面让用户进行支付	 * 	 * @return	 * @throws Exception	 */	private String insertAndPay(Order e, ModelMap model) throws Exception {//		if(!TokenUtil.getInstance().isTokenValid(getRequest())){//			throw new Exception("表单重复提交了！");//		}				logger.info("==insertAndPay==addressId" + e.getSelectAddressID() + ",expressCode = " + e.getExpressCode() + ",otherRequirement = " + e.getOtherRequirement());		Account account = getLoginAccount();		if (account == null || StringUtils.isBlank(account.getAccount())) {			return page_toLoginRedirect;		}				if(StringUtils.isBlank(e.getSelectAddressID()) || StringUtils.isBlank(e.getExpressCode())){			throw new NullPointerException("非法请求！");		}		//从session中获取用户购买的商品列表		CartInfo cartInfo = getMyCart();		if (cartInfo == null || cartInfo.getProductList().size() == 0) {			throw new NullPointerException("购物车中没有可支付的商品!");		}				//检测商品是否都有库存,如果没有库存需要提醒用户//		synchronized (SystemManager.product_stock_lock) {			Map<String, ProductStockInfo> productStockMap = SystemManager.getInstance().getProductStockMap();			boolean no = false;			for (int i = 0; i < cartInfo.getProductList().size(); i++) {				Product product = cartInfo.getProductList().get(i);                if(productStockMap.get(product.getId())==null){					product.product_sorry_str = "抱歉，该商品目前库存不足！";					no = true;					continue;				}				ProductStockInfo stockInfo = productStockMap.get(product.getId());				if(product.getBuyCount() > stockInfo.getStock()){					//如果用户购买的某个商品的数量大于该商品的库存数，则提示					product.product_sorry_str = "抱歉，该商品目前库存不足！";					no = true;				}			}			//库存不足，则刷最后支付页面，提示用户某些商品的库存不足，请重新选购			if(no){				logger.warn("某些商品库存不足！请重新选购！");				return "redirect:/order/confirmOrder.html";			}			//			if(!no){//				//如果检查没有出现库存不足的情况，则进行砍库存操作//				for (int i = 0; i < cartInfo.getProductList().size(); i++) {//					Product product = cartInfo.getProductList().get(i);//					ProductStockInfo stockInfo = SystemManager.productStockMap.get(product.getId());//					stockInfo.setStock(stockInfo.getStock() - product.getBuyCount());//					stockInfo.setChangeStock(true);//					SystemManager.productStockMap.put(product.getId(),stockInfo);//				}//			}//		}				//获取配送方式		Express express = SystemManager.getInstance().getExpressMap().get(e.getExpressCode());		if(express==null){			throw new NullPointerException("没有编码为"+e.getExpressCode()+"的配送方式！本次请求视为非法！");		}				//创建订单对象		Order order = new Order();		order.setAccount(account.getAccount());		order.setQuantity(cartInfo.getProductList().size());		order.setRebate(1);		order.setStatus(Order.order_status_init);		order.setPaystatus(Order.order_paystatus_n);		order.setOtherRequirement(e.getOtherRequirement());//附加要求				//商品总金额//		double ptotal = 0d;		int score = 0;//订单积分 等于订单项中每个商品赠送的积分总和		//创建订单明细集合		List<Orderdetail> orderdetailList = new LinkedList<Orderdetail>();		for (int i = 0; i < cartInfo.getProductList().size(); i++) {			Product product = cartInfo.getProductList().get(i);			//			ProductStockInfo momeryProduct = SystemManager.productStockMap.get(product.getId());//			if(StringUtils.isNotBlank(momeryProduct.getActivityID())){//				Activity activity = SystemManager.activityMap.get(momeryProduct.getActivityID());//				String discountType = activity.getDiscountType();//				if(discountType.equals(Activity.activity_discountType_r)){//					////					double finalPrice = Double.valueOf(product.getNowPrice()) - Double.valueOf(activity.getDiscount());//					//				}else if(discountType.equals(Activity.activity_discountType_d)){//					//				}//			}						Orderdetail orderdetail = new Orderdetail();			orderdetail.setProductID(Integer.valueOf(product.getId()));			orderdetail.setGiftID(product.getGiftID());//商品赠品ID			orderdetail.setPrice(product.getNowPrice());//商品现价			orderdetail.setNumber(product.getBuyCount());//购买数			orderdetail.setFee("0");//配送费			orderdetail.setProductName(product.getName());			orderdetail.setTotal0(String.valueOf(Double.valueOf(orderdetail.getPrice()) * orderdetail.getNumber()));//订单项小计			orderdetail.setScore(product.getScore());//活的赠送的积分			if(product.getBuySpecInfo()!=null){				//按照规格计算				orderdetail.setSpecInfo("尺寸:"+product.getBuySpecInfo().getSpecSize()+",颜色:"+product.getBuySpecInfo().getSpecColor());//				ptotal+= Double.valueOf(product.getBuySpecInfo().getSpecPrice()) * product.getBuyCount();//				score+= product.getScore();			}else{			}//			ptotal+= Double.valueOf(product.getNowPrice()) * product.getBuyCount();			score+= product.getScore();			orderdetailList.add(orderdetail);		}		if(orderdetailList.size()==1){			order.setRemark(orderdetailList.get(0).getProductName());		}else{			order.setRemark("合并|"+orderdetailList.size()+"笔订单");		}		cartInfo.totalCacl();		order.setScore(score);		order.setExpressCode(express.getCode());//配送方式编码		order.setExpressName(express.getName());//配送方式名称		order.setFee(String.valueOf(express.getFee()));//订单配送费		order.setPtotal(cartInfo.getAmount());//订单商品总金额		order.setAmount(String.valueOf(Double.valueOf(cartInfo.getAmount())+Double.valueOf(order.getFee())));//订单总金额 = 内存订单总金额 + 总配送费		order.setAmountExchangeScore(cartInfo.getTotalExchangeScore());//订单总兑换积分。订单支付成功以后扣除				/**		 * 对金额进行格式化，防止出现double型数字计算造成的益出。		 */		logger.info("order.getAmount()="+order.getAmount());		order.setAmount(df.format(Double.valueOf(order.getAmount())));//订单总金额		order.setPtotal(df.format(Double.valueOf(order.getPtotal())));//订单商品总金额		order.setFee(df.format(Double.valueOf(order.getFee())));//订单总配送费				/**		 * 配送地址信息		 */		Ordership ordership = new Ordership();		ordership.setOrderid(order.getId());				Address address = addressService.selectById(e.getSelectAddressID());		if(address==null){			throw new NullPointerException("根据ID="+e.getSelectAddressID()+"查询不到配送地址信息！本次请求视为非法！");		}		logger.info(address.toString());				Area area = SystemManager.getInstance().getAreaMap().get(address.getProvince());//获取省份对象		String proinceName = area.getName();//省份名称		String cityName = null;//城市名称		String areaName = null;//区名称		List<Area> citys = area.getChildren();		if(citys!=null && citys.size()>0){			for(int i=0;i<citys.size();i++){				Area cityItem = citys.get(i);				if(cityItem.getCode().equals(address.getCity())){					cityName = cityItem.getName();					//获取所在区域名称					if(StringUtils.isNotBlank(address.getArea())){						List<Area> areaList = cityItem.getChildren();						if(areaList!=null && areaList.size()>0){							for(int m=0;m<areaList.size();m++){									areaName = areaList.get(m).getName();							}						}					}				}			}		}		ordership.setShipname(address.getName());		ordership.setShipaddress(proinceName+cityName+address.getAddress());		ordership.setProvinceCode(address.getProvince());		ordership.setProvince(proinceName);		ordership.setCityCode(address.getCity());		ordership.setCity(cityName);		ordership.setAreaCode(address.getArea());		ordership.setArea(areaName);		ordership.setPhone(address.getPhone());		ordership.setTel(address.getMobile());		ordership.setZip(address.getZip());		ordership.setSex("1");		logger.info(ordership.toString());				//创建订单并插入到数据库		orderService.createOrder(order, orderdetailList,ordership);				//清空购物车		cartInfo.clear();		cartInfo = null;		RequestHolder.getSession().setAttribute(FrontContainer.myCart, null);				//更新内存中的订单缓存数据//		if(SystemManager.ordersReport!=null){//			SystemManager.ordersReport.setNotPayCount(SystemManager.ordersReport.getNotPayCount()+1);//订单++////			SystemManager.ordersReport.getNotPayCount().incrementAndGet();//订单++//		}		return "redirect:/paygate/pay?orderId="+order.getId() + "&orderPayId="+order.getOrderpayID();	}	/**	 * 点击我的订单页面的未付款的订单进行付款操作,则跳转到付款页面进行付款	 * @return	 */	@RequestMapping("toPay")	public String toPay(){		if (getLoginAccount() == null) {			return page_toLogin;		}		String orderid = RequestHolder.getRequest().getParameter("id");		logger.error("orderid="+orderid);		if(StringUtils.isBlank(orderid)){			throw new NullPointerException();		}				Order order = orderService.selectById(orderid);		if(order==null){			throw new NullPointerException("根据订单号查询不到订单信息！");		}				Ordership ordership = ordershipService.selectOne(new Ordership(orderid));		if(ordership==null){			throw new NullPointerException("根据订单号查询不到配送信息！");		}				//创建支付记录对象		Orderpay orderpay = new Orderpay();		orderpay.setOrderid(orderid);		orderpay.setPaystatus(Orderpay.orderpay_paystatus_n);				orderpay.setPayamount(Double.valueOf(order.getAmount()));		orderpay.setPaymethod(Orderpay.orderpay_paymethod_alipayescow);		int orderpayID = orderpayService.insert(orderpay);		logger.debug("orderpayID="+orderpayID);				order.setOrderpayID(String.valueOf(orderpayID));				//查询配送地址信息		return "redirect:/paygate/pay?orderId="+order.getId() + "&orderPayId="+orderpayID;	}		/**	 * 用户进行评论提交	 * @return	 * @throws Exception 	 */	@RequestMapping(value = "doRate", method = RequestMethod.POST)	public String doRate() throws Exception{		Account acc = getLoginAccount();		if (acc == null) {			return page_toLogin;		}		logger.debug("doRate...");				int orderid = Integer.valueOf(RequestHolder.getRequest().getParameter("orderid").toString());		Order order = orderService.selectById(String.valueOf(orderid));		if (StringUtils.isNotBlank(order.getClosedComment())				&& order.getClosedComment().equals(Order.order_closedComment_y)) {			//订单的点评功能已被关闭。			throw new RuntimeException(FrontContainer.request_illegal_error);		}				/*		 * 用户可以对每个订单项对应的商品进行评价		 */		Orderdetail orderdetail = new Orderdetail();		orderdetail.setOrderID(orderid);		List<Orderdetail> list = orderdetailService.selectList(orderdetail);		List<Comment> comments = new LinkedList<Comment>();		for(int i=0;i<list.size();i++){			Orderdetail item = list.get(i);			//获取页面上填写的评论类容			String content = RequestHolder.getRequest().getParameter("product_"+item.getProductID());			if(StringUtils.isBlank(content)){				continue;			}			Comment c = new Comment();			c.setProductID(String.valueOf(item.getProductID()));			c.setOrderdetailID(item.getId());			c.setOrderID(String.valueOf(orderid));			c.setContent(content);			c.setStatus(Comment.comment_status_y);			c.setNickname(acc.getNickname());			c.setStar(5);			c.setAccount(acc.getAccount());			comments.add(c);		}		commentService.insertList(comments);		return ("redirect:rateSuccess");	}	@RequestMapping("rateSuccess")	public String rateSuccess(){		logger.error("rateSuccess...");		return "/rateSuccess";	}		/**	 * 支付成功后进行评价,转到评论页面	 * @return	 * @throws Exception 	 */	@RequestMapping("rate")	public String rate(@ModelAttribute("e")Order e, ModelMap model) throws Exception{		Account acc = getLoginAccount();		if (acc == null) {			return page_toLogin;		}//		String productID = getRequest().getParameter("productID");		String orderid = RequestHolder.getRequest().getParameter("orderid");		if(StringUtils.isBlank(orderid)){			throw new NullPointerException("参数异常！");		}				/*		 * 用户可以对每个订单项对应的商品进行评价		 */		Orderdetail orderdetail = new Orderdetail();		orderdetail.setOrderID(Integer.valueOf(orderid));		orderdetail.setIsComment(Orderdetail.orderdetail_isComment_n);		e.setRateOrderdetailList(orderdetailService.selectList(orderdetail));		e.setId(orderid);		if(e.getRateOrderdetailList()!=null && e.getRateOrderdetailList().size()==0){			e.setRateOrderdetailList(null);		}				//加载商品信息//		product = productService.selectById(productID);//		//加载以往用户的评价信息//		comment.clear();//		comment.setAccount(acc.getAccount());//		comment.setProductID(Integer.valueOf(productID));//		comment.setOrderID(Integer.valueOf(orderid));//		comment = commentService.selectOne(comment);//		if(comment==null){//			logger.error("还没有评价");//		}else{//			logger.error("已经评价过了");//		}				//加载指定商品的评论列表//		Comment commentParam = new Comment();//		commentParam.setProductID(Integer.valueOf(productID));//		selectCommentList(commentParam);		model.addAttribute("e", e);		return "/rate";	}		/**	 * 分页加载评论	 * @return	 * @throws Exception	 */	private PagerModel selectCommentList(Comment commentParam) throws Exception {		HttpServletRequest request = RequestHolder.getRequest();		int offset = 0;		if (request.getParameter("pager.offset") != null) {			offset = Integer					.parseInt(request.getParameter("pager.offset"));		}		if (offset < 0)			offset = 0;//		Comment comment = new Comment();		((PagerModel) commentParam).setOffset(offset);		PagerModel pager = commentService.selectPageList(commentParam);		if(pager==null)pager = new PagerModel();		// 计算总页数		pager.setPagerSize((pager.getTotal() + pager.getPageSize() - 1)				/ pager.getPageSize());		//		selectListAfter();		pager.setPagerUrl("rate");		return pager;	}		DecimalFormat df = new DecimalFormat("0.00");		/**	 * 查询我的订单列表信息	 */	@RequestMapping("selectList")	public String selectList(HttpServletRequest request, @ModelAttribute("e") Order e, ModelMap model) throws Exception {		int offset = 0;//分页偏移量		if (request.getParameter("pager.offset") != null) {			offset = Integer.parseInt(request.getParameter("pager.offset"));		}		if (offset < 0)			offset = 0;		e.setOffset(offset);		PagerModel pager = getService().selectPageList(e);		if (pager == null) {			pager = new PagerModel();		}		// 计算总页数		pager.setPagerSize((pager.getTotal() + pager.getPageSize() - 1)				/ pager.getPageSize());		pager.setPagerUrl("myCarts");		model.addAttribute("pager", pager);		return "redirect:/account/orders";	}	/**	 * 删除我的订单信息	 */	@RequestMapping("deletes")	public String deletes(String[] ids, HttpServletRequest request, @ModelAttribute("e") Order e, ModelMap model) throws Exception {		getService().deletes(ids);		return selectList(request, e, model);	}		/**	 * 退订或取消指定的订单	 * @return	 * @throws Exception	 */	@RequestMapping("cancel")	public String cancel() throws Exception {		return "";	}		/**	 * 读取指定订单的信息	 * @return	 */	@RequestMapping("read")	public String read(){				return "";	}		/**	 * 对指定的订单进行支付	 * @return	 *///	public String doPay(){//		if(1==1){//			throw new NullPointerException();//		}//		//		String orderID = getRequest().getParameter("orderID");//		e.clear();//		e.setId(orderID);//		e.setStatus(Order.order_status_init);//等待付款//		logger.error("orderid=" + orderID);//		orderService.update(e);//		return "doPay";//	}		/**	 * 查看订单详情	 * @return	 */	@RequestMapping("{orderId}")	public String orderDetail(@PathVariable("orderId") String id, ModelMap model){		Account acc = getLoginAccount();		if (acc == null) {			return page_toLogin;		}		logger.error("orderInfo...");		if(StringUtils.isBlank(id)){			throw new NullPointerException("订单ID不能为空！");		}				//查询订单信息		Order order = new Order();		order.setId(id);		order.setAccount(acc.getAccount());		List<Order> orders = orderService.selectOrderInfo(order);		if(orders==null || orders.size()==0){			throw new NullPointerException("根据订单ID查询不到订单信息！");		}		logger.error("orders.size="+orders.size());		Order e = orders.get(0);		e.setOrders(orders);		//查询订单配送信息		Ordership ordership = new Ordership();		ordership.setOrderid(id);		ordership = ordershipService.selectOne(ordership);		if(ordership==null){			throw new NullPointerException("根据订单ID查询不到订单配送信息！");		}		e.setOrdership(ordership);				//查询订单物流信息		e.setKuaid100Info(kuaidi100Helper.selectKuaidi100());		model.addAttribute("e", e);		return "/account/orderInfo";	}		/**	 * 查看物流信息	 * @return	 */	@RequestMapping("orderhipInfo")	public String orderhipInfo(){		logger.error("orderhipInfo...");		return "/account/orderhipInfo";	}	/**	 * 确认订单信息	 * @return	 */	@RequestMapping("confirmOrder")	public String confirmOrder(ModelMap model){		logger.error("confirmOrder..");		Account acc =getLoginAccount();		if (acc == null || StringUtils.isBlank(acc.getAccount())) {//			getSession().getAttribute(FrontContainer);			return page_toLoginRedirect;		}				//检查购买的商品是否超出可购买的库存数		CartInfo cartInfo = getMyCart();		if(cartInfo==null){			throw new NullPointerException("非法请求");		}				for(int i=0;i<cartInfo.getProductList().size();i++){			Product product = cartInfo.getProductList().get(i);			ProductStockInfo stockInfo = SystemManager.getInstance().getProductStockMap().get(product.getId());			if(stockInfo==null){				//商品已卖完或已下架，请联系站点管理员!				throw new RuntimeException("商品已卖完或已下架，请联系站点管理员!");			}else if(stockInfo.getStock() < product.getBuyCount()){				//购买的商品数超出库存数				throw new RuntimeException("商品已卖完或已下架，请联系站点管理员!");			}		}				//加载配送信息		Address add = new Address();		add.setAccount(acc.getAccount());		List<Address> addressList = addressService.selectList(add);		cartInfo.setAddressList(addressList);		if(addressList!=null && addressList.size()>0){//			boolean exist = false;			for(int i=0;i<addressList.size();i++){				Address addItem = addressList.get(i);				if(StringUtils.isNotBlank(addItem.getIsdefault()) && addItem.getIsdefault().equals("y")){					cartInfo.setDefaultAddessID(addItem.getId());					break;				}			}		}		model.addAttribute("myCart", cartInfo);		model.addAttribute("expressList", SystemManager.getInstance().getExpressMap().values());		return "confirmOrder";	}		/**	 * 支付成功后，回调请求跳转到的页面	 * @return	 */	@RequestMapping("paySuccess")	public String paySuccess(){		logger.info("paySuccess...");		return "paySuccess";	}}