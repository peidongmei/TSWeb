package com.igeek11.bishe.dao;

import java.util.List;

import com.igeek11.bishe.bean.Question;

public interface IQuestionDao {

	int studentUpquestion(Question question);

	List<Question> queryquestion(Question question);

	Question questionUpdate1(String queno);

	int deleteQuestion(int queno);

}
