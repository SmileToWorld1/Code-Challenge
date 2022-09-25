#  BeymenWebsite PROJECT EXERCISE

##### TOOLS AND EXPLANATIONS
>- The project has been prepared based on Cucumber BDD style.
>- In this project, Java programming language and Maven build management tool were used.
>- LOG4J information is provided as a logging design.
>- The project includes one scenario which is about searching function, adding, and deleting one exact product from basket box.

##### HOW TO RUN TESTS
```sh
 -> Under the runners package "CukesRunner" right click and run the class. "src > test > java > com > runners > CukesRunner"
 -> mvn clean verify --> In the IDE console or navigate project path in command line and run.
 -> mvn clean verify -DBROWSER=chrome -> Also browser type can be controlled easily from command line with this command.
 -> mvn verify "-Dcucumber.filter.tags=@wip" -DBROWSER=chrome -> Both browserType and tags which you want to run can control easily from the command line with this command.
```

#### REPORT
>- Cucumber report is generated under the target folder: `target/cucumber/cucumber-html-reports/overview-features.html`
>- Under the target folder also generated **rerun.txt** file, and with this file only the failed test scenarios can rerun through the **FailedTestRunner** class.

- Ismail SONMEZ 
- QA Automation Engineer     


