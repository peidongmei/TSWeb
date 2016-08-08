package com.igeek11.bishe.biz;

import java.sql.SQLException;

import com.igeek11.bishe.bean.Super;

public interface ISuperBiz {
	Super login(Super super1);
	Super superUpdate1(int superno1);
	int superUpdate2(Super super2)throws SQLException;
	
	
	
}
