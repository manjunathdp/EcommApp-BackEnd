package com.ecommerce.project.security.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.util.List;

@Data

public class UserInfoResponse {

    private Long id;

    @JsonIgnore
    private String jwtToken;

    private String username;
    private List<String> roles;

    public UserInfoResponse(Long id, String username, List<String> roles, String jwtToken) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

    public UserInfoResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserInfoResponse(Long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }
}


