package com.training.service.impl;

import java.util.Date;
import java.util.List;

import com.training.converter.StudentConvert;
import com.training.dao.StudentDao;
import com.training.form.StudentForm;
import com.training.model.StudentModel;
import com.training.page.Page;
import com.training.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	private StudentConvert convert;

	// 添加学生信息
	@Override
	public void saveStudent(StudentForm studentForm) {
		StudentModel model = convert.convert(studentForm);
		studentDao.saveStudent(model);
	}

	// 修改学生信息
	@Override
	public void modify(StudentForm studentForm) {
		StudentModel model = findStuById(studentForm.getId());
		model.setName(studentForm.getName());
		model.setClazz(studentForm.getClazz());
		model.setModifyDate(new Date());
		studentDao.modifyStu(model);
	}

	// 从删除学生信息
	@Override
	public void delete(Integer id) {
		StudentModel model = findStuById(id);
		model.setAvailable(false);
		model.setModifyDate(new Date());
		studentDao.modifyStu(model);
	}

	// 根据id查询学生信息
	@Override
	public StudentModel findStuById(Integer id) {
		StudentModel model = studentDao.findById(id);
		System.out.println(model.getName());
		return model;
	}

	// 分页查看学生信息
	@Override
	public List<StudentModel> findAll(Page page) {
		return studentDao.getStus(page);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public StudentConvert getConvert() {
		return convert;
	}

	public void setConvert(StudentConvert convert) {
		this.convert = convert;
	}

	@Override
	public Integer find() {
		Integer totalCount = studentDao.find();
		return totalCount;
	}

}
