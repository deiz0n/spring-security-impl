package com.deiz0n.springsecurity.domain.enums;

public enum Role {

    ADMIN("admin"),
    EMPLOYEE("employee"),
    TRAINEE("trainee");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
