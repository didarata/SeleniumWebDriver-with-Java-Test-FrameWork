## Introduction
Automation framework test project for QA Grad Training.
The use cases included are for Automation on the exercise website https://www.saucedemo.com/

With:
1.Java
2.Selenium
3.Gradle
4.TestNG

## Getting Started
1.Installation process:
      Build the project with the needed dependencies.
      Install Google Chrome, Microsoft Edge, Mozilla Firefox.
      
2.Software dependencies
      Located in build.gradle. Build the project with the required dependencies in order to be able to run it.

## How to use:
Configuration file:
1.Set username and password.
2.Set Product to be tested.
3.Set First Name, Last Name and Zip Code.
4.Set browser to tested with.

saucedemo folder contains the pages and the logic behind the tests.
homework folder contains the use cases.

Screenshots from failed tests for debugging are located in screenshots folder.

build.gradle file:
Set threads to run parallel test runs.

How to run:
Run all:
Right click on homework folder and click Run 'Tests in 'Homework''.
Run single test:
Right click on the test you want to run in homework folder and click Run "name_of_the_test".

Reports:
After you run either single or multiple tests you can select the "Open gradle test report icon" and you will be redirected to report page.



