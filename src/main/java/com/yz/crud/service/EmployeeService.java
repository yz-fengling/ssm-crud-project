package com.yz.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.crud.bean.Employee;
import com.yz.crud.bean.EmployeeExample;
import com.yz.crud.bean.EmployeeExample.Criteria;
import com.yz.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	/**
	 * 检验用户名是否可用
	 * 
	 * @param empName
	 * @return  true：代表当前姓名可用   fasle：不可用
	 */
	public boolean checkUser(String empName) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}
	/**
	 * 按照员工id查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	/**
	 * 员工更新
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
		
	}
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteBatch(List<Integer> del_ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}
}
