package net.jeeshop.services.common;import java.io.Serializable;import net.jeeshop.core.dao.page.PagerModel;public class Keyvalue extends PagerModel implements Serializable {	private static final long serialVersionUID = 1L;	private Long id;	private String key1;	private String value;	public void clear() {		super.clear();		id = null;		key1 = null;		value = null;	}	public Long getId() {		return id;	}	public void setId(Long id) {		this.id = id;	}	public String getKey1() {		return key1;	}	public void setKey1(String key1) {		this.key1 = key1;	}	public String getValue() {		return value;	}	public void setValue(String value) {		this.value = value;	}}