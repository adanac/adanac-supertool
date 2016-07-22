package com.adanac.tool.supertool.thirdparty.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.jcabi.aspects.Loggable;
import com.jcabi.log.Logger;

/**
 *
 *
 * @author ch-hui
 * @date 2016年7月19日 下午3:00:45
 * @since 1.0.0
 */

@Aspect
@Component
public class AuditAspect {

	@Around("@annotation(loggable)")
	public Object aroundServiceLoggable(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		Logger.info(this, "method=%s(%s) | result=%s | 耗时=%s毫秒",
				MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName(), joinPoint.getArgs(), result,
				System.currentTimeMillis() - start);
		return result;
	}

}

