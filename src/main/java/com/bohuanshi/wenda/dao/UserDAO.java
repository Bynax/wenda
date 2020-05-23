package com.bohuanshi.wenda.dao;

import com.bohuanshi.wenda.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// 从mybatis的角度说
@Mapper
@Repository // 从springboot的角度说
public interface UserDAO {
    int addUser(User user);

    User selectById(int id);

    void updatePassword(User user);

    void deleteById(int id);

    User selectByName(String name);


}
