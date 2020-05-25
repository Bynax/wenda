package com.bohuanshi.wenda;

import com.bohuanshi.wenda.dao.QuestionDAO;
import com.bohuanshi.wenda.dao.UserDAO;
import com.bohuanshi.wenda.model.Question;
import com.bohuanshi.wenda.model.User;
import com.bohuanshi.wenda.service.QuestionService;
import com.bohuanshi.wenda.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/22 17:12
 * @Description:
 */

@SpringBootTest
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Test
    public void addUserTest() {
        Random random = new Random();
        for (int i = 2; i < 15; i++) {
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);
        }

    }

    @Test
    public void selectTest() {
        List<Question> questions = questionService.getLatestQuestions(0,0,10);
        for (Question question : questions) {
           if(userDAO.selectById(question.getUserId()) == null){
               System.out.println(question.getId());
               System.out.println(question.getUserId());
           }
        }
    }

    public void updateTest(){

    }

    @Test
    public void deleteUser(){
        userDAO.deleteById(2);
    }

    @Test
    void loginTest(){
        userService.login("xxx","xxx");
    }

}
