package com.kxm.kcgl.domain;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月28日 上午10:07:10
 */
public class UserRight {
	private Integer id;
	private Integer userId;
	private Integer rightId;
	public Integer getId() {
		return id;
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getRightId() {
		return rightId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}
}
