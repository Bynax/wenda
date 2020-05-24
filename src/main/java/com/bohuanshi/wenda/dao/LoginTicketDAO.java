package com.bohuanshi.wenda.dao;

import com.bohuanshi.wenda.model.LoginTicket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginTicketDAO {

    int addTicket(LoginTicket ticket);

    LoginTicket selectByTicket(String ticket);

    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

}
