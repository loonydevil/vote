#Description
Sample spring boot app.

#Usage
Currently app uses authentication via headers 'email' and 'password' (Spring Security comes in v. 2.0 :)).
To install app clone it via git and run db_setup.sql from resources/sql folder (assuming there's mySql installed with root user and no password - security is our all :)).

Following are example commands via curl:

##create user

    curl -X POST -H 'email:admin' -H 'password:admin' -d "password=1234&name=John&isAdmin=true&email=john@doe.com" http://localhost:8081/food/v1.0/user/
    
##create restorant

    curl -X POST -H 'email:admin' -H 'password:admin' -d "name=McDonalds" http://localhost:8081/food/v1.0/restorant/
    
##get list of all restorants
    
    curl -X GET -H 'email:admin' -H 'password:admin' http://localhost:8081/food/v1.0/restorant/
    
##add dish to the menu of some restorant
    
    curl -X POST -H 'email:admin' -H 'password:admin' -d "restorantId=2&dishName=BigMac&price=9001" http://localhost:8081/food/v1.0/menu/
    
##get menu for specific restorant
    
    curl -X GET -H 'email:admin' -H 'password:admin' http://localhost:8081/food/v1.0/menu/?restorantId=2

##clear menu for the restorant
    
    curl -X DELETE -H 'email:admin' -H 'password:admin' http://localhost:8081/food/v1.0/menu/?restorantId=2
    
##vote for restorant
    
    curl -X POST -H 'email:admin' -H 'password:admin' -d "restorantId=2" http://localhost:8081/food/v1.0/vote/
    
