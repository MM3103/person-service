package liga.medical.medicalpersonservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.service.debug.DebugService;
import liga.medical.common.service.model.Debug;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingAdvice {

    private final DebugService debugService;

    @Pointcut(value = "execution(* liga.medical.medicalpersonservice.core.controller.*.*(..))")
    public void restPointcut() { }

    @Around("restPointcut()")
    public Object restControllerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Object[] array = pjp.getArgs();

        log.info(formatter.format(date) + " Вызван метод: " + methodName  + " из класса " + className + " с аргументами" + mapper.writeValueAsString(array) +
                ", пользователем: " + username);


        Object obj = null;

        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info(className + ":" + methodName + "() " + "Response: " + mapper.writeValueAsString(obj) +
                ": имя пользователя: " + username);


        return obj;
    }

}
