package com.cherishauction.auction.service;

import com.cherishauction.auction.model.User;
import com.cherishauction.auction.repository.UserRepository;
import com.cherishauction.auction.security.CustomUserDetails; // CustomUserDetails 사용
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Spring Security 인증 시 호출되는 메서드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new CustomUserDetails(user); // 무한 루프 방지를 위해 DTO 기반 객체 반환
    }

    // ✅ 컨트롤러에서 호출되는 로그아웃 메서드 (세션 무효화)
    public void logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }
}
