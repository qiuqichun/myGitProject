package cn.boc.sfjh.commons.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class myClient {
 public static void main(String[] args) {
	try {
		URL url = new URL("http://localhost:8087/myService/tests?wsdl");
		QName qName = new QName("http://test.commons.sfjh.boc.cn/","myServiceImpService");
		Service create = Service.create(url,qName);
		 myService port = create.getPort(myService.class);
		String tests = port.tests("hhs");
		System.out.println(tests);
		
		
		
	} catch (MalformedURLException e) {
		// TODO 注意！异常输出到日志时，要根据实际情况输出关键的逻辑输入数据
		// e.printStackTrace();
		
	}
}
}
