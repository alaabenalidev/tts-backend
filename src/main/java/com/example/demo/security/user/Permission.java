package com.example.demo.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),
    SUPERADMIN_READ("superadmin:read"),
    SUPERADMIN_UPDATE("superadmin:update"),
    SUPERADMIN_CREATE("superadmin:create"),
    SUPERADMIN_DELETE("superadmin:delete");

    @Getter
    private final String permission;
}
