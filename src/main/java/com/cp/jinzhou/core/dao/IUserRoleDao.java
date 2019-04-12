package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleDao extends JpaRepository<UserRole,Integer> {

    List<UserRole> findAllByUserId(int userId);
}
