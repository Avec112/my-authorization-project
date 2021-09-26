# my-authorization-project
This project demonstrates the new Spring Authorization Server.
The project is more or less exactly the same as [Spring Security Oauth2 Authorization Server sample](https://github.com/spring-projects/spring-authorization-server/tree/0.2.0/samples/boot/oauth2-integration) (as of late sept 2021, v0.2.0)

## Requirements
* Maven build tool v3.6+ 
  * If you want to use Grade the link above has the needed Gradle files available
* Jdk 17 (because why not?)
* Define "127.0.0.1 auth-server" in /etc/hosts
  * Windows will be windows\system32\drivers\etc\hosts

## Getting started
* Build and start Authorization Server
* Build and start Resource Server
* Build and start Client
* Access client at http://localhost:8080 (login with user/user)

## Some more info
* The `Authorization Server` will be doing both authentication and providing users authorities as scopes. Register clients here. The users is defined here. 
* The `Resource Server` needs to know about the `Authorization Server` and must configure the authorization requirements. Meaning what authorities will be required to access a particular uri. 
* The `Client` must have configured how to communicate with the authorization server and implement how to access the resource server.  

## Resources
* https://github.com/spring-projects/spring-authorization-server (master)
* https://github.com/spring-projects/spring-authorization-server/tree/main/samples/boot/oauth2-integration
* https://www.baeldung.com/spring-security-oauth-auth-server
