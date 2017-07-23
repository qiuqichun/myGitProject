package cn.boc.sfjh.commons.test;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

@WebService
public class myTest {
	

	public String tests(String f){
		return "success"+f;
	}
	
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8087/myService/tests", new myServiceImp());
		System.out.println("success");
	}
}
