package com.dbkj.meet.model;

import com.dbkj.meet.dic.Constant;
import com.dbkj.meet.model.base.BaseAccountBalance;
import com.dbkj.meet.utils.SqlUtil;
import com.jfinal.plugin.activerecord.*;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class AccountBalance extends BaseAccountBalance<AccountBalance> {
	public static final AccountBalance dao = new AccountBalance();
	//公司套餐id列名
	public final String PID="pid";
	//公司id列名
	public final String CID="cid";
	//余额id列名
	public final String BID="bid";
	//呼入计费模式列名
	public final String CALLIN_MODE="callin_mode";
	//公司名称列名
	public final String NAME="name";
	//账户余额列名
	public final String BALANCE="balance";
	//套餐名称列名
	public final String PNAME="pname";
	//呼入计费模式列名
	public final String CALLIN_RATE="callin_rate";
	//超方费率列名
	public final String PASS_RATE="pass_rate";
	//呼出模式列名
	public final String CALLOUT_MODE="callout_mode";
	//呼出费率
	public final String CALLOUT_RATE="callout_rate";
	//短信计费费率列名
	public final String SMS_RATE="sms_rate";
	//包月方数
	public final String COUNT="count";

	public Page<com.jfinal.plugin.activerecord.Record> getPage(Map<String,Object> map){
		int currentPage=1;
		int pageSize= Constant.DEFAULT_PAGE_SIZE;

		StringBuilder whereSql=new StringBuilder(50);
		List<Object> params = new ArrayList<Object>();
		for(Map.Entry entry:map.entrySet()){
			if(entry.getValue()!=null){
				String key=entry.getKey().toString();
				if(Constant.CURRENT_PAGE_KEY.equals(key)||Constant.PAGE_SIZE_KEY.equals(key)){
					continue;
				}
				if(key.toLowerCase().contains("name")){
					whereSql.append(" WHERE ");
					whereSql.append("b.name");
					whereSql.append(" like ?");
					params.add("%"+entry.getValue()+"%");
				}
			}
		}
		Object countObj=map.get(Constant.CURRENT_PAGE_KEY);
		if(countObj!=null){
			currentPage=Integer.parseInt(countObj.toString());
		}

		Object sizeObj=map.get(Constant.PAGE_SIZE_KEY);
		if(sizeObj!=null){
			pageSize=Integer.parseInt(sizeObj.toString());
		}
		return Db.paginate(currentPage,pageSize, SqlUtil.getSql("getPage.select",this),
					SqlUtil.getSql("getPage.sqlExceptSelect",this).concat(whereSql.toString()),
					params.toArray(new Object[params.size()]));
	}

	/**
	 * 根据账户余额id和计费模式名称获取账户计费的相关信息
	 * @param id 账户余额表主键id
	 * @param modeName 计费模式name，为年份+月份，如201702
	 * @return
	 */
	public Record getAccountBalanceInfoById(long id,String modeName){
		return Db.findFirst(SqlUtil.getSql("getAccountBalanceInfoById",this),id,modeName);
	}

	/**
	 * 获取账户余额信息和公司名称
	 * @param id
	 * @return
	 */
	public Record getAccountBalanceWithCompanyNameById(long id){
		return Db.findFirst(SqlUtil.getSql("getAccountBalanceWithCompanyNameById",this),id);
	}

	/**
	 * 根据公司id获取公司的账户余额信息
	 * @param id
	 * @return
	 */
	public AccountBalance findByCompanyId(long id){
		return findFirst(SqlUtil.getSql("findByCompanyId",this),id);
	}
}