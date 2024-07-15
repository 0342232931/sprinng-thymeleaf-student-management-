package vn.ths.BTCuoiKhoa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import vn.ths.BTCuoiKhoa.dao.LoggerRepository;
import vn.ths.BTCuoiKhoa.entity.Logger;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private LoggerRepository loggerRepository;

    @AfterThrowing("execution (* vn.ths.BTCuoiKhoa.*(..))")
    public void AfterThrowing(JoinPoint joinPoint,Throwable ex) {
        System.out.println("Lỗi sảy tra trong phương thức " + joinPoint.getSignature().getName() + " là lỗi: " + ex.toString());
        Logger logger = new Logger();
        logger.setContent(ex.getMessage());
        loggerRepository.save(logger);
    }
}
