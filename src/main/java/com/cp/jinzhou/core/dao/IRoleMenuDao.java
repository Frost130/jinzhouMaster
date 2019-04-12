package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleMenuDao extends JpaRepository<RoleMenu,Integer> {

    List<RoleMenu> findAllByRoleId(int roleId);
}
