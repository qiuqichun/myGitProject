package cn.boc.sfjh.commons.test;

import javax.jws.WebService;

@WebService(endpointInterface="cn.boc.sfjh.commons.test.myService")
public class myServiceImp implements myService{

	@Override
	public String tests(String f) {
		String ff=f;
		System.out.println("myTestSucess");
		return ff;
	}

}
