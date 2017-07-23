package cn.boc.sh.campus.myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTransportTestTask {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private MyTestService MyTestService;
	
	public void excuteAction(){
		System.out.println("我是Transport 准备进行代理模式");
		
		MyTestService.myServiceTest();
		
	}

	public MyTestService getMyTestService() {
		return MyTestService;
	}

	public void setMyTestService(MyTestService myTestService) {
		MyTestService = myTestService;
	}

	
	
	


}
