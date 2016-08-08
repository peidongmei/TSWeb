package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Answer;
import com.igeek11.bishe.biz.IAnswerBiz;
import com.igeek11.bishe.dao.IAnswerDao;
@Service
public class AnswerBiz implements IAnswerBiz {
	@Autowired
	private  IAnswerDao answerDao;

	@Override
	public int teacherAnswer(Answer answer1){
		return answerDao.teacherAnswer(answer1);
	}
	@Override
	public int answerDelete(int answerno){
		return answerDao.answerDelete(answerno);
	}
	@Override
	public  List<Answer> queryanswer(Answer answer){
		return answerDao.queryanswer(answer);
	}
	@Override
	public List<Answer> queryanswer2(Answer answer){
		return answerDao.queryanswer2(answer);
	}
	@Override
	public Answer answerDisplay(int answerno1){
		return answerDao.answerDisplay(answerno1);
	}
	@Override
	public List<Answer> queryanswer3(Answer answer) {
		// TODO Auto-generated method stub
		return answerDao.queryanswer3(answer);
	}
}
