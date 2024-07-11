package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.example.controller.CourseController.*(..))")
//    public void myPointcut(){}
//
//    @Before("myPointcut()")
//    public void log(){
//        logger.info("Info log......");
//    }

//    @Before("execution(* com.example.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("Info log......");
//    }

//    @Pointcut("execution(* com.example.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPc(){}
//
//    @Before("courseRepositoryFindByIdPc()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(),joinPoint.getTarget());
//    }

//    @Pointcut("within(com.example.controller..*)")
//    public void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation(){}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(),joinPoint.getTarget());
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation(){}
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(),joinPoint.getTarget());
//    }
//
//    @Pointcut("@annotation(com.example.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC(){}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(),joinPoint.getTarget());
//    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void afterReturningGetMappingAnnotation(){}

    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result){
        logger.info("After Returning -> Method: {}, Result: {}", joinPoint.getSignature(),result.toString());
    }



}
