package com.dbkj.meet.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseChargingMode<M extends BaseChargingMode<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setBid(java.lang.Long bid) {
		set("bid", bid);
	}

	public java.lang.Long getBid() {
		return get("bid");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setCount(java.lang.Long count) {
		set("count", count);
	}

	public java.lang.Long getCount() {
		return get("count");
	}

	public void setName(java.lang.Long name) {
		set("name", name);
	}

	public java.lang.Long getName() {
		return get("name");
	}

	public void setHandled(java.lang.Integer handled) {
		set("handled", handled);
	}

	public java.lang.Integer getHandled() {
		return get("handled");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setGmtCreate(java.util.Date gmtCreate) {
		set("gmt_create", gmtCreate);
	}

	public java.util.Date getGmtCreate() {
		return get("gmt_create");
	}

	public void setGmtModified(java.util.Date gmtModified) {
		set("gmt_modified", gmtModified);
	}

	public java.util.Date getGmtModified() {
		return get("gmt_modified");
	}

}
