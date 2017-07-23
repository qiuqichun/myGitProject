/**
 * 
 */
package cn.boc.sh.sfjh.opt.sms.test;

import org.esbuilder.base.ServiceException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.boc.sfjh.commons.test.AbstractTest;
import cn.boc.sh.sfjh.opt.sms.service.ISmsOTPService;

/**
 * @author josh
 *
 */
public class SmsOTPTest extends AbstractTest {
	
	@Autowired
	private ISmsOTPService smsOTPService;
	
	@Test
	public void test() throws ServiceException{
		
		System.out.println(this.smsOTPService.verifySmsOTP(this.smsOTPService.createSmsOTP("13916086034").getCode(),"13916086034"));
		
	}

}
