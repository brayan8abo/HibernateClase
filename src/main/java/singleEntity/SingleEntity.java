package singleEntity;

import singleEntity.entity.Student;
import singleEntity.daos.StudentDAO;
import common.utils.HibernateUtil;

public class SingleEntity {
    public static void singleEntity() {
        StudentDAO studentDAO = new StudentDAO();


        Student aStudent = new Student(
                "NombreEstudiante",
                "email@estudiante.com",
                7.75f
        );

        studentDAO.saveStudent(aStudent);

        // Más operaciones ...

        // Cerramos la sesión que se abrió en el DAO
        HibernateUtil.shutdown();
    }

}
