package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.Answer;

public interface IAnswerBiz {

	int teacherAnswer(Answer answer1);

	int answerDelete(int answerno);

	List<Answer> queryanswer(Answer answer);

	List<Answer> queryanswer2(Answer answer);

	Answer answerDisplay(int answerno1);

	List<Answer> queryanswer3(Answer answer);

}
