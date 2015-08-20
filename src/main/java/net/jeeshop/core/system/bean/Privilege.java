package net.jeeshop.core.system.bean;

import net.jeeshop.core.dao.page.PagerModel;

/**
 * 权限
 * @author huangf
 *
 */
public class Privilege extends PagerModel{
	private Long id;
	private Long rid;
	private Long mid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public void clear() {
		// TODO Auto-generated method stub
		this.id = null;
		this.mid = null;
		this.rid = null;
	}

}
