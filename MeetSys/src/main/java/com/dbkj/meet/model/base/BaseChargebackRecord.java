package com.dbkj.meet.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseChargebackRecord<M extends BaseChargebackRecord<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setType(java.lang.Integer type) {
		set("type", type);
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public void setCaller(java.lang.String caller) {
		set("caller", caller);
	}

	public java.lang.String getCaller() {
		return get("caller");
	}

	public void setCallee(java.lang.String callee) {
		set("callee", callee);
	}

	public java.lang.String getCallee() {
		return get("callee");
	}

	public void setStartTime(java.util.Date startTime) {
		set("start_time", startTime);
	}

	public java.util.Date getStartTime() {
		return get("start_time");
	}

	public void setEndTime(java.util.Date endTime) {
		set("end_time", endTime);
	}

	public java.util.Date getEndTime() {
		return get("end_time");
	}

	public void setFee(java.math.BigDecimal fee) {
		set("fee", fee);
	}

	public java.math.BigDecimal getFee() {
		return get("fee");
	}

	public void setRid(java.lang.Integer rid) {
		set("rid", rid);
	}

	public java.lang.Integer getRid() {
		return get("rid");
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