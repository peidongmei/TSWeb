package com.igeek11.bishe.biz.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Super;
import com.igeek11.bishe.biz.ISuperBiz;
import com.igeek11.bishe.dao.ISuperDao;

@Service
public class SuperBiz implements ISuperBiz {
	@Autowired
	private ISuperDao  superdao;
	@Override
	public Super login(Super super1) {
		return superdao.login(super1);
	}
	@Override
	public Super superUpdate1(int superno1) {
		return superdao.superUpdate1(superno1);
	}
	@Override
	public int superUpdate2(Super super2){
		return superdao.superUpdate2(super2);
	}
	
	

}
