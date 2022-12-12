package tn.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// Aspect / Advise / JointPoint / jointCut
@Component
@Aspect
@Slf4j
public class Logging {

	private long t1, t2;

	@Before("execution(* tn.spring.services.*.*(..))") //PointCut
	public void avant(JoinPoint thisJoinPoint) {
		t1 = System.currentTimeMillis();
		log.info("In the method"+ thisJoinPoint.getSignature().getName());
	}

	@After("execution(* tn.spring.services.*.*(..))")
	public void apres(JoinPoint thisJoinPoint) {
		t2 = System.currentTimeMillis();
		log.info("Exuction Time of methode " + thisJoinPoint.getSignature() + " is  " + (t2 - t1) + " ms");
		log.info("Out of the method (After)"+ thisJoinPoint.getSignature().getName());
	}
	

}