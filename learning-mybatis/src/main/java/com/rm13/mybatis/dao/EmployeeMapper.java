package com.rm13.mybatis.dao;

import com.rm13.mybatis.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-16
 */
public interface EmployeeMapper {

    Employee selectEmp(Integer id);

    List<Employee> listByName(String name);

    @MapKey("last_name")
    Map<String, Map<Object, Object>> mapByName(String name);

    @MapKey("lastName")
    Map<String, Employee> objectMapByName(String name);


    Employee getEmpById(Integer id);

    boolean addEmp(Employee employee);


    boolean updateEmp(Employee employee);

    boolean deleteEmp(Integer id);

    Employee getEmpByIdAndLastName(Integer id, String lastName);

    // mybatis3.4 + jdk1.8 默认等同于==getEmpByIdAndLastName(Integer id, String lastName);
    Employee getEmpByIdAndLastName2(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee getEmpByMap(Map<String ,Object> map);

    List<Employee> getEmpsByLastNameLike(String lastName);

    // 返回一条记录的map， key就是列名， 值就是对应的值
    Map<String, Object> getEmpByIdReturnMap(Integer id);

    // 多条记录封装一个map， Map<Integer, Employee>: key:记录的主主键， 值是这条记录
    @MapKey("id")
    Map<Long, Employee> getEmpByLastNameLikeReturnMap(String lastName);
}
