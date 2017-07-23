package cn.boc.sh.spark.action;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class threadTest {
	private JProgressBar createJProgressBar(JFrame jFrame){
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("上传白名单");
		jFrame.setSize(300, 100);
		jFrame.setBounds(600, 300, 300, 100);
		jFrame.setVisible(true);
		Container contentPane = jFrame.getContentPane();
		JProgressBar jprogress = new JProgressBar();
		contentPane.add(jprogress,BorderLayout.NORTH);
		jprogress.setStringPainted(true);
		return jprogress;
	}
	
	public static void main(String[] args){
		JFrame jFrame = new JFrame();
		JProgressBar progressBar = new threadTest().createJProgressBar(jFrame);
		int size=879054;
		int count=0;
		for (int i = 1; i <= size; i++) {
			System.out.println("增加了"+i);
			count=i*100/size;
			System.out.println("此时进程："+count);
			progressBar.setValue(count);
			if(i==size){
				jFrame.setVisible(false);
			}
		}
	}
}
