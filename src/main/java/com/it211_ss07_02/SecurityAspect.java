package com.it211_ss07_02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    // Giả lập user hiện tại đang có quyền VIP (không phải ADMIN)
    private String currentUserRole = "VIP";

    @Before("execution(* com.it211_ss07_02.*.*(..))")
    public void verifyUser(JoinPoint joinPoint) {
        if (!"ADMIN".equals(currentUserRole)) {
            System.out.println("!! TRUY CẬP BỊ TỪ CHỐI !! User không có quyền.");
            // Ném ngoại lệ RuntimeException để chặn đứng hành động thêm sản phẩm
            throw new RuntimeException("!! TRUY CẬP BỊ TỪ CHỐI !! User không có quyền thực hiện hành động này.");
        }
    }
}