package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface IUserDao extends Repository<User, Short> {

    public User findById(int id);
    public User findByLoginName(String userName);
    public User findByLoginNameAndState(String loginName,String state);
    public boolean existsById(int id);

    public boolean existsByLoginName(String loginName);

    public void save(User user);
    @Transactional
    @Modifying
    @Query("update User a set a.userPwd = ?2 where a.id = ?1")
    public int updatePassword(int userId,String pwdMd5);

    @Transactional
    @Modifying
    @Query("update User a set a.state = ?2 where a.id = ?1")
    public int updateState(int id,Short State);

    public Page<User> findAll(Specification<User> specification, Pageable pageable);

}
