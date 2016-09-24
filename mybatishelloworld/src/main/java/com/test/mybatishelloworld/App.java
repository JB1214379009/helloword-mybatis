package com.test.mybatishelloworld;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.user.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			String statement = "com.test.user.userMapper.getUser";
			User user = session.selectOne(statement,1);
			System.out.print(user.toString());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
