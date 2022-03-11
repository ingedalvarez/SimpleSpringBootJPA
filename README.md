# Simple SpringBoot JPA H2 Example.

Ejemplo basico del uso del framework SpringBoot y Maven.
Se hace uso de una base de datos h2 en memoria y de la api JPA,
las vista (paginas) son de tipo JSP por lo cual se utiliza
la dependencia Jasper en maven para poder visualizarlas sin problemas en el navegador.

En este ejemplo se implementa un CRUD basico y además se muestra el 
uso basico de querys JPQL personalizadas.

En este ejemplo se crea un modelo sencillo de una sola clase llamada employee
con los campos basicos: id, nombre, edad, salario.

El controlador de esta clase es un controlador SpringBoot llamado EmployeeControler.

Se implementa una capa DAO con una interfaz EnployeeRepo que extiende de CrudRepository.

Las diferentes vistas se ubican en la carpeta webapp/pages.

Por ultimo se configura el archivo applications.propertis para hacer uso de h2 y configurar los
prefijos y sufijos para acceder a las vistas.


Para centrar la atencion solo en el uso de las herramientas JPA de SpringBoot
se utilizan vista simples del tipo form sin ninguna decoracion CSS.


