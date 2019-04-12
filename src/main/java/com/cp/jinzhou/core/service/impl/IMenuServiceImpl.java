package com.cp.jinzhou.core.service.impl;

import com.cp.jinzhou.core.dao.IMenuDao;
import com.cp.jinzhou.core.entity.Menu;
import com.cp.jinzhou.core.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class IMenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;
    @Override
    public List<Menu> findById(int id) {
        return menuDao.findAllById(id);
    }
}
