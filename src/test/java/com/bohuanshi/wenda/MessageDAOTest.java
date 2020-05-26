package com.bohuanshi.wenda;

import com.bohuanshi.wenda.dao.MessageDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/26 10:36
 * @Description:
 */

@SpringBootTest
public class MessageDAOTest {
    @Autowired
    MessageDAO messageDAO;


    @Test
    public void getListTest(){
        messageDAO.getConversationList(15,0,10);
    }


}
