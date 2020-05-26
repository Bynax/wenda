package com.bohuanshi.wenda.async;

import java.util.List;

public interface EventHandler {
    void doHandle(EventModel model); // 处理事件
    List<EventType> getSupportEventTypes(); // 注册本handler对哪些事件感兴趣
}
