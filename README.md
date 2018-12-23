# spring-framework-RabbitMQ
![](https://img.shields.io/badge/Language-Angular-brightgreen.svg)  

This project is just note to learn the mechanism of RabbitMQ with Spring Framework.  
<br/>

## Description
This application has 2 feature, one is a sending message to RabbitMQ, second is a receiving the message.  
[Producer.java](/src/main/java/jp/co/example/Producer.java) provides a sending message feature, the class can receive a message from parameter, then send it to the receiving class.  
[Consumer.java](/src/main/java/jp/co/example/Consumer.java) is a receiving message class, which generates a log after 5 seconds when receiving message.  

Although the receiving class should take 5 second to finish process, the sending class is able to finish soon without waiting 5 seconds. That means, the process is whose between the receiving and sending can be asynchronization.  
<br/>

This application is based on spring boot and 'AMQP' library which spring provides, I have followed the below official tutorial to implement this project.  
https://spring.io/guides/gs/spring-boot/  

However, those class name little bit different between actual class name and it in tutorial, because the below RabbitMQ official document names the sending class 'Producer', and the receiving class 'Consumer'
https://www.rabbitmq.com/tutorials/tutorial-one-java.html  
<br/>


## Demo
None.  
<br/>

## Dependency
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

## Requirements
RabbitMQ, it is necessary to run the RabbitMQ to run this application.   
<br/>

## Usage
### Install RabbitMQ
```
brew install rabbitmq
```

### Run&Stop RabbitMQ
```
/usr/local/sbin/rabbitmq-server
```
```
/usr/local/sbin/rabbitmqctl stop
```
<br/>

### Access RabbitMQ Web application
http://localhost:15672/  
ID/PW is guest  
<br/>

## References
Spring boot tutorial.  
https://spring.io/guides/gs/spring-boot/  

Spring rabbimq library tutorial.  
https://spring.io/guides/gs/messaging-rabbitmq/  

RabbitMQ tutorial.  
https://www.rabbitmq.com/tutorials/tutorial-one-java.html  
<br/>

## Licence
MIT
<br/>

## Authors
[fukugit](https://github.com/fukugit)
<br/>

## Conclusion
RabbitMQ is AMQP application, and common in world wide. Spring product offers the framework for RabbitMQ, it is very helpful Java developer.  
Applying the RabbitMQ, complicated batch system gets decrease more. That is one of good advantage.  




