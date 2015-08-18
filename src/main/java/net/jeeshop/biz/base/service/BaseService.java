package net.jeeshop.biz.base.service;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService<E extends PagerModel> implements Services<E>{

    @Override
    public int insert(E e) {
        return 0;
    }

    @Override
    public int delete(E e) {
        return 0;
    }

    @Override
    public int deletes(String[] ids) {
        return 0;
    }

    @Override
    public int update(E e) {
        return 0;
    }

    @Override
    public E selectOne(E e) {
        return null;
    }

    @Override
    public E selectById(String id) {
        return null;
    }

    @Override
    public PagerModel selectPageList(E e) {
        return null;
    }

    @Override
    public List<E> selectList(E e) {
        return null;
    }
}
