package org.ingedalvarez.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.ingedalvarez.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest
class HomeControllerTest {

	@Autowired
	private HomeController controller;

	@Test
	@DisplayName("Delete Employee with ID return delete Employee and deleteEmployee view name")
	public void deleteEmployee() {
		ModelAndView mv = controller.deleteEmployee(101);
		assertThat(mv.getModel().get("delEmp").toString())
				.contains("[id=101, name=Edward Alvarez, age=44, salary=1200.0]");
		assertEquals("deleteEmployee", mv.getViewName());

	}

	@Test
	@DisplayName("DeleteEmployee() throw NosuchElementException if ID no found.")
	public void deleteEmployeeThrowException() {
		assertThrowsExactly(NoSuchElementException.class, () -> controller.deleteEmployee(999999),
				"ID no found in database");

	}

	@Test
	@DisplayName("addEmployee return ModelAndView with Employee added to it.")
	public void addEmployeeSussefull() {
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setAge(45);
		emp.setName("John Doe");
		emp.setSalary(999);
		ModelAndView mv = controller.addEmployee(emp);
		assertTrue(mv.getModel().values().toString().contains("[id=9999, name=John Doe, age=45, salary=999.0]"));

	}

	@Test
	@DisplayName("showAllEmployees return ArrayList<Employee>")
	public void showAllEmployeesReturnList() throws Exception {
		ModelAndView mv = controller.showAllEmployees();
		@SuppressWarnings("unchecked")
		List<Employee> allEmployees = (List<Employee>) mv.getModel().get("allEmp");
		assertEquals(ArrayList.class, allEmployees.getClass());
		assertFalse(allEmployees.isEmpty());
	}

	@Test
	@DisplayName("showEmployee ID 101 retorna nombre Edward Alvarez")
	public void showEmployeeEdward() throws Exception {
		ModelAndView mv = controller.showEmployee(101);
		Employee emp = (Employee) mv.getModel().get("emp");
		assertEquals("Edward Alvarez", emp.getName());
	}

}
