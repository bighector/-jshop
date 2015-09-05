package net.jeeshop.biz.base.service;

import net.jeeshop.biz.base.model.BaseModel;
import net.jeeshop.core.dao.page.PagerModel;

import java.util.List;

public interface BaseService<E extends BaseModel>{
    /**
     * 添加
     *
     * @param e
     * @return
     */
    public long insert(E e);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteById(long id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public int deletes(Long[] ids);

    /**
     * 修改
     *
     * @param e
     * @return
     */
    public int update(E e);

    /**
     * 根据ID查询一条记录
     *
     * @param id
     * @return
     */
    public E selectById(long id);

    /**
     * 分页查询
     *
     * @param e
     * @return
     */
    public PagerModel selectPageList(E e);

    /**
     * 根据条件查询所有
     * @return
     */
    public List<E> selectList(E e);
}
