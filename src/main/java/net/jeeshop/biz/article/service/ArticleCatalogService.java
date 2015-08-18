package net.jeeshop.biz.article.service;

import net.jeeshop.client.ArticleCatalogMapper;
import net.jeeshop.core.Services;
import net.jeeshop.model.ArticleCatalog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dylan
 * @date 15/8/18 21:19
 * Email: dinguangx@163.com
 */
@Service
public class ArticleCatalogService {

    @Resource
    ArticleCatalogMapper articleCatalogMapper;

}
