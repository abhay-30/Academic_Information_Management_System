

The folder AimsPortal contains all the files ---

step 1 - Setup the environemnt for the gradle project and open the folder in any ide.

Step 2 -  src/main/java contains all the classes for the project each class is tested using jacoco and their testing code in present inside the test folder.

step3 -      all the test files are pre-executed and If you want to run the file on different test cases follow these steps :

                                -----> execute the database code present in the root folder on postgres sql ,it will create all the required database file.
                                ------> also populate the database for custom test case you want to check .
                                ------>change the username and password in the main file which is used to login the postgress.
                                ------>add jar file in the libraries
                                ------> download all the dependices of build.gradle file


step4  --   run each test file to check the corrrectness of the code .

step5 --    Most of the test edge cases are already checked in the test. for custom test cases change the arguments of the test funtion accoding to the funtion presemt in the corrsposind class fie.

step 6 --  jacoco code covergae report for the test cases used in testing :

                build/reports/jacoco/index.html  -----contains all the test records adnd coverage of the code.

                total test cases used to check the correctness of code ---------63
                Also failing test case does not mean the output is wrong.

