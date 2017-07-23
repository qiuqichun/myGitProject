package cn.boc.sh.spark.action;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress ip = null;
		ip= InetAddress.getLocalHost();
		String hostName = ip.getHostName();
		System.out.println(hostName);
		String hostAddress = ip.getHostAddress();
		System.out.println(hostAddress);
		String canonicalHostName = ip.getCanonicalHostName();
		System.out.println(canonicalHostName);
		
		
		
	}
}
