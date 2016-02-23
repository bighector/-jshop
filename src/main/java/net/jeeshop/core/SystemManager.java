package net.jeeshop.core;

import com.google.common.collect.Lists;
import net.jeeshop.biz.cms.bean.ArticleCatalogBean;
import net.jeeshop.biz.system.bean.SystemSettingBean;
import net.jeeshop.core.cache.CacheProvider;
import net.jeeshop.core.cache.SimpleCacheProvider;
import net.jeeshop.core.listener.SystemListener;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


/**
 * 系统管理类.
 * 1、负责管理system.properties的东东
 * 2、负责缓存管理
 * @author huangf
 */
public class SystemManager {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemManager.class);
	private static Properties p = new Properties();
    private static CacheProvider cacheProvider = new SimpleCacheProvider();
	private static SystemManager instance;

    @PostConstruct
    public void afterPropertiesSet(){
        instance = this;
    }
	/**
	 * 商品目录，树形结构
	 */
//	private List<Catalog> catalogs = new LinkedList<Catalog>();//产品目录列表
//    private List<Catalog> catalogsArticle = new LinkedList<Catalog>();//文章目录列表
//    private List<Attribute> attrs;//属性集合
//    private Map<String,Attribute> attrsMap = new HashMap<String, Attribute>();//属性集合map
//    private OrdersReport ordersReport = new OrdersReport();//后台首页,统计数据
//    private Map<String,MemberRank> accountRankMap = new TreeMap<String, MemberRank>();//会员等级表
//    private Map<String,NotifyTemplate> notifyTemplateMap;//邮件模板
//    private List<Product> hotSearchProductList;//热门搜索的商品列表
//    private String alipayConfig;//支付宝卖家账号
//    private String commentTypeCode;//启用的评论插件的代号
//    private List<HotQuery> hotqueryList;//热门查询列表
//	public static Map<Integer, Integer> catalogMap = new HashMap<Integer, Integer>();//目录表，key:目录ID，value:目录顶级PID
	
//	/**
//	 * 目录的MAP形式，具有层级关系。key：主类别ID，value：主类别对象，可以通过该对象的getChildren()方法获取该主类别的所有的子类别集合
//	 */
//	private Map<String,Catalog> catalogsMap = new HashMap<String,Catalog>();
//
//	/**
//	 * 目录的MAP形式，具有层级关系。key：主类别code，value：主类别对象，可以通过该对象的getChildren()方法获取该主类别的所有的子类别集合
//	 */
//	private Map<String,Catalog> catalogsCodeMap = new HashMap<String,Catalog>();
//
//	//商品库存应该使用JAVA类库中的读写锁，key:商品ID，value：商品对象
//	private ConcurrentMap<String, ProductStockInfo> productStockMap;// = new ConcurrentHashMap<String, ProductStockInfo>();//商品库存表
//	private  Object product_stock_lock = new Object();//商品库存锁，操作商品库存的时候需要进行加锁
//	/**
//	 * 促销的商品 top=10
//	 */
//	private List<List<Product>> goodsTopList;
////	public static List<IndexMenu> indexMenuList;
//	private List<Navigation> navigations;
//	private List<Product> hotProducts;//热门商品
//	private List<Product> historyProducts;//浏览过的商品历史列表，仅限于当前session中存储
//	private List<Product> newProducts;//新品商品
//	private List<Product> saleProducts;//特价商品
//	@Deprecated
//	private List<Product> suijiProducts;//随机推荐的商品
//	private List<IndexImg> indexImages;//门户滚动图片
//	@Deprecated
//	private List<News> news;//文章列表
//	@Deprecated
//
//	private List<Catalog> newsCatalogs;//文章目录。文章目前只有一级目录
//	private List<News> noticeList;//系统通知
//	private Map<String, Area> areaMap = new HashMap<String, Area>();//省市区集合
//	private Map<String,Express> expressMap;//前台订单支付页面--物流列表
//	private Map<String,Advert> advertMap;//广告列表
//
	private static Map<String,String> manageExpressMap = new HashMap<String, String>();//后台发货页面物流公司列表
