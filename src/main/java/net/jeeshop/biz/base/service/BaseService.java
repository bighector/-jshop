package net.jeeshop.biz.base.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.model.ArticleCatalog;
import net.jeeshop.model.ArticleCatalogExample;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public abstract class BaseService<E extends BaseModel, Example> {
    abstract protected BaseMapper<E, Example> getMapper();

    public long insert(E articleCatalog) {
        return getMapper().insert(articleCatalog);
    }

    public int deleteById(long id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    public int deletes(Long[] ids) {
        int cnt = 0;
        for (Long id : ids) {
            int i = deleteById(id);
            cnt += i;
        }
        return cnt;
    }

    public int update(E articleCatalog) {
        return getMapper().updateByPrimaryKeySelective(articleCatalog);
    }

    public E selectById(long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    public PagerModel<E> selectPageList(Example example) {
        PageHelper.startPage(1, 10);
        List<E> catalogs = getMapper().selectByExample(example);
        PagerModel pagerModel = new PagerModel();
        pagerModel.setList(catalogs);
        pagerModel.setTotal(((Page) catalogs).getTotal());
        return pagerModel;
    }

    public List<E> selectByExample(Example example) {
        return getMapper().selectByExample(example);
    }

}
