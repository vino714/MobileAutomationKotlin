# Mobile Automation Framework developed with Kotlin


<u><h2>Prerequisites:</h2></u>
#### Java 11
#### Appium 1.22.3
#### Maven 3.9.6


### Test Automation repository to automate Android and iOS native apps using the below tech set

<ul>
	<li>Kotlin</li>
	<li>Selenide</li>
	<li>Appium</li>
	<li>TestNG</li>
	<li>Allure</li>
	<li>Maven</li>
	<li>Guice</li>
</ul>


# Steps to Exeucte Tests
Open Terminal and start appium server:
```bash
appium --allow-insecure=get_server_logs
```

# 1. Using IntelliJ
1. Open the project in IntelliJ
2. Goto the test under <b>src/test/java/tests/Search/TeamAndPlayerTest.kt</b>
3. Open the test mentioned in step 2 and execute it using 'Play' button on top


# 2. Execute using Terminal
1. Open Terminal, goto the project location and enter command
```bash 
mvn clean test
```


# Generate allure report
1. Goto terminal and install Allure reports using brew
2. Once done, execute tests atleast one time.
3. Goto project location and run the command
``` bash
allure serve allure-results/
```
4. Browser windows will open with Allure reports