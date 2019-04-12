package com.cp.jinzhou.core.service;

import com.cp.jinzhou.core.entity.UserRole;

import java.util.List;

public interface IUserRoleService {

    List<UserRole> findAll(int userId);
}
