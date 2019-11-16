package com.rm13.mybatis;

import com.rm13.mybatis.dao.EmployeeMapper;
import com.rm13.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class Mybatis_02_ConfigTests {

	private SqlSessionFactory sqlSessionFactory;


	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		this.sqlSessionFactory = sqlSessionFactory;
	}


	/**
	 * 测试增删改
	 * 1: mybatis容许增删改直接定义以下类型返回值
	 * 		Integer， Long， Boolean
	 */
	@Test
	public void test01(){

		final SqlSession sqlSession = sqlSessionFactory.openSession(true);
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		String gender = String.valueOf((int)(10 * Math.random()));
		Employee ee = Employee.builder().lastName("张三").gender(gender).email("rm13@aliyun.com").build();
		// 测试添加
		final boolean addEmp = mapper.addEmp(ee);
		System.out.println("add result:"+addEmp);
		System.out.println("Employee:"+ee);

		// 测试修改
		// ee = Employee.builder().id(1L).email("my@aliyun.com").gender(gender).lastName("李"+gender).build();
		// final boolean updateEmp = mapper.updateEmp(ee);
		// System.out.println(updateEmp);

		// 测试删除
		// final boolean deleteEmp = mapper.deleteEmp(2);
		// System.out.println(deleteEmp);

	}

}
