package com.cherishauction.auction.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/api/session-check")
    public ResponseEntity<String> sessionCheck(HttpSession session) {
        if (session == null || session.getAttribute("SPRING_SECURITY_CONTEXT") == null) {
            // 세션이 없거나 인증 정보가 없으면 401 Unauthorized 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었습니다.");
        }
        // 세션이 유효하면 200 OK 반환
        return ResponseEntity.ok("세션이 유효합니다.");
    }
}
