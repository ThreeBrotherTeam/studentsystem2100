package com.training.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.form.StudentForm;
import com.training.model.StudentModel;
import com.training.page.Page;
import com.training.service.StudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {

	@Resource
	private StudentService service;

	// 展示学生信息
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		Integer totalCount = service.find();
		page.setTotalCount(totalCount);
		List<StudentModel> list = service.findAll(page);
		page.setTotalPage((totalCount - 1) / pageSize + 1);
		model.addAttribute("stus", list);
		model.addAttribute("page", page);
		System.out.println(page.toString());
		return "stu/list";
	}

	// 返回學生信息
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Model model, Integer id) {
		StudentModel stu = service.findStuById(id);
		model.addAttribute("stu", stu);
		return "stu/modify";

	}

	// 修改學生信息
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(StudentForm studentForm) {
		service.modify(studentForm);
		return "redirect:/stu/findAll";
	}

	// 返回添加学生信息页面
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "stu/add";

	}

	// 添加学生信息
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(StudentForm studentForm) {
		service.saveStudent(studentForm);
		return "redirect:/stu/findAll";

	}

	// 删除学生信息
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Integer id) {
		service.delete(id);
		return "redirect:/stu/findAll";

	}
}
