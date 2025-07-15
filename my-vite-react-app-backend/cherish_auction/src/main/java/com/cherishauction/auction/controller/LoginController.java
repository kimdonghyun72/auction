package com.cherishauction.auction.controller;

import com.cherishauction.auction.model.User;
import com.cherishauction.auction.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class LoginController {

    private final LoginService loginService; // 이제 이 서비스의 login 메서드는 Spring Security와 직접 통합되지 않습니다.

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // --- 기존의 @PostMapping("/login") 메서드를 제거하거나 주석 처리합니다. ---
    // Spring Security의 formLogin()이 로그인 요청을 직접 처리하므로,
    // 이 컨트롤러의 /api/login 엔드포인트는 더 이상 필요하지 않습니다.
    /*
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> loginRequest,
            HttpSession session
    ) {
        Map<String, String> response = new HashMap<>();
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        User user = loginService.login(username, password, session); // 이 loginService.login은 이제 Spring Security와 별개로 동작

        if (user == null) {
            response.put("message", "로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.put("message", "로그인 성공!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    */

    // 로그아웃은 여전히 세션 무효화가 필요할 수 있으므로 유지합니다.
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpSession session) {
        // Spring Security의 LogoutFilter가 로그아웃을 처리하지만,
        // 세션 무효화 등 추가적인 로직이 필요하다면 이 메서드를 사용할 수 있습니다.
        // 또는 Spring Security의 LogoutFilter에 의존하여 이 메서드를 제거할 수도 있습니다.
        loginService.logout(session); // 세션 무효화
        Map<String, String> response = new HashMap<>();
        response.put("message", "로그아웃 성공!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}