package com.cherishauction.auction.controller;

import com.cherishauction.auction.security.CustomUserDetails;
import com.cherishauction.auction.dto.UserProfileDto;
import com.cherishauction.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyPageController {

    @Autowired
    private UserService userService;

    // 내 프로필 조회(GET)
    @GetMapping("/mypage")
    public Map<String, String> getMyProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Map<String, String> profile = new HashMap<>();
        profile.put("username", userDetails.getUsername());
        profile.put("email", userDetails.getEmail());
        profile.put("name", userDetails.getName());
        profile.put("phone", userDetails.getPhone());
        return profile;
    }

    // 내 프로필 수정(PUT)
    @PutMapping("/mypage")
    public ResponseEntity<?> updateMyProfile(@AuthenticationPrincipal CustomUserDetails userDetails,
                                             @RequestBody UserProfileDto userProfileDto) {
        userService.updateUserProfile(userDetails.getUsername(), userProfileDto);
        return ResponseEntity.ok("프로필 수정 완료");
    }
}
