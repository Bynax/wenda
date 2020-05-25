package com.bohuanshi.wenda.model;

import org.springframework.stereotype.Component;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/24 10:01
 * @Description:
 */

@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<>();
    public User getUser(){
        return users.get();
    }

    public void setUser(User user){
        users.set(user);
    }

    public void clear(){
        users.remove();
    }

    @Override
    public String toString() {
        return users.toString();
    }
}
