package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleDao extends JpaRepository<Role,Integer> {

    List<Role> findAll();

    List<Role> findAllById(int id);
}
