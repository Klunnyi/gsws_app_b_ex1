package main.aspects;

import lombok.Setter;
import main.model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Setter
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        Object returnedByMethod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;
    }


//    @Around("execution(* main.services.*.*(..))")
//    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("Method will execute");
//        joinPoint.proceed();
//        logger.info("Method executed");
//    }

//    @Around("execution(* main.services.CommentService.publishComment(..))")
//    public String log(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Comment comment = new Comment("test", "test");
//        Object[] arguments = {comment};
//
//        System.out.println(1);
//
//        String s  =  (String) joinPoint.proceed(arguments);
//
//        System.out.println(s);
//
//        return comment.getAuthor();
//    }

}
