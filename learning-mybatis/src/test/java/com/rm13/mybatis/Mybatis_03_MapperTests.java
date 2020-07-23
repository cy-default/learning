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
import java.util.HashMap;
import java.util.Map;


public class Mybatis_03_MapperTests {

	private SqlSessionFactory sqlSessionFactory;


	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		this.sqlSessionFactory = sqlSessionFactory;
	}



	@Test
	public void test01(){
		// 多参数查询，mybatis3.4+jdk1.8 多参数 默认名称就是参数名
		final SqlSession sqlSession = sqlSessionFactory.openSession(true);
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		final Employee empByIdAndLastName = mapper.getEmpByIdAndLastName(1, "%张%");
		System.out.println(empByIdAndLastName);

		Map map = new HashMap<>();
		map.put("id",1);
		map.put("lastName", "%李%");

		final Employee empByMap = mapper.getEmpByMap(map);
		System.out.println(empByMap);
	}


	@Test
	public void test02(){
		// 多参数查询，mybatis3.4+jdk1.8 多参数 默认名称就是参数名
		final SqlSession sqlSession = sqlSessionFactory.openSession(true);
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		final Map<Long, Employee> result = mapper.getEmpByLastNameLikeReturnMap("%张%");
		System.out.println(result);
	}
}
