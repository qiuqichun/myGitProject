package cn.boc.sh.campus.myTest;

import org.springframework.beans.factory.annotation.Autowired;

public class MyTestService {
	private MyTestServiceImpl myTestServiceImpl;
	public void myServiceTest () {
		System.out.println("service 接口  准备实现myserviceimpl");
		myTestServiceImpl.myTest();
	}
	public MyTestServiceImpl getMyTestServiceImpl() {
		return myTestServiceImpl;
	}
	public void setMyTestServiceImpl(MyTestServiceImpl myTestServiceImpl) {
		this.myTestServiceImpl = myTestServiceImpl;
	}
	
	
}
