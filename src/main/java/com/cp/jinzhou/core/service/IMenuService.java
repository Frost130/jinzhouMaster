package com.cp.jinzhou.core.service;

import com.cp.jinzhou.core.entity.Menu;

import java.util.List;

public interface IMenuService {

     List<Menu> findById(int id);
}
