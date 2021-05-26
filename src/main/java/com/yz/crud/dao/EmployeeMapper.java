package com.yz.crud.dao;

import com.yz.crud.bean.Employee;
import com.yz.crud.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 处理员工CRUD请求
 * 
 * @author lfy
 * 
 */
public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);
    
    List<Employee> selectByExampleWithDept(EmployeeExample example);
    
    Employee selectByPrimaryKeyWithDept(Integer empId); 
    

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}