//	private AliyunOSS aliyunOSS;//阿里云存储的配置信息
////	public static Task task;//系统定时任务
//	private List<Product> indexLeftProduct;//加载首页左侧的商品列表，此位置的商品从全局加载
//	private Map<String,Activity> activityMap = new HashMap<String, Activity>();//所有活动列表
//
//	/**
//	 * 促销活动的商品列表activity_discountType_c=c
//	 * key:【r:减免；d:折扣；s:双倍积分】
//	 * value:【商品列表ArrayList】
//	 */
//	private Map<String,List<Product>> activityProductMap = new HashMap<String, List<Product>>();
//	private List<Product> activityScoreProductList;//积分商城商品列表
//	private List<Product> activityTuanProductList;//团购活动商品列表
//
//
//	/////////////////后台缓存///////////////////
//	/**
//	 * 后台类目查询的JSON字符串缓存
//	 */
//	private String productCatalogJsonStr;//商品类目JSON字符串缓存
//	private String articleCatalogJsonStr;//缓存类目JSON字符串缓存

    public static SystemManager getInstance(){
        return instance;
    }

    static {
		init();
	}
	private static void init(){
		try {
			p.load(SystemListener.class
					.getResourceAsStream("/system.properties"));
//			code.load(new BufferedReader(new InputStreamReader(SystemListener.class
//					.getResourceAsStream("/code.properties"), "utf-8")));
			logger.info(p.toString());
//			log.info(code.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

        manageExpressMap.put("shunfeng", "顺风快递");
        manageExpressMap.put("ems", "EMS");
        manageExpressMap.put("shentong", "申通E物流");
        manageExpressMap.put("yuantong", "圆通速递");
        manageExpressMap.put("zhongtong", "中通速递");
        manageExpressMap.put("zhaijisong", "宅急送");
        manageExpressMap.put("yunda", "韵达快运");
        manageExpressMap.put("tiantian", "天天快递");
        manageExpressMap.put("lianbangkuaidi", "联邦快递");
        manageExpressMap.put("huitongkuaidi", "汇通快运");
	}
	
	public String getProperty(String key){
		return p.getProperty(key);
	}
	
	private Random random = new Random();
	
	/**
	 * 随机从图集里面选取一张图片
	 * @return
	 */
	public String getImageRandom(){
        SystemSettingBean systemSetting = getSystemSetting();
		if(systemSetting==null || systemSetting.getImagesList()==null || systemSetting.getImagesList().size()==0){
			logger.error("系统未设置图集，但广告位却设置了图集优先显示。请管理员立刻设置图集。");
			return null;
		}
		
		int n = random.nextInt(systemSetting.getImagesList().size());
		
		return systemSetting.getImageRootPath()+systemSetting.getImagesList().get(n);
	}

	/**
	 * 获取网站上下文路径/house
	 * 正式环境和测试环境获取上下文不一样
	 * @param request
	 * @return
	 */
//	public static String getContextPath(HttpServletRequest request){
//		if(Boolean.valueOf(getInstance().get("is_www"))){
//			return SystemManager.getInstance().get("contextPath");
//		}
//		return request.getContextPath();
//	}
	

    //应用缓存管理

    public CacheProvider getCacheProvider() {
        return cacheProvider;
    }

    public void setCacheProvider(CacheProvider cacheProvider) {
        SystemManager.cacheProvider = cacheProvider;
    }

    private static String buildKey(String key) {
        return "SystemManager." + StringUtils.trimToEmpty(key);
    }
    private static void putCacheObject(String key, Serializable cacheObject){
        String key1 = buildKey(key);
        if(cacheObject == null){
            cacheProvider.remove(key1);
        } else {
            cacheProvider.put(key1, cacheObject);
        }
    }
    private static <T extends Serializable> T getCacheObject(String key){
        return (T)cacheProvider.get(buildKey(key));
    }

    //系统设置
    public SystemSettingBean getSystemSetting() {
        return getCacheObject("systemSetting");
    }

    public void setSystemSetting(SystemSettingBean systemSetting) {
        putCacheObject("systemSetting", systemSetting);
    }

    /**
     * 文章目录列表
     * @return
     */
    public List<ArticleCatalogBean> getArticleCatalogs() {
    //    return getCacheObject("articleCatalogs");
    	return null;
    }

    public void setArticleCatalogs(List<ArticleCatalogBean> catalogsArticle) {
        putCacheObject("articleCatalogs", (Serializable)catalogsArticle);
    }

}
