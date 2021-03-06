package com.janya.mvrg.ers.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.janya.mvrg.ers.dao.StudentRegistrationRepository;
import com.janya.mvrg.ers.dao.StudentRepository;
import com.janya.mvrg.ers.dto.StudentRegistrationDto;
import com.janya.mvrg.ers.enitity.MasterActivityEntity;
import com.janya.mvrg.ers.enitity.MasterCollegeEntity;
import com.janya.mvrg.ers.enitity.MasterEventEntity;
import com.janya.mvrg.ers.enitity.Student;
import com.janya.mvrg.ers.enitity.StudentRegistrationEntity;

@Controller
@RequestMapping("/students")
public class StudentController {

	private final StudentRepository studentRepository;

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;

	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		studentRepository.save(student);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent())
			model.addAttribute("student", student.get());

		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			Student stuObj = student.get();
			model.addAttribute("student", stuObj);

			studentRepository.deleteById(stuObj.getId());
		}
		model.addAttribute("students", studentRepository.findAll());
		return "index";
	}

	@PostMapping("/registration") //Link 5
	public String addStudentRegistration(@Valid StudentRegistrationDto studentRegistrationDto, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "add-student";
		}

		StudentRegistrationEntity student = new StudentRegistrationEntity();
		BeanUtils.copyProperties(studentRegistrationDto, student);
		MasterActivityEntity activity = new MasterActivityEntity();
		activity.setId(studentRegistrationDto.getMasterActivityEntityId());
		student.setMasterActivityEntity(activity);
		MasterEventEntity event = new MasterEventEntity();
		event.setId(studentRegistrationDto.getMasterEventEntityId());
		student.setMasterEventEntity(event);
		MasterCollegeEntity college = new MasterCollegeEntity();
		college.setId(studentRegistrationDto.getMasterCollegeEntityId());
		student.setMasterCollegeEntity(college);

		studentRegistrationRepository.save(student);

		return "redirect:list";
	}
}