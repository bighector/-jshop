/**
 * 2012-7-5
 * jqsl2012@163.com
 */
package net.jeeshop.biz.system.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域节点，每一个AreaItem对应一个节点
 * @author alafighting
 */
public class AreaItem {
    private Long id;// 0：根节点，否则是子节点
    private Long pid;// 父级节点
    private String name;// 区域名称

    private List<AreaItem> children;// 子节点

    public AreaItem() {
        super();
    }
    public AreaItem(String name, List<AreaItem> children) {
        super();
        this.name = name;
        this.children = children;
    }

    @Override
    public String toString() {
        return "AreaItem{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    public boolean isRoot() {
        return new Long(0).equals(pid);
    }

    public void addClild(AreaItem item) {
        if (children == null) {
            children = new ArrayList<AreaItem>();
        }
        children.add(item);
    }

    public List<AreaItem> getChildren() {
        return children;
    }

    public void setChildren(List<AreaItem> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

}
