package cn.boc.sh.sfjh.opt.sms.dao;

import java.util.Date;

import org.esbuilder.business.dao.IMybatisBaseDao;

import cn.boc.sh.sfjh.opt.sms.model.SmsOTP;

/**
 * 手机短信一次性密码Dao
 * 
 * @author josh
 * 
 */
public interface ISmsOTPDao extends IMybatisBaseDao<SmsOTP, Long> {
	
	public SmsOTP selectByMobileNo(String mobileNo);

	public Integer deleteExpiredBefore(Date theDate);

	public void create(SmsOTP dynamicPasswd);
	
}
