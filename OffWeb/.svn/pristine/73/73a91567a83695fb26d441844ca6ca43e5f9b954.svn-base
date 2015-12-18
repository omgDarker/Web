package cn.wegoteam.shop.test;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DBtest {
	@Test
    public void getConnection() throws SQLException{
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource da=(DataSource) ac.getBean("dataSource");
		System.out.println(da.getConnection());
    }
}
