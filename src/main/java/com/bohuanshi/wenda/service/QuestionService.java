package com.bohuanshi.wenda.service;

import com.bohuanshi.wenda.dao.QuestionDAO;
import com.bohuanshi.wenda.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/23 17:08
 * @Description:
 */

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }
}
