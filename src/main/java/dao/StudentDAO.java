package dao;

import java.util.List;

import bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getAllStudent();
	public int insertStudent(StudentBO bo);
	public StudentBO getStudentByNo(int sno);
	public int updateStudent(StudentBO bo);
	public int deleteStudent(int sno);
}