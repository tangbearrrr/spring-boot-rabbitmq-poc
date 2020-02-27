# Setup Guide

**Requirement :** 

 - Java JDK 8 or else
 - Docker
 - Maven (optional)
 
 **Install RabbitMQ :**
 
- $ cd docker/
- $ docker-compose up -d
- $ Check container status : $ docker ps
- Visit http://localhost:15672/ 
- username : guest 
- password : guest
- create queue name: spring.boot.queue

**Run Application**

- Start Application: $ mvn spring-boot:run
- To start application without maven: $ ./mvnw spring-boot:run
