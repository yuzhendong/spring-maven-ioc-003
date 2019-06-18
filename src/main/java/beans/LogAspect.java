package beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/*提交给spring管理形成bean*/
@Service
/*提交给spring管理形成一个切面*/
@Aspect
@Order(1)
public class LogAspect {
	
/*	@Pointcut("execution(* baens.service.*.update(..))") //定义切入点   作用于方法
    void pointcutmethod(){
     } */
	//@Before("bean(petServiceImpl)")  作用于xxxService类下的所有方法
	//@Before("bean(*ServiceImpl)")  代表所有以ServiceImpl为后缀的类
/*	@Before("execution(* beans.*.updateObject(..))")
	public void beforeObject(JoinPoint point){
		System.out.println("BeforeJnintpoint："+point.getSignature().getName());
		//System.out.println(this);
	}
	@AfterReturning("execution(* beans.*.updateObject(..))") 
	public void afterObject(JoinPoint point){
		System.out.println("AfterJnintpoint："+point.getSignature().getName());
	}*/
	/**
	 * 异常通知，方法抛出异常以后执行
	 */
	@AfterThrowing("execution(* beans.*.updateObject(..))") 
	public void Method(){
		
	}
	/**
	 * 最终通知 ，方法执行结束以后执行 ，相当于finaly代码块
	 */
	@After("execution(* beans.*.updateObject(..))") 
	public void afterMethod(){
		
	}
	@Around("execution(* beans.*.updateObject(..))")
	//@Around("pointcutmethod()")
	public Object arroundMethod(ProceedingJoinPoint p){
		Object result=null;
		long t1=0;
		long t2=0;
		try {
			t1=System.nanoTime();
			System.out.println("starttime"+t1);
			result = p.proceed();//底层会自动调用目标的方法
			t2=System.nanoTime();
			System.out.println("endtime"+t2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			System.out.println("subtime:"+(t2-t1));
		}
		return result;
	}
	
}
