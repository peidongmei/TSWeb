package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Question;
import com.igeek11.bishe.biz.IQuestionBiz;
import com.igeek11.bishe.dao.IQuestionDao;

@Service
public class QuestionBiz implements IQuestionBiz {
	@Autowired
	private IQuestionDao questionDao;
	@Override
	public int studentUpquestion(Question question){
		return questionDao.studentUpquestion(question);
	}
	@Override
	public  List<Question> queryquestion(Question question){
			return questionDao.queryquestion(question);
	}
	@Override
	public Question questionUpdate1(String queno){
		return questionDao.questionUpdate1(queno);
	}
	@Override
	public int deleteQuestion(int queno){
		return questionDao.deleteQuestion(queno);
	}
}
