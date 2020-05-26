package com.bohuanshi.wenda.service;

import com.bohuanshi.wenda.dao.MessageDAO;
import com.bohuanshi.wenda.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/25 11:44
 * @Description:
 */

@Service
public class MessageService {
    @Autowired
    MessageDAO messageDAO;

//    select from_id, to_id, content, has_read, conversation_id, created_date , count(id) as id from ( select * from message where from_id=15 or to_id=15 order by created_date desc) tt group by conversation_id order by created_date desc limit 0, 10
// c.b.w.d.MessageDAO.getConversationList   : ==> Parameters: 15(Integer), 15(Integer), 0(Integer), 10(Integer)

    @Autowired
    SensitiveService sensitiveService;

    public int addMessage(Message message) {
        message.setContent(sensitiveService.filter(message.getContent()));
        return messageDAO.addMessage(message);
    }

    public List<Message> getConversationDetail(String conversationId, int offset, int limit) {
        return messageDAO.getConversationDetail(conversationId, offset, limit);
    }

    public List<Message> getConversationList(int userId, int offset, int limit) {
        return messageDAO.getConversationList(userId, offset, limit);
    }

    public int getConvesationUnreadCount(int userId, String conversationId) {
        return messageDAO.getConversationUnreadCount(userId, conversationId);
    }
}
