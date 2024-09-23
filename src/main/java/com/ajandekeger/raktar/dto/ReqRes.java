package com.ajandekeger.raktar.dto;

import com.ajandekeger.raktar.auth.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    int statusCode;
    String error;
    String message;
    String token;
    String refreshToken;
    String expirationTime;
    String username;
    String role;
    String pwd;
    Users user;
    List<Users> userList;


}
