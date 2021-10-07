##API Test Automation Assessment
* I created Cucumber framework from scratch

##For Cucumber Framework
* I added dependency in POM.XML file: Cucumber-java, cucumber-junit
* Creating classes: CukesRunner - to trig the code i created.
* And features, glue to run Feature and Step_Definition 
  files against each other

###Utilities: Driver, Conf.Reader
* In oder for them to work I added selenium-java and bonigarcia webdriver manager dependencies
* I used only API part, as written in assessment

##UI Part
- I created configuration.properties file to store important information related to project, and
  i added HOOKs class, it is for before and after methods (maximize, close, screenshot)

##API part
* For manual testing i used Postman
* And Rest Assured for automation of API tests
* added dependency: restassured library, json-schema-validator, jackson-databind,lombok

###In order to verify given API i performed:
* Positive testing by sending,valid request parameters, json body 
and verified that response status code is 200 successful

* Negative testing by sending invalid request parameters invalid request json body 
  and verify that response status code is NOT 200
* I also did JSON Schema validation with comparing result against the schema.(usually i get
 Schema from developers, but for this assessment i did  not have a Schema and i used third party
 website to generate Schema from response body)

##Thank you for great assessment. 
