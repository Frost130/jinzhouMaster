package com.cp.jinzhou.core.dao;

import com.cp.jinzhou.core.entity.LoginLog;
import org.springframework.data.repository.Repository;

public interface ILoginLogDao  extends Repository<LoginLog, Integer> {

    public LoginLog findFirstByUserIdOrderByIdDesc(int userId);
    public LoginLog save(LoginLog log);
}
