# There are "any specific actions" that need to be done in order to start the test
1. Install Intellij IDEA from https://www.jetbrains.com/idea/ . Ensure that the TestNG plugin is installed as well
2. Install Java JDK 17 from https://www.oracle.com/java/technologies/downloads/#java17
3. Set up environment variables:
   For the user variable, set the Path to Java
   For the system variable, set JAVA_HOME
4. Install Maven, a dependency management tool for Java projects, from  https://maven.apache.org/install.html
5. Set up environment variables for Maven:
   For the user variable, set %MAVEN_HOME%\bin
   For the system variable, set MAVEN_HOME
6. Ensure you are using the latest version of the Chrome browser (version 122)
7. Provide user credentials in the resources/user.properties file
8. Run the test from the root path using the command `mvn test`
9. git aThe default TestNG Report can be found at the following path: RicardasSeleniumJava\target\surefire-reports\testng-results.xml