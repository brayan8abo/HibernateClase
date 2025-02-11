package core;

import daos.StudentDAO;
import models.Student;
import utils.HibernateUtil;

import java.util.List;

public class HelloHibernateApp {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create new students
        Student student1 = new Student();
        student1.setName("Amit Sharma");
        student1.setEmail("amit.sharma@example.com");
        student1.setAverageMark(2.0f);

        Student student2 = new Student();
        student2.setName("Priya Singh");
        student2.setEmail("priya.singh@example.com");
        student2.setAverageMark(4.76f);

        // Save students
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);

        // Update student
        student1.setEmail("amit.sharma_updated@example.com");
        studentDAO.updateStudent(student1);
        student2.setEmail("nuevo@email.com");
        studentDAO.updateStudent(student2);

        // Get student by ID
        Student retrievedStudent = studentDAO.getStudentById(student1.getId());
        System.out.println("Retrieved Student: " + retrievedStudent.getName() + " - " + retrievedStudent.getEmail());

        // Get all students
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All Students:");
        students.forEach(student -> System.out.println(student.getName() + " - " + student.getEmail()));

        // Delete student
//        studentDAO.deleteStudent(student2.getId());

        // Get all students after deletion
        students = studentDAO.getAllStudents();
        System.out.println("All Students after deletion:");
        students.forEach(student -> System.out.println(student.getName() + " - " + student.getEmail()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }

}
