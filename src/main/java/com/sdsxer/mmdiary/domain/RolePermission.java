package com.sdsxer.mmdiary.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class RolePermission {

    @ManyToOne
    @JoinColumn(name = "role")
    private SystemRole role;
    @ManyToOne
    @JoinColumn(name = "permission")
    private SystemPermission permission;

    public SystemRole getRole() {
        return role;
    }

    public void setRole(SystemRole role) {
        this.role = role;
    }

    public SystemPermission getPermission() {
        return permission;
    }

    public void setPermission(SystemPermission permission) {
        this.permission = permission;
    }
}
