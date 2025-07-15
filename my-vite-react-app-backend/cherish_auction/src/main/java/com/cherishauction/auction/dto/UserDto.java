package com.cherishauction.auction.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String name;      // name으로 변경
    private String email;
    private String phone;
    private String roles;
    // createdAt, updatedAt 필요 시 추가
}