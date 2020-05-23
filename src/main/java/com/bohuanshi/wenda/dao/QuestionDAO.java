package com.bohuanshi.wenda.dao;

import com.bohuanshi.wenda.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/23 15:58
 * @Description:
 */

@Mapper
@Repository
public interface QuestionDAO {


    int addQuestion(Question question);
    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);
}
