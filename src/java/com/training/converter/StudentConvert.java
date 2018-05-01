package com.training.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.training.form.StudentForm;
import com.training.model.StudentModel;
import com.training.service.impl.DateUtils;

public class StudentConvert implements Converter<StudentForm, StudentModel> {

	@Override
	public StudentModel convert(StudentForm form) {

		StudentModel model = new StudentModel();
		model.setId(form.getId());
		model.setName(form.getName());
		model.setClazz(form.getClazz());
		model.setBirthday(DateUtils.format_1(form.getBirthday()));
		model.setAvailable(true);
		model.setCreateDate(new Date());
		model.setModifyDate(new Date());
		return model;
	}

}
