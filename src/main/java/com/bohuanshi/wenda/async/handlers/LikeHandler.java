package com.bohuanshi.wenda.async.handlers;

import com.bohuanshi.wenda.async.EventHandler;
import com.bohuanshi.wenda.async.EventModel;
import com.bohuanshi.wenda.async.EventType;
import com.bohuanshi.wenda.model.Message;
import com.bohuanshi.wenda.model.User;
import com.bohuanshi.wenda.service.MessageService;
import com.bohuanshi.wenda.service.UserService;
import com.bohuanshi.wenda.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/26 09:50
 * @Description:
 */
@Component // 注解去掉就不能发消息了
public class LikeHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setFromId(WendaUtil.SYSTEM_USERID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());
        message.setContent("用户" + user.getName()
                + "赞了你的评论,http://127.0.0.1:8080/question/" + model.getExt("questionId"));

        messageService.addMessage(message);
    }


    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}
