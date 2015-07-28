package com.kxm.kcgl.domain;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:08
 */
public class Func {
	private Long id;
	private String name;
	private String url;
	private int type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
