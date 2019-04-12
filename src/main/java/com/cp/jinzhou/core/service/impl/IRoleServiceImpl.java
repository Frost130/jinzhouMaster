package com.cp.jinzhou.core.service.impl;

import com.cp.jinzhou.core.dao.IRoleDao;
import com.cp.jinzhou.core.entity.Role;
import com.cp.jinzhou.core.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findById(int id) {

        return roleDao.findAllById(id) ;
    }
}
