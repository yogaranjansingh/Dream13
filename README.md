# Dream13

Steps to run the code : 

1. clone the project
2. run "mvn clean install" on both the projects
3. Deploy the wars
4. Alternatively we can import the code in eclipse/sts/any_other_ide and run from there.
5. Import data in mysql using the sql dump file in repo (dream13.sql)

6. run the following query in mysql workbench
delete from Dream11.Team where id>0;
delete from Dream11.match where id>0;

Hit the below get api from browser/postman
http://localhost:8080/Dream13/rest/v1/saveMatch

7. open url in brpwser : 
http://localhost:8080/DreamUI/

* login with your credentials / if profile is not created yet, register first

* select the match you want to play

* select your team

* preview your team below the team selector

* proceed with the team .

* refresh match to see if the opponent has also selected the team
 
* once the opponent has selected the team, start match option should appear

* start the match 

* Enjoy the match

