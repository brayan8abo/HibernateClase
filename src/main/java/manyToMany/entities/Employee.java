package manyToMany.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name="employee_project",
            joinColumns = {
                @JoinColumn (name = "employee_id")
            },
            inverseJoinColumns = {
                @JoinColumn (name = "project_id")
            }
    )
    Set<Project> projects = new HashSet<>();

    @Column(name = "name")
    private String name;

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
