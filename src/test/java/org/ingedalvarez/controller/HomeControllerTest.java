package org.ingedalvarez.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	@DisplayName("addEmployee return ModelAndView with Employee added to it.")
	public void addEmployeeSussefull() {
		Employee emp = new Employee();
		emp.setId(9999); emp.setAge(45); emp.setName("John Doe"); emp.setSalary(999);
		ModelAndView mv = controller.addEmployee(emp);
		System.out.println("mv get status= "+mv.getModel().values());
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
