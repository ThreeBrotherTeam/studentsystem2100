package com.training.dao;

import java.util.List;

import com.training.model.StudentModel;
import com.training.page.Page;

public interface StudentDao {
	void saveStudent(StudentModel model);

	void modifyStu(StudentModel model);

	void delete(StudentModel model);

	StudentModel findById(Integer id);

	List<StudentModel> getStus(Page page);

	Integer find();

}
