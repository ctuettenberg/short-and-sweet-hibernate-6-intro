package eu.openvalue.domain.repository;

import eu.openvalue.domain.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

  public List<Employee> findByNameLike(String name){
    return find("name like ?1", "%" + name + "%").stream().toList();
  }
}