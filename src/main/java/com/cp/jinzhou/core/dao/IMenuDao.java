package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.Menu;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IMenuDao extends Repository<Menu,Integer> {

    List<Menu> findAll();

    List<Menu> findAllById(int id);
}
