/**
 * 
 */
package cn.boc.sh.sfjh.opt.sms.model;

import java.io.Serializable;

import cn.boc.sh.sfjh.otp.model.OTP;

/**
 * 手机短信一次性密码实体
 * 
 * @author josh
 * 
 */
public class SmsOTP extends OTP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 251584647642840717L;
	// 序号
	private Long verifySeq;
	// 手机号码
	private String mobileNo;
	
	
	public SmsOTP(){
		
		super();
	}

	public Long getVerifySeq() {
		return verifySeq;
	}

	public void setVerifySeq(Long verifySeq) {
		this.verifySeq = verifySeq;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
