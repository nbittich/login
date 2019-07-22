# Authentication Server
Base for an authentication server implemented with spring boot. The logic:
- make a first request to /user/info using Basic Authentication to perform the login
- if authentication is valid then create a new session for the user and store it into the database (see spring session)
- the server sends a response back to the client including the user infos  and a "x-auth-token" header to perform further authentication
- the client store the x-auth-token and send it back for each request that needs to be performed as an authenticated user 
### How to

a. Using docker
    
    - sudo docker build -t login/login .
    
    - sudo docker run -p 8070:8070 -d login/login
    
b. Maven
    
    - mvn spring-boot:run

c. Properties

    - other properties: https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

    - application.properties: # profile to use
    
    - application-xxxx.properties: # properties loaded depending on the profile used
    
d. Frontend
    
    - Profile to use: dev
    - Simple implementation using VueJs. code located to src/main/resources/public
    - default root url access: http://localhost:8070
    
e. Default credentials

    - username: admin / password: test 
    - username: user / password: user 
    
f. Database

    - default is H2 (embedded)

g. Last release
    
    0.0.1 - 22/07/2019
