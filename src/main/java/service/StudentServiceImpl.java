package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.StudentBO;
import dao.StudentDAO;
import dto.StudentDTO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<StudentDTO> processAllStudents() {
		List<StudentDTO> listDTO = null;
		List<StudentBO> listBO = null;
		StudentDTO dto = null;
		listBO = dao.getAllStudent();
		listDTO = new ArrayList<StudentDTO>();
		//convert to listBO to listDTO
		for (StudentBO bo : listBO) {
			dto = new StudentDTO();
			dto.setSno(bo.getSno());
			dto.setName(bo.getName());
			dto.setAddress(bo.getAddress());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public String registerStudent(StudentDTO dto) {
		//convert dto to bo
		StudentBO bo = null;
		int count = 0;
		bo = new StudentBO();
		bo.setSno(dto.getSno());
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		count = dao.insertStudent(bo);
		if(count==0) {
			return " Registration failed";
		}
		else {
			return "Registration Successfull";
		}
	}

	@Override
	public StudentDTO processStudentByNo(int sno) {
		StudentDTO dto = null;
		StudentBO bo = null;
		dto = new StudentDTO();
		bo = dao.getStudentByNo(sno);
		//if(bo !=null) {
		//convert bo to dto
		dto.setSno(bo.getSno());
		dto.setName(bo.getName());
		dto.setAddress(bo.getAddress());
		//}
		return dto;
	}

	@Override
	public String updateStudent(StudentDTO dto) {
		int count = 0;
		StudentBO bo = null;
		bo = new StudentBO();
		//convert dto to bo
		bo.setSno(dto.getSno());
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		
		count = dao.updateStudent(bo);
		
		if(count>0) {
			return "Updated Successfully";
			}
			else {
				return " Updation failed";
			}
	}

	@Override
	public String processDeleteStudent(int sno) {
		int count = 0;
		count = dao.deleteStudent(sno);
		
		if(count>0) {
			return "Deleted Successfully";
			}
			else {
				return " Deletion failed";
			}
	}
	
	
	/*public static void main(String[] args) {
		StudentServiceImpl service = new StudentServiceImpl();
		service.processAllStudents();
		
	}*/

	
}