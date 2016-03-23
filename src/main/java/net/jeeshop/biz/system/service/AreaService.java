package net.jeeshop.biz.system.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.system.bean.AreaItem;
import net.jeeshop.biz.system.bean.MenuItem;
import net.jeeshop.biz.system.bean.MenuType;
import net.jeeshop.biz.system.client.SysAreaMapper;
import net.jeeshop.biz.system.model.SysArea;
import net.jeeshop.biz.system.model.SysAreaExample;
import net.jeeshop.biz.system.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 区域管理
 * @author alafighting
 */
@Service
public class AreaService extends BaseService<SysArea, SysAreaExample> {

    @Autowired
    private SysAreaMapper sysAreaMapper;

    @Override
    protected BaseMapper<SysArea, SysAreaExample> getMapper() {
        return sysAreaMapper;
    }


    /**
     * 查询所有区域集合
     * @return
     */
    public Collection<AreaItem> loadAllAreas() {
        return loadAreasByParent(null);
    }

    /**
     * 根据父节点查询区域列表
     * @param pid 0-查询根节点
     * @return
     */
    public Collection<AreaItem> loadAreasByPid(long pid) {
        return loadAreasByParent(pid);
    }


    /**
     * 根据父节点查询区域列表
     * @param pid null-查询所有节点
     * @return
     */
    private Collection<AreaItem> loadAreasByParent(Long pid) {
        // 拼装查询条件
        SysAreaExample query = null;
        if (pid != null) {
            query = new SysAreaExample();
            query.createCriteria().andPidEqualTo(pid);
        }

        List<SysArea> areas = sysAreaMapper.selectByExample(query);
        Iterator<SysArea> iterator;

        // 创建集合
        LinkedHashMap<Long, AreaItem> root = new LinkedHashMap<Long, AreaItem>();
        // 循环添加到集合
        iterator = areas.iterator();
        while (iterator.hasNext()) 
        {
            SysArea area = iterator.next();
            AreaItem item = new AreaItem(area.getName(), null);
            item.setId(area.getId());
            item.setPid(area.getPid());
            item.setName(area.getName());

            if (item.getPid().equals(0) || item.getPid().equals(pid)) {
                root.put(item.getId(), item);
                iterator.remove();
            }
        }
        // 补充子节点(二级)
        iterator = areas.iterator();
        while (iterator.hasNext()) {
            SysArea area = iterator.next();
            AreaItem item = new AreaItem(area.getName(), null);
            item.setId(area.getId());
            item.setPid(area.getPid());
            item.setName(area.getName());

            AreaItem parentItem = root.get(item.getPid());
            if (parentItem != null) {
                parentItem.addClild(item);
                iterator.remove();
            }
        }
        // 补充子节点(三级)
        iterator = areas.iterator();
        while (iterator.hasNext()) {
            SysArea area = iterator.next();
            AreaItem item = new AreaItem(area.getName(), null);
            item.setId(area.getId());
            item.setPid(area.getPid());
            item.setName(area.getName());

            for (AreaItem parentItem : root.values()) {
                if (parentItem.getChildren() != null) {
                    for (AreaItem sub : parentItem.getChildren()) {
                        if (sub.getId() == item.getPid()) {
                            sub.addClild(item);
                            iterator.remove();
                            item = null;
                            break;
                        }
                    }

                    if (item != null) {
                        break;
                    }
                }
            }

            if (item != null) {
                logger.warn("区域项{}({})没有对应的父节点", item.getName(), item.getId());
            }
        }
        return root.values();
    }

    @Override
    public long insert(SysArea articleCatalog) {
        if (articleCatalog != null) {
            if (articleCatalog.getPid() == null) {
                articleCatalog.setPid(0L);
            }
        }
        return super.insert(articleCatalog);
    }

    @Override
    public int deleteById(long id) {
        int rows = 0;
        Collection<AreaItem> areas = loadAreasByParent(id);
        if (areas != null && !areas.isEmpty()) {
            Iterator<AreaItem> itemIterator = areas.iterator();
            while (itemIterator.hasNext()) {
                rows += deleteById(itemIterator.next().getId());
            }
        }
        return rows + super.deleteById(id);
    }
}
