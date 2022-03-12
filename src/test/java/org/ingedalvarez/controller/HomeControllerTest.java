package org.ingedalvarez.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@DisplayName("showAllEmployees return ArrayList<Employee>")
	public void showAllEmployeesReturnList() throws Exception {
		ModelAndView mv = controller.showAllEmployees();
		@SuppressWarnings("unchecked")
		List<Employee> allEmployees = (List<Employee>) mv.getModel().get("allEmp");
		assertEquals(ArrayList.class, allEmployees.getClass());
		assertEquals(9, allEmployees.size());
	}



	@Test
	@DisplayName("showEmployee ID 101 retorna nombre Edward Alvarez")
	public void showEmployeeEdward() throws Exception {
		ModelAndView mv = controller.showEmployee(101);
		Employee emp = (Employee) mv.getModel().get("emp");
		assertEquals("Edward Alvarez", emp.getName());
	}



}
