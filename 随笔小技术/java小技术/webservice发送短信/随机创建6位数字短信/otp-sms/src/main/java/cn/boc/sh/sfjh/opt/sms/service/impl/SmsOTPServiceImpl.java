package cn.boc.sh.sfjh.opt.sms.service.impl;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.esbuilder.base.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.boc.sh.sfjh.opt.sms.dao.ISmsOTPDao;
import cn.boc.sh.sfjh.opt.sms.model.SmsOTP;
import cn.boc.sh.sfjh.opt.sms.service.ISmsOTPService;
import cn.boc.sh.sfjh.otp.model.OTP;
import cn.boc.sh.sfjh.otp.model.OTPAccepter;

@Service
@Transactional(readOnly = false)
public class SmsOTPServiceImpl implements ISmsOTPService {

	@Autowired
	private ISmsOTPDao smsOTPDao;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 最大未验证情况下的连续发送次数
	 */
	@Value("${otp.sms.maxUnVerifySendTimes:5}")
	public Integer maxUnVerifySendTimes;

	/**
	 * 最大连续验证错误次数
	 */
	@Value("${otp.sms.maxFailureTimes:3}")
	public Integer maxFailureTimes;

	@Value("${otp.sms.debug:false}")
	private boolean isDebugMode;

	/**
	 * 最大的TOKEN有效期，2分钟
	 */
	@Value("${smstoken.validSeconds.max:120}")
	public Integer maxTokenValidSeconds;

	public boolean verifySmsOTP(String code, String mobileNo)
			throws ServiceException {

		SmsOTP passwd = smsOTPDao.selectByMobileNo(mobileNo);

		if (passwd == null)
			throw new ServiceException(ERROR_DYNAMICPWD_NOTGET);

		if (isOverMaxFailureTimes(passwd))
			throw new ServiceException(ERROR_DYNAMICPWD_MAXFAILTIME);

		if (isOverValidTime(code.toUpperCase(), passwd)) {
			throw new ServiceException(ERROR_DYNAMICPWD_OVERVALIDTIME);
		}

		if (!isCorrectDynamicPass(code.toUpperCase(), passwd)) {
			throw new ServiceException(ERROR_DYNAMICPWD);
		}
		return true;
	}

	/**
	 * 创建Token,并返回Token序号
	 */
	@Transactional(readOnly = false)
	public SmsOTP createSmsOTP(String mobileNo) throws ServiceException {

		SmsOTP smsOTP = smsOTPDao.selectByMobileNo(mobileNo);

		// step1，如果动态密码表中无动态口令记录，或者记录时间已不是当日，直接生成新的记录。
		if (smsOTP == null || cleanExpiredSmsOTP(smsOTP)) {
			smsOTP = generateNewSmsOTP(mobileNo);
		} else {
			// step2
			if (isOverMaxUnVerifyTryTime(smsOTP))
				throw new ServiceException(ERROR_DYNAMICPWD_MAXSENDTIME);
			else
				smsOTP = updateDynamicPwd(smsOTP);
		}

		// logger.info("清除[{}]条超过基准线信息！",cleanExpriedToken());
		return smsOTP;
	}
	
	
	@Override
	public OTP createOTP(OTPAccepter accepter) throws ServiceException {
		return this.createSmsOTP(accepter.getId());
	}

	@Override
	public boolean verifyOTP(OTP otp, OTPAccepter accepter)
			throws ServiceException {
		return this.verifySmsOTP(otp.getCode(), accepter.getId());
	}
	
	

	@Transactional(readOnly = false)
	private SmsOTP generateNewSmsOTP(String credentialsId) {

		SmsOTP smsOTP = new SmsOTP();
		smsOTP.setVerifyDate(new Date());
		smsOTP.setCodeSeq(obtainCode());
		if (!isDebugMode) {
			smsOTP.setCode(obtainApplyCode());
		} else {
			smsOTP.setCode("888888");
		}
		smsOTP.setMobileNo(credentialsId);
		smsOTP.setVerifyFailureCount(0);
		smsOTP.setSendCount(0);
		logger.info("为手机【{}】创建新的动态密码，序号为【{}】", credentialsId,
				smsOTP.getCodeSeq());
		smsOTPDao.create(smsOTP);
		return smsOTP;
	}

	private SmsOTP updateDynamicPwd(SmsOTP smsOTP) {
		smsOTP.setVerifyDate(new Date());
		smsOTP.setCodeSeq(obtainCode());
		if (!isDebugMode) {
			smsOTP.setCode(obtainApplyCode());
		} else {
			smsOTP.setCode("888888");
		}
		smsOTP.setVerifyFailureCount(smsOTP.getVerifyFailureCount());
		smsOTP.setSendCount(smsOTP.getSendCount() + 1);
		logger.info("为手机【{}】创建新的动态密码，序号为【{}】", smsOTP.getMobileNo(),
				smsOTP.getCodeSeq());
		smsOTPDao.update(smsOTP);
		return smsOTP;
	}

	private boolean isOverMaxFailureTimes(SmsOTP smsOTP) {
		if (smsOTP.getVerifyFailureCount() > maxFailureTimes)
			return true;
		else
			return false;
	}

	private boolean isOverMaxUnVerifyTryTime(SmsOTP smsOTP) {
		if (smsOTP.getSendCount() > maxUnVerifySendTimes)
			return true;
		else
			return false;
	}

	private boolean isOverValidTime(String userSndPasswd, SmsOTP smsOTP) {
		Date validDate = DateUtils.addSeconds(smsOTP.getVerifyDate(),
				maxTokenValidSeconds);
		Date now = new Date();

		if (validDate.before(now)) {
			return true;
		}
		return false;

	}

	private boolean isCorrectDynamicPass(String userSndPasswd, SmsOTP smsOTP) {

		if (userSndPasswd == null || !userSndPasswd.equals(smsOTP.getCode())) {
			smsOTP.setVerifyFailureCount(smsOTP.getVerifyFailureCount() + 1);
			smsOTPDao.update(smsOTP);
			return false;
		}
		return true;

	}

	/**
	 * 清除过期的动态密码,如果已清除就返回true
	 * 
	 * @param dpasswd
	 */
	private boolean cleanExpiredSmsOTP(SmsOTP smsOTP) {
		Date date = new Date();
		if (!DateUtils.isSameDay(date, smsOTP.getVerifyDate())) {
			smsOTPDao.deleteById(smsOTP.getVerifySeq());
			return true;
		}
		return false;

	}

	/**
	 * 清除基准时间以前的动态密码数据
	 */
	public Integer cleanExpried() {
		Date thisDay = DateUtils.addSeconds(new Date(),
				-(maxTokenValidSeconds + 500));// +500是为了保险起见
		return smsOTPDao.deleteExpiredBefore(thisDay);
	}

	// 产生六位随即码
	private final static String[] str = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };

	public static String obtainApplyCode() {
		String applyCodes = "";
		for (int i = 0; i < 6; i++) {
			int index = (int) (Math.random() * 10);
			applyCodes += str[index];
		}
		return applyCodes;
	}

	// 随即产生两位数字
	private final static String[] str1 = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };

	public static String obtainCode() {
		String applyCodes = "";
		for (int i = 0; i < 2; i++) {
			int index = (int) (Math.random() * 10);
			applyCodes += str1[index];
		}
		return applyCodes;
	}

	


}
