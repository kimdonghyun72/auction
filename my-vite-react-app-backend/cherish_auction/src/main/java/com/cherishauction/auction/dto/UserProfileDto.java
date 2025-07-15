package com.cherishauction.auction.dto;

public class UserProfileDto {
    private String email;
    private String name;
    private String phone;

    // 기본 생성자
    public UserProfileDto() {}

    // getter / setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
