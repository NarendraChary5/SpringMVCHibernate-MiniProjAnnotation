package test;

import service.StudentServiceImpl;

public class Test{
	public static void main(String[] args) {
		StudentServiceImpl service = new StudentServiceImpl();
		service.processAllStudents();
		
	}
}