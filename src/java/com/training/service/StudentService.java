package com.training.service;

import java.util.List;

import com.training.form.StudentForm;
import com.training.model.StudentModel;
import com.training.page.Page;

public interface StudentService {
	void saveStudent(StudentForm studentForm);

	void modify(StudentForm studentForm);

	void delete(Integer id);

	StudentModel findStuById(Integer id);

	List<StudentModel> findAll(Page page);

	Integer find();
}
