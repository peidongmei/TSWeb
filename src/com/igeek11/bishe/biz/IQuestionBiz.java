package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.Question;

public interface IQuestionBiz {

	int studentUpquestion(Question question);

	List<Question> queryquestion(Question question);

	Question questionUpdate1(String queno1);

	int deleteQuestion(int questuno);

}
