package net.jeeshop.web.controller.manage.cache;

import net.jeeshop.core.oscache.FrontCache;
import net.jeeshop.core.oscache.ManageCache;
import net.jeeshop.web.bean.ResultBean;
import net.jeeshop.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dylan on 15-9-5.
 */
@Controller
@RequestMapping("/manage/cache")
public class CacheController extends BaseController {

    @Autowired
    private ManageCache manageCache;
    @Autowired
    private FrontCache frontCache;

    @RequestMapping({"", "page"})
    public String showPage() {
        return "/manage/cache/cache";
    }

    /**
     * 加载后台缓存
     *
     * @return
     */
    @RequestMapping(value = "loadManageCache", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean loadManageCache() {
        logger.info("load manage cache...");
        try {
            manageCache.loadAllCache();
        } catch (Exception e) {
            logger.warn("加载后台缓存出现异常.", e);
            return errorResult("99", "系统异常");
        }
        return successResult();
    }

    /**
     * 加载前台缓存
     *
     * @return
     */
    @RequestMapping(value = "loadFrontCache", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean loadFrontCache() {
        logger.info("load front cache...");
        try {
            frontCache.loadAllCache();
        } catch (Exception e) {
            logger.warn("加载前台缓存出现异常.", e);
            return errorResult("99", "系统异常");
        }
        return successResult();
    }


    @RequestMapping(value = "loadFrontCacheDetail", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean loadFrontCacheDetail(String catalog) {
        logger.info("load front cache, catalog:{}", catalog);
        if (StringUtils.isBlank(catalog)) {
            return errorResult("10", "参数错误");
        }
        try {
            if ("activity".equals(catalog)) {
                frontCache.loadActivityMap();
                frontCache.loadActivityProductList();
                frontCache.loadActivityScoreProductList();
                frontCache.loadActivityTuanProductList();
            } else if ("indexImg".equals(catalog)) {
                frontCache.loadIndexImgs();
            } else if ("advert".equals(catalog)) {
                frontCache.loadAdvertList();
            } else if ("notifyTemplate".equals(catalog)) {
                frontCache.loadNotifyTemplate();
            } else if ("productStock".equals(catalog)) {
                frontCache.loadProductStock();
            } else if ("hotquery".equals(catalog)) {
                frontCache.loadHotquery();
            } else {
                return errorResult("10", "参数错误");
            }
        } catch (Exception e) {
            logger.warn("加载前台缓存出现异常.", e);
            return errorResult("99", "系统异常");
        }
        return successResult();
    }

    private ResultBean successResult() {
        return new ResultBean();
    }

    private ResultBean errorResult(String code, String msg) {
        return new ResultBean(code, msg);
    }
}
