package com.cp.jinzhou.core.service.impl;

import com.cp.jinzhou.core.dao.IUserRoleDao;
import com.cp.jinzhou.core.entity.UserRole;
import com.cp.jinzhou.core.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class IUserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public List<UserRole> findAll(int userId) {
        return userRoleDao.findAllByUserId(userId);
    }
}
