package com.bohuanshi.wenda.async;

import com.alibaba.fastjson.JSONObject;
import com.bohuanshi.wenda.util.JedisAdapter;
import com.bohuanshi.wenda.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/26 09:26
 * @Description:
 */

@Service
public class EventProducer {
    @Autowired
    JedisAdapter jedisAdapter;

    // 将事件分发出去
    public boolean fireEvent(EventModel eventModel) {
        try {
            String json = JSONObject.toJSONString(eventModel);
            String key = RedisKeyUtil.getEventQueueKey();
            jedisAdapter.lpush(key, json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
