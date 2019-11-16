package com.rm13.mybatis.dao;

import com.rm13.mybatis.entity.Employee;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-16
 */
public interface EmployeeMapper {

    Employee selectEmp(Long id);

    Employee getEmpById(Integer id);

    boolean addEmp(Employee employee);

    boolean updateEmp(Employee employee);

    boolean deleteEmp(Integer id);
}
