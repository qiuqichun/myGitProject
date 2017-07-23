package mytests;

import myServices.AlbumListServices;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;



public class TestA {

	public static void main(String[] args) {
		new ContextLoaderListener();

		new StrutsPrepareAndExecuteFilter();


		new SqlSessionFactoryBean();

		new MapperFactoryBean();
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AlbumListServices bean = ac.getBean(AlbumListServices.class);
		int selectCount = bean.selectCount();
		System.out.println(selectCount);
		

	}

}
