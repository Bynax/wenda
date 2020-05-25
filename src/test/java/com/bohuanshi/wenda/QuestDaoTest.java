package com.bohuanshi.wenda;

import com.bohuanshi.wenda.dao.QuestionDAO;
import com.bohuanshi.wenda.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/23 16:23
 * @Description:
 */

@SpringBootTest
public class QuestDaoTest {


    @Autowired
    QuestionDAO questionDAO;

    @Test
    void addTest() {
        for (int i = 1; i < 11; i++) {
            Question question = new Question();
            question.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000 * 3600 * 5 * i);
            question.setCreatedDate(date);
            question.setUserId(i + 1);
            question.setTitle("hello");
            question.setContent("nice to meet u and i want to see u");
            questionDAO.addQuestion(question);
        }


    }

    @Test
    void selectTest(){
        questionDAO.getById(22);
    }
}
