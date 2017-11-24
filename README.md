# ingenico
=========================INGENICO Transfer Service======================================================
GitHub link to the code base:- https://github.com/Saurabh-kumarhotmailcom/ingenico/tree/master/
	
	
**Technology choices:-**
	Spring boot with Spring REST Services.
	Spring Data for database interaction.
	Maven build automation tool
	H2 inmemeory database 
	Swagger for visualising the rest endponits.
	
* **Reason For Technology Choices:** 
	 Spring is the most common and well known framework which provides features like IOC and AOP.
	 Most of the boiler plate code is written by default.
	 The spring support for RESTFul Services includes all best practices in REST API development.
	 Spring boot makes it easy to helps to integrate application with Spring ecosystem like Spring data.
	 Swagger ensures proper visualization of the API.
	 Use of H2 memory is to ensure that my application is self sufficient in terms of database.
	 For a full fledged application, We can connect to any other DB.
		

* **How to run my application:-**<br/>
	1: Checkout the code <br/>
	2: Build the maven project with the maven goal(clean install).<br/>
	3: Run the RunApplication class as java application.<br/>
	or<br/>
	3: Please run the following command in the target folder
		     run java -jar Transfer-0.0.1-SNAPSHOT.jar <br/>
			
	4: Open http://localhost:8081/ingenico/swagger-ui.html in any web browser.
		
* The swagger ui will detail out all the rest service endpoints that I have made.
	
	OR
	Download https://github.com/Saurabh-kumarhotmailcom/ingenico/blob/master/Transfer/target/Transfer-0.0.1-SNAPSHOT.jar
		and run java -jar Transfer-0.0.1-SNAPSHOT.jar
		
* **Features in the Application:-**
	1) Transactionality: 
		All transactions are handled at Service level. So the application ensures that all services are atomic
		(It is done either completely or nothing is done,but never partialy).
		
	2) Multiple simultaneous request processing: 
		IN case we receive a transfer request from same debitor IBAN, the application will ensure that all simultaneous requests are handled properly and end result is correct. The service locks specific rows in the table on which it is working, so another service retrieving details from same row will wait untill the first request is fully processed. 
		
	3) Security: Any service once exposed , is susceptible to vulnerability attacks. I have validated all inputs that come into as parameters to our services.
		These validations ensure that no unwanted paarmeters are passed and prevents unnecessary attacks.
		e.g IBAN can only contain alphabets and numbers,any special character will be considered as bad request.
		

	
		
