package cn.wegoteam.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Staticdata;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StaticdataServiceTest {
     @Resource(name="staticdataService")
     private StaticdataServiceInter staticdataService;
     @Test
     public void testStaticService(){
    	 List<Staticdata> sds = staticdataService.findByHql(
 				"from Staticdata order by pcode,order desc");
    	if(sds!=null){
    		 System.out.println(sds.size());
    	 }else{
    		 System.out.println("该集合为空");
    	 }
    	
     }

}
