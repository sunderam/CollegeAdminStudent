package dao;

import java.util.List;

import model.Student;

public interface StudentDao {

	public boolean addStudent(Student student);
	public boolean updateStudent(Student student);
	public void deleteStudent(int studentId);
	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	public Student getStudentByUsername(String username);
	public void addTotalFees(String course,int studId);
}
