package core;

import daos.CartDAO;
import daos.ItemDAO;
import daos.StudentDAO;
import daos.UserDAO;
import models.*;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelloHibernateApp {
    public static void main(String[] args) {
//withNoRelationsBetweenTables();
//oneToOne();
        oneToMany();
    }

    private static void withNoRelationsBetweenTables() {
        StudentDAO studentDAO = new StudentDAO();

        // Create new students
        Student student1 = new Student("Amit Sharma", "amit.sharma@example.com", 2.0f);

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

    private static void oneToOne() {
        UserDAO userDAO = new UserDAO();


        // Create new students
        User user1 = new User();
        Address address = new Address();
        address.setFullDescription("c/De la desesperación cruce con avenida de la desilusión, 9");
        user1.setAddress(address);

        // Create new students
        User user2 = new User();
        address = new Address();
        address.setFullDescription("c/2º DE DAM, 9");
        user2.setAddress(address);

        userDAO.saveUser(user1);
        userDAO.saveUser(user2);

        // Shut down the SessionFactory
//        HibernateUtil.shutdown();
    }

    private static void oneToMany() {
        CartDAO cartDAO = new CartDAO();
        ItemDAO itemDAO = new ItemDAO();

        // Create new students
        Cart cart1 = new Cart();
        cart1.setName("Regalo de cumpleaños");

        Item item = new Item();
        item.setName("Balón de baloncesto");

        Item item2 = new Item();
        item2.setName("Canasta");

        Set<Item> items = new HashSet<>();
        items.add(item);
        items.add(item2);

        cart1.addItems(items);

        cartDAO.saveCart(cart1);

        itemDAO.saveItem(item);
        itemDAO.saveItem(item2);

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
