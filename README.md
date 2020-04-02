#YourBankJEE

JEE application which allows you to manage bank accounts with Spring Boot JPA Hibernate Restful SOAP RMI AngularJS


- Functional requirements:
The application must allow to:

• Manage clients:

Add a client.
Consult with all customers.
Consult customers whose name contains a keyword.

• Manage accounts:

Add an account.
Consult an account.
• Manage operations:

Make an amount payment into an account.
Withdraw an amount from an account.
Transfer money from one account to another.
View account operations page by page.

The operations require an authentication operation.

Technical requirements:

The data is stored in a MySQL database.

• The application consists of three layers:

The DAO layer which is based on Spring Data, JPA, Hibernate and JDBC.
The Business layer.
The server-side MVC-based web layer using Thymeleaf.


• Security is based on Spring Security.
• Establish a technical architecture for the project.
• Establish a class diagram showing the entities, the CAD layer and the business layer.

• We will create a SpringBoot project which contains the following elements:

The entities.
The DAO (Interfaces Spring data) layer.
The business layer (Interfaces and implementations).
The web layer:
Spring MVC controllers.
The Vue based on Thymeleaf.

• Secure the application using an authentication system based on Spring Security.

• Each account is defined with a code, a balance and a creation date.
• A current account is an account that also has an overdraft.
• A savings account is an account that also has an interest rate.
• Each account belongs to a client.
• Each client is defined by their code and name.
• Each account can undergo several operations.
• An operation is defined by a number, a date and an amount.
• There are two types of transaction: Payment and Withdrawal.
