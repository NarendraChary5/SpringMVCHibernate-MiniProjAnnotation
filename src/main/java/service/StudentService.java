package service;

import java.util.List;

import dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> processAllStudents();
	public String registerStudent(StudentDTO dto);
	public StudentDTO processStudentByNo(int sno);
	public String updateStudent(StudentDTO dto);
	public String processDeleteStudent(int sno);
}