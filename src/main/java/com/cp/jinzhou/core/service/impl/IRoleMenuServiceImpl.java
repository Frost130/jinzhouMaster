package com.cp.jinzhou.core.service.impl;

import com.cp.jinzhou.core.dao.IRoleMenuDao;
import com.cp.jinzhou.core.entity.RoleMenu;
import com.cp.jinzhou.core.service.IRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class IRoleMenuServiceImpl implements IRoleMenuService {
    @Autowired
    private IRoleMenuDao roleMenuDao;
    @Override
    public List<RoleMenu> findAll(int roleId) {
        return roleMenuDao.findAllByRoleId(roleId);
    }
}
