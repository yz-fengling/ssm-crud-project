package com.yz.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.crud.bean.Department;
import com.yz.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {
		return departmentMapper.selectByExample(null);
	}

}
