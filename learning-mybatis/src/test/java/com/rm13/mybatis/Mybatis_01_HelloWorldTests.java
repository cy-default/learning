package com.rm13.mybatis;

import com.rm13.mybatis.dao.EmployeeMapper;
import com.rm13.mybatis.dto.BookQuery;
import com.rm13.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 1： 接口式编程
 * 		原生： 		Dao 	==> DaoImpl
 * 		mybatis:	Mapper  ==> xxMapper.xml
 *
 * 2:  SqlSession代表和数据库的一次会话，用完必须关闭
 * 3:  SqlSession和Connection一样都是非线程安全 ， 每次使用都应该去获取新的成员变量
 * 4:  mapper接口没有实现类，但是mybatis会为只鹅个接口生成一个代理对象。
 * 		（将接口和xml文件绑定起来）
 * 		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
 *
 * 5: 两个重要的配置文件:
 * 		1：mybatis的全局配置文件， 包含数据库连接池信息，事务管理器信息
 * 		2：sql映射文件， 包含每一个SQL语句的映射信息（namespace + id）
 */
public class Mybatis_01_HelloWorldTests {

	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 根据xml配置文件（全局配置）， 创建一个SqlSessionFactory对象
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * old
	 * @throws IOException
	 */
	@Test
	public void test01() throws IOException {
		// 1：根据xml配置文件（全局配置）， 创建一个SqlSessionFactory对象
		InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2：获取sqlsession实例，能直接执行已经映射的SQL语句
        final SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/**
		 * @param statement Unique identifier matching the statement to use.
		 *                  SQL的唯一标识（namespace + id ）
		 * @param parameter A parameter object to pass to the statement.
		 *                  传递给语句的参数对象。
		 */
		final Employee employee = sqlSession.selectOne("com.rm13.mybatis.dao.EmployeeMapper.selectEmp", 1);

		System.out.println(employee);

	}


	/**
	 * new
	 */
	@Test
	public void test02(){
		// 1: 获取sqlSessionFactory对象
		// 2: 获取sqlSession对象
		final SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3: 获取接口的实现类对象
		// 会为接口自动的创建一个代理对象， 代理对象去执行增删改查
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper.getClass());
		final Employee employee = mapper.selectEmp(1);
		System.out.println(employee);
	}


	/**
	 * list
	 */
	@Test
	public void test03(){
		// 1: 获取sqlSessionFactory对象
		// 2: 获取sqlSession对象
		final SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3: 获取接口的实现类对象
		// 会为接口自动的创建一个代理对象， 代理对象去执行增删改查
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper.getClass());
		final List<Employee> love = mapper.listByName("love");
		System.out.println(love);
	}

	/**
	 * map
	 */
	@Test
	public void test04(){
		// 1: 获取sqlSessionFactory对象
		// 2: 获取sqlSession对象
		final SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3: 获取接口的实现类对象
		// 会为接口自动的创建一个代理对象， 代理对象去执行增删改查
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper.getClass());
		final Map<String, Map<Object,Object>> love = mapper.mapByName("love");
		love.entrySet().forEach(v->{
			System.out.println(v.getValue().getClass().getName());
			System.out.println(v.getValue());
			System.out.println("=================");
		});
		System.out.println(love);
	}

	/**
	 * object map
	 */
	@Test
	public void test05(){
		// 1: 获取sqlSessionFactory对象
		// 2: 获取sqlSession对象
		final SqlSession sqlSession = sqlSessionFactory.openSession();

		// 3: 获取接口的实现类对象
		// 会为接口自动的创建一个代理对象， 代理对象去执行增删改查
		final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper.getClass());
		final Map<String, Employee> love = mapper.objectMapByName("love");
		love.entrySet().forEach(v->{
			System.out.println(v.getValue().getClass().getName());
			System.out.println(v);
			System.out.println("=================");
		});
	}


}
