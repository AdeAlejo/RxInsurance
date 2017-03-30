# RxInsurance
RX Application Example, Spring Cloud RXNetty

v1.0.0

For Install and Execute

+ Clone this Git

## Client Side

+ cd rx-seguro-canguro
	- mvn install

+ cd eureka
	- mvn spring-boot:run

+ cd config
	- mvn spring-boot:run
	
+ cd clientWebApp
	- mvn spring-boot:run

- [x] The Web App can access in http://localhost:8085

## Server Side

+ To Run the RxNetty BackEnd based on Karyon2 	

+ cd netflixoss/insurance
    - ./gradlew runApp

- [x] The Rest Service is listen on POST http://localhost:8888/message	


# TODO

+ In this version, the client is not invoking in a correct way the service exposed in the RxNetty

+ Each separate service (frontend and backend) is working correctly, the communication between the two is not yet working
