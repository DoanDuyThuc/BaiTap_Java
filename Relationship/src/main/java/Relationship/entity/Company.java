package Relationship.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @ManyToMany(mappedBy = "companies")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }
}
