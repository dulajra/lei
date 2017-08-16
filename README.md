# lei

Lei is an intelligent super market assistant with voice controls. Smart and easy to use assistant is aware of all the details about 
the prodicts available at the supermarket with the location they are stored at. Customers can just ask a question with voice or text to 
get required information. 

# Requirements

* Java
* MongoDB
* Tomcat Server
* IntelliJ IDEA

# Intsallation

Create a new MongoDB database and add the host, port and db name to `SpringMongo.xml`

    mvn clean install

Run the `DataSeeder.java` to seed the database with test data.

Run the webapp with IntelliJ IDEA
