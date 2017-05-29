package net.jeeshop.core.dao.page;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.jeeshop.core.ManageContainer;

/**
 * 分页模型，也是所有实体类的基类
 * 
 * @author huangf
 * 
 */
public class PagerModel implements ClearBean,java.io.Serializable {
	private int pageTotal; // 总数
	private List pageList = new ArrayList(); // 分页集合列表
	private int pageSize = ManageContainer.PAGE_SIZE;// 每页显示记录数
	private int offset; // 偏移量
	private int pagerSize;// 总页数
	protected String pagerUrl;//分页标签需要访问的ACTION地址
	private String pageid;
	private int recordsTotal;
	private int recordsFiltered;
	private int pageDraw;

	public String getPagerUrl() {
		return pagerUrl;
	}

	public void setPagerUrl(String pagerUrl) {
		this.pagerUrl = pagerUrl;
	}

	public int getPagerSize() {
		return pagerSize;
	}

	public void setPagerSize(int pagerSize) {
		this.pagerSize = pagerSize;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List getPageList() {
		return pageList == null ? new LinkedList() : pageList;
	}

	public void setPageList(List list) {
		this.pageList = list;
	}

	public String getPageid() {
		return pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	/*
         * (non-Javadoc)
         *
         * @see net.jeeshop.common.page.ClearBean#clear()
         */
	public void clear() {
		pageTotal = 0; // 总数
		pageList = null; // 分页集合列表
		offset = 0; // 偏移量
		pagerSize = 0;// 总页数
//		pagerUrl = null;//分页标签需要访问的ACTION地址
		recordsTotal = 0;
		pageid = null;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getPageDraw() {
		return pageDraw;
	}

	public void setPageDraw(int pageDraw) {
		this.pageDraw = pageDraw;
	}

	public String trim(String str){
		if(str==null){
			return null;
		}
		return str.trim();
	}
	
	public void clearList(List<String> list){
		if(list==null || list.size()==0){
			return;
		}
		list.clear();
		list = null;
	}

	public void clearSet(Set<String> set){
		if(set==null || set.size()==0){
			return;
		}
		set.clear();
		set = null;
	}
	
	public void clearListBean(List<PagerModel> list){
		if(list==null || list.size()==0){
			return;
		}
		for(int i=0;i<list.size();i++){
			ClearBean item = list.get(i);
			item.clear();
			item = null;
		}
		list.clear();
		list = null;
	}
	
	public void clearArray(String[] arr){
		if(arr==null || arr.length==0){
			return;
		}
		for(int i=0;i<arr.length;i++){
			arr[i] = null;
		}
		arr = null;
	}
	
	
	
	@Override
	public String toString() {
		return "pageTotal:"+ pageTotal +",pageList:"+ pageList +",offset:"+ offset;
	}
}
