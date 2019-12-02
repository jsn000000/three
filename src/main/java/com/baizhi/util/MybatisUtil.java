package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
	private static SqlSessionFactory ssf = null;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	static{
		try {
			//1������Mybatis���ò���  
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//2������SqlSessionFacoty����
			ssf = new SqlSessionFactoryBuilder().build(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static SqlSession openSession(){
		SqlSession ss = tl.get();
		if(ss==null){
			ss = ssf.openSession();
			tl.set(ss);
		}
		return ss;
	}
	

	public static Object getMapper(Class clazz){
		return openSession().getMapper(clazz);
	}
	

	public static void commit(){
		openSession().commit();
		close();
	}

	public static void rollback(){
		openSession().rollback();
		close();
	}
	

	public static void close(){
		openSession().close();
		tl.remove();
	}
}
