package com.cp.jinzhou.core.service;

import com.cp.jinzhou.core.entity.RoleMenu;

import java.util.List;

public interface IRoleMenuService {

    List<RoleMenu> findAll(int roleId);
}
