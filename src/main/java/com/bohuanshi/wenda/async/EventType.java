package com.bohuanshi.wenda.async;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/26 09:16
 * @Description:
 */

public enum EventType {

    LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3);


    private int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
