package com.lwando.pos.system.configuration;

import com.zaxxer.hikari.pool.HikariProxyCallableStatement;

public class JwtConstant {
    public static final String JWT_SECRET = "my-super-secure-jwt-secret-key-which-is-at-least-32-bytes";
    public static final String JWT_HEADER = "Authorization";
}
