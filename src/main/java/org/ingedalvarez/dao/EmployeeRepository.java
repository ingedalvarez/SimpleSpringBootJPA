package org.ingedalvarez.dao;

import org.ingedalvarez.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
