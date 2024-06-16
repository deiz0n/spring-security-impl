package com.deiz0n.springsecurity.domain.dtos;

import com.deiz0n.springsecurity.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private Role role;

}
