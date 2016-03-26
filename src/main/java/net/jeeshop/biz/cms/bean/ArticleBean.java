package net.jeeshop.biz.cms.bean;

import java.util.List;

import net.jeeshop.biz.cms.model.Article;
import net.jeeshop.biz.cms.model.ArticleCategory;

/**
 * Created by pingge on 2016/1/15.
 */
public class ArticleBean extends Article {
	private static final long serialVersionUID = 8350875921506511461L;
	private List<ArticleCategory> articleCatalog ;
	
	
	public List<ArticleCategory> getArticleCatalog() {
		return articleCatalog;
	}
	public void setArticleCatalog(List<ArticleCategory> articleCatalog) {
		this.articleCatalog = articleCatalog;
	}

}
