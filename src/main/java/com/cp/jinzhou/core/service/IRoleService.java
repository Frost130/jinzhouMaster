package com.cp.jinzhou.core.service;

import com.cp.jinzhou.core.entity.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findById(int id);
}
