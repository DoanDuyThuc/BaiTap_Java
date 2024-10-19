package Relationship.repository;

import Relationship.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee , Long> {
}
