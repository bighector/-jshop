package net.jeeshop.biz.base.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.jeeshop.biz.base.bean.PageQueryBean;
import net.jeeshop.biz.base.bean.PageBean;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.core.exception.JShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseService<E extends BaseModel, Example> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    abstract protected BaseMapper<E, Example> getMapper();

    @Transactional
    public long insert(E articleCatalog) {
        return getMapper().insert(articleCatalog);
    }

    @Transactional
    public int deleteById(long id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Transactional
    public int deletes(Long[] ids) {
        int cnt = 0;
        for (Long id : ids) {
            int i = deleteById(id);
            cnt += i;
        }
        return cnt;
    }

    @Transactional
    public int update(E articleCatalog) {
        return getMapper().updateByPrimaryKeySelective(articleCatalog);
    }

    public E selectById(long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    /**
     * 分页查询数据
     *
     * @param example
     * @param pageQueryBean
     * @return
     */
    public PageBean<E> selectPageList(Example example, PageQueryBean pageQueryBean) {
        initPageHelper(pageQueryBean);
        List<E> datas = getMapper().selectByExample(example);
        PageBean<E> pagerModel = new PageBean<E>();
        pagerModel.setList(datas);
        pagerModel.setRecordsTotal(((Page) datas).getTotal());
        pagerModel.setRecordsFiltered(pagerModel.getRecordsTotal());
        return pagerModel;
    }

    protected void initPageHelper(PageQueryBean pageQueryBean) {
        if (pageQueryBean.getLength() == PageQueryBean.UNLIMIT_LENGTH) {
            return;
        }
        if (pageQueryBean.getLength() <= 0) {
            pageQueryBean.setLength(PageQueryBean.DEFAULT_LENGTH);
        }
        PageHelper.startPage(pageQueryBean.getStart() / pageQueryBean.getLength() + 1, pageQueryBean.getLength());
    }

    public List<E> selectByExample(Example example) {
        return getMapper().selectByExample(example);
    }

    public E selectUniqueByExample(Example example) {
        List<E> list = getMapper().selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new JShopException("result size more than one.");
        }
        return list.get(0);
    }

}
