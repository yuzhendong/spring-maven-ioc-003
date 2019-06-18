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

/*�ύ��spring�����γ�bean*/
@Service
/*�ύ��spring�����γ�һ������*/
@Aspect
@Order(1)
public class LogAspect {
	
/*	@Pointcut("execution(* baens.service.*.update(..))") //���������   �����ڷ���
    void pointcutmethod(){
     } */
	//@Before("bean(petServiceImpl)")  ������xxxService���µ����з���
	//@Before("bean(*ServiceImpl)")  ����������ServiceImplΪ��׺����
/*	@Before("execution(* beans.*.updateObject(..))")
	public void beforeObject(JoinPoint point){
		System.out.println("BeforeJnintpoint��"+point.getSignature().getName());
		//System.out.println(this);
	}
	@AfterReturning("execution(* beans.*.updateObject(..))") 
	public void afterObject(JoinPoint point){
		System.out.println("AfterJnintpoint��"+point.getSignature().getName());
	}*/
	/**
	 * �쳣֪ͨ�������׳��쳣�Ժ�ִ��
	 */
	@AfterThrowing("execution(* beans.*.updateObject(..))") 
	public void Method(){
		
	}
	/**
	 * ����֪ͨ ������ִ�н����Ժ�ִ�� ���൱��finaly�����
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
			result = p.proceed();//�ײ���Զ�����Ŀ��ķ���
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
