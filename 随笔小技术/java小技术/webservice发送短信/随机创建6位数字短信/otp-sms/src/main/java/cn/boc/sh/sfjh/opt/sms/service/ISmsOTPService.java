package cn.boc.sh.sfjh.opt.sms.service;

import org.esbuilder.base.ServiceException;

import cn.boc.sh.sfjh.opt.sms.model.SmsOTP;
import cn.boc.sh.sfjh.otp.service.IOTPService;


public interface ISmsOTPService extends IOTPService {

	SmsOTP createSmsOTP(String mobileNo) throws ServiceException;

	boolean verifySmsOTP(String code, String mobileNo)
			throws ServiceException;
	
}
