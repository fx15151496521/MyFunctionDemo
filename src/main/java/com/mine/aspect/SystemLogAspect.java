package com.mine.aspect;

import com.mine.annotation.SystemLogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <简述>
 *      操作日志监控切面
 * @Auther: feixiang
 * @Date: 2018/8/22 17:08
 * @Description:
 */
@Component
@Aspect
public class SystemLogAspect {

    @Pointcut("execution(* com.langdong.controller.*..*(..)) && !execution(* com.langdong.controller.BaseController*..*(..))")
    public void allControllerMethodsPointcut() {

    }

    @Before(value = "allControllerMethodsPointcut()")
    public void saveSystemLog(JoinPoint joinPoint) throws ClassNotFoundException {
        // 拿到切点的类名、方法名、方法参数
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        // 反射加载切点类，遍历类中所有的方法
        Class<?> targetClass = Class.forName(className);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            // 如果遍历到类中的方法名与切点的方法名一致，并且参数个数也一致，就说明切点找到了
            if (method.getName().equalsIgnoreCase(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    // 获取到切点上的注解
                    SystemLogAnnotation log = method.getAnnotation(SystemLogAnnotation.class);
                    if (log != null) {
                        // 获取注解中的日志信息，并输出
                        String description = log.description();
                        System.out.println(description);
                        break;
                    }
                }
            }
        }
    }
}
