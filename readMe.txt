Customer-Supplier Application: 
	Implementation of two microservices, namely- AuthService and SupplierService. 
	1. In auth-service: Customer and Supplier can sign-up and Login using Jwt authentication(User Table). When the user-type is Supplier, 
	SupplierId(emailId) gets added onto Supplier Table via RestTemplate.
	If the service down, it is handled by Hystrix and subsequent signup does not happen.
	2. In supplier-service: Post and Get Methods for Supplier. Async method that adds supplier details onto SupplierInvoice Table to resemble invoice. 
	Also, the use of Hystrix on Get method to showcase timed-out concept.
	3. Also, the concepts of Eureka Server, Config Server, proper logging, lombok and Swagger has been used.

Execution Flow of Microservices:
	1.config-server
	2.EurekaDiscoveryServer
	3.authentication-service
	4.supplier-service

Concepts invovled:
 	1.Eureka Server
	2.Config Server 
	3.JWT Authentication
	4.Async method
	5.Hystrix
	6.Swagger
