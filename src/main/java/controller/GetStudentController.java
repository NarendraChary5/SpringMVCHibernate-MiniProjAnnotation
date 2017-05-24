package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dto.StudentDTO;
import service.StudentService;

@Controller
public class GetStudentController  {
	@Autowired
	private StudentService service;
	public void setService(StudentService service) {
		this.service = service;
	}

	ModelAndView model = null;
	
	/*@RequestMapping(value = "/home")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "List of all Students");
		return model;
	}*/
	
	/*@RequestMapping(value = "/studentList")
	public String listStudent(Model model) {
		List<StudentDTO> listDTO = null;
		listDTO = service.processAllStudents();
		model.addAttribute("allStudents", listDTO);
		return "studentList";		
	}*/
	
	@RequestMapping("/studentList")	
	public ModelAndView listStudent() {
		List<StudentDTO> listDTO = null;
		listDTO = service.processAllStudents();
		model = new ModelAndView("studentList");
		model.addObject("allStudents", listDTO);
		return model;		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String processRegister() {
		return "register";
	}
	

	
	@RequestMapping(value = "/insertStudentList", method = RequestMethod.POST)
	public ModelAndView listStudentAfterRegistion(@ModelAttribute("dto") StudentDTO dto) {
		List<StudentDTO> listDTO = null;
		String result = null;
		result = service.registerStudent(dto);
		listDTO = service.processAllStudents();
		model = new ModelAndView("studentList");
		model.addObject("allStudents", listDTO);
		model.addObject("result", result);
		return model;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView updateRegisterDisplay(@RequestParam("sno") int sno) {
		StudentDTO dto = null;
		dto = service.processStudentByNo(sno);
		model = new ModelAndView("edit");
		model.addObject("editStudent", dto);
		return model;
	}
	
	@RequestMapping(value = "/updateStudentList", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("dto") StudentDTO dto) {
		List<StudentDTO> listDTO = null;
		String result = null;
		result = service.updateStudent(dto);
		listDTO = service.processAllStudents();		
		model = new ModelAndView("studentList");
		model.addObject("allStudents", listDTO);
		model.addObject("result", result);
		return model;
	}
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("sno") int sno) {
		List<StudentDTO> listDTO = null;
		String result = null;
		result = service.processDeleteStudent(sno);
		listDTO = service.processAllStudents();		
		model = new ModelAndView("studentList");
		model.addObject("allStudents", listDTO);
		model.addObject("result", result);
		return model;
	}
}