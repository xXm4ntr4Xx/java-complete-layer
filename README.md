# java-complete-layer
Guide to implement a complete layer

1.create the model (contractor, getter, setter and to string)

2.create the dao(create dao-interface with unimplemented method, implement method in daoImpl class)

3.create the utility package(create the database connection using singleton pattern)
	3.1 import the .jar file
	3.2 load the driver class and register with the driver manager

4.inside DAOImpl declare connection and prepare statement variable
	4.1 create query and replace ?'s with actual value(using set method)
	4.2 execute the query (execute for create/update/delete/insert,executeQuery for select)
	4.3 if query is successful return the object

5.create the service layer
	5.1 create the package,create the interface
	5.2 create the implementation
	5.3 declare DAO dependency and create the constructor in order to provide dependency injection
	5.4 add encryption, validation
	5.5 after implement the encryption code, create a student object to feed the encrypted password and return the studentDAO and the register student method with the new object

6. Create controller package, create the servlet
	6.1 get parameter from the frontend, create object for student, studentDAO,studentService and create registeredStudent reference (we creating object using the super type reference) and check if registeredStudent is null(if not null show the success.jsp else the fail.jsp)

7.create the jsp files(index, success and fail files)

8.create the form with the different fields

9.create the database on phpmyadmin
