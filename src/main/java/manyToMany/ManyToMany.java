package manyToMany;

import common.utils.HibernateUtil;
import manyToMany.daos.EmployeeDAO;
import manyToMany.entities.Employee;
import manyToMany.entities.Project;

import java.util.HashSet;
import java.util.Set;

public class ManyToMany {

    public static void manyToMany() {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Project accesoADatos = new Project();
        accesoADatos.setFullDescription("Acceso a Datos");

        Project desarrolloApps = new Project();
        desarrolloApps.setFullDescription("Desarrollo apps");

        Set<Project> dam2 = new HashSet<>();
        dam2.add(accesoADatos); dam2.add(desarrolloApps);


        // Relation management
        Employee employee1 = new Employee();
        employee1.setName("Fulanito");
        employee1.setProjects(dam2);
        for (Project proj : dam2) {
            Set<Employee> employeesPerProject = proj.getEmployees();
            employeesPerProject.add(employee1);
        }

        Employee employee2 = new Employee();
        employee2.setName("Menganito");
        employee2.setProjects(dam2);
        for (Project proj : dam2) {
            Set<Employee> employeesPerProject = proj.getEmployees();
            employeesPerProject.add(employee2);
        }

        employeeDAO.saveEmployees(new Employee[]{employee1, employee2});

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
