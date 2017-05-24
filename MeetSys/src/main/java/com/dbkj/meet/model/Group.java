package com.dbkj.meet.model;

import com.dbkj.meet.model.base.BaseGroup;
import com.dbkj.meet.utils.SqlUtil;
import com.jfinal.plugin.activerecord.*;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Group extends BaseGroup<Group> {
	public static final Group dao = new Group();

	public int deleteByCompanyId(long id){
		return Db.update(SqlUtil.getSql("deleteByCompanyId",this),id);
	}

	public int deleteByDeparmentId(long id){
		return Db.update(SqlUtil.getSql("deleteByDeparmentId",this),id);
	}

	public List<Group> findByUserId(long id){
		return find(SqlUtil.getSql("findByUserId",this),id);
	}

	public Group findByNameAndUserId(String name,long uid){
		return findFirst(SqlUtil.getSql("findByNameAndUserId",this),name,uid);
	}
}
