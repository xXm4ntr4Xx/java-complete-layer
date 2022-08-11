# java-complete-layer
Guide to implement a complete layer

1.create the model (contractor, getter, setter and to string)
<hr>

2.create the dao(create dao-interface with unimplemented method, implement method in daoImpl class)
<hr>
3.create the utility package(create the database connection using singleton pattern)<br>
	3.1 import the .jar file<br>
	3.2 load the driver class and register with the driver manager
<hr>
4.inside DAOImpl declare connection and prepare statement variable<br>
	4.1 create query and replace ?'s with actual value(using set method)<br>
	4.2 execute the query (execute for create/update/delete/insert,executeQuery for select)<br>
	4.3 if query is successful return the object
<hr>
5.create the service layer<br>
	5.1 create the package,create the interface<br>
	5.2 create the implementation<br>
	5.3 declare DAO dependency and create the constructor in order to provide dependency injection<br>
	5.4 add encryption, validation<br>
	5.5 after implement the encryption code, create a student object to feed the encrypted password and return the studentDAO and the register student method with the new object
<hr>
6. Create controller package, create the servlet<br>
	6.1 get parameter from the frontend, create object for student, studentDAO,studentService and create registeredStudent reference (we creating object using the super type reference) and check if registeredStudent is null(if not null show the success.jsp else the fail.jsp)<br>
<hr>
7.create the jsp files(index, success and fail files)
<hr>
8.create the form with the different fields
<hr>
9.create the database on phpmyadmin
