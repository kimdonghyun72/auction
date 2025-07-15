package com.cherishauction.auction.service;

import com.cherishauction.auction.dto.RegisterRequest;
import com.cherishauction.auction.dto.UserDto;
import com.cherishauction.auction.dto.UserProfileDto;
import com.cherishauction.auction.model.User;
import com.cherishauction.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public User registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setRoles("ROLE_USER");

        return userRepository.save(user);
    }

    // 특정 사용자 조회
    public UserDto getUserDtoByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::convertToDto)
                .orElse(null);
    }

    // 사용자 기본정보 수정 (기존 방식 유지)
    public UserDto updateUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다.");
        }

        User user = optionalUser.get();

        if (userDto.getEmail() != null && !userDto.getEmail().equals(user.getEmail())) {
            if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
                throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
            }
            user.setEmail(userDto.getEmail());
        }

        if (userDto.getName() != null) user.setName(userDto.getName());
        if (userDto.getPhone() != null) user.setPhone(userDto.getPhone());

        User updatedUser = userRepository.save(user);
        return convertToDto(updatedUser);
    }

    // 마이페이지 프로필 수정
    public void updateUserProfile(String username, UserProfileDto profileDto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        if (profileDto.getEmail() != null && !profileDto.getEmail().equals(user.getEmail())) {
            if (userRepository.findByEmail(profileDto.getEmail()).isPresent()) {
                throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
            }
            user.setEmail(profileDto.getEmail());
        }

        if (profileDto.getName() != null) user.setName(profileDto.getName());
        if (profileDto.getPhone() != null) user.setPhone(profileDto.getPhone());

        userRepository.save(user);
    }

    public UserDto getUserDtoById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    private UserDto convertToDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        return dto;
    }
}
