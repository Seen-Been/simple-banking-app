# simple-banking-app
## Sean Heathcote

### Introduction
_This is a simple banking app containing a 'user' CRUD app with one-to-many 'bank account' CRUD functionality._ <br>
<br>
**Features**
* add new user <br>
* add new account <br>
* update user details <br>
* update account details <br>
* read all user details <br>
* read all account details <br>
* read a user's details from id <br>
* read an account's details from id <br>
* delete user from id <br>
* delete account from id <br>

### Project Structure
<img src=".md/structure.png">


### Database
<img width="600" src=.md/database.png>

### Execution
##### Create user <br> <img width="600" src=".md/createuser.png">
##### Read all users <br> <img width="600" src=.md/readalluser.png>
##### Read 1 user from id <br> <img width="600" src=.md/readiduser.png>
##### Update user <br> <img width="600" src=.md/updateuser.png>
##### Delete user <br> <img width="600" src=.md/deleteuser.png>
##### Login Check <br> <img width="600" src=.md/userlogin.png>
##### Create account <br> <img width="600" src=.md/createaccount.png>
##### Read all accounts <br> <img width="600" src=.md/readallaccount.png>
##### Read 1 account from id <br> <img width="600" src=.md/readidaccount.png>
##### Update account <br> <img width="600" src=.md/updateaccount.png>
##### Delete account <br> <img width="600" src=.md/deleteaccount.png>

### Testing
CRUD <br> <img width = 600 src=.md/testcrud.JPG>
Rest init <br> <img width = 600 src=.md/testrest.png>
Create integration for user <br> <img src=.md/testcreate.png>

### Instructions for executing project:
* Ensure that port 8080 is free
* Ensure Lombok is installed onto STS
* Run project as Spring Boot App from project explorer
* (currently) no front end is available for inputting data, so POSTMAN will have to be used with the http addresses assigned in the user and account controllers.

### Future Revisions
In the future I would like to provide functionality (such as interest rates and penalties for withdrawing money) from certain account types. I would like to add a front end to make logging in and CRUD operations much more user-friendly.

#### Tools used:
* Java
* Spring Boot (STS4)
* MySQL
* Maven
* GitHub
* Git


