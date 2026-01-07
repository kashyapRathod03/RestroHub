package com.restrohub.qrmenu.auth.service;

import com.restrohub.qrmenu.auth.dto.AuthResponse;
import com.restrohub.qrmenu.auth.dto.LoginRequest;
import com.restrohub.qrmenu.auth.dto.RefreshTokenRequest;

public interface AuthService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    void logout(String token);
}