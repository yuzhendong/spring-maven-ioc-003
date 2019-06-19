package test;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.PetService;


public class testPet {
	ClassPathXmlApplicationContext ctx;
	@Test
	public void testService(){
		ctx=
		new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		//petService获取的为PetService的代理对象
		PetService petService=(PetService)ctx.getBean("petServiceImpl");
		petService.saveObject();
		petService.updateObject();
		System.out.println(petService.getClass().getName());
		System.out.println("YUZHENDONGNIHAO");
	}
}
