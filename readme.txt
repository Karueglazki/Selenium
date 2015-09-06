тесты на Selenium Remote Control используя фреймвор JUnit4
1.запускать отдельно selenium server нужно
1.1 перейти в папку(/home/sandra/apps/java) где лежит сервер. selenium-server-standalone-2.46.0 
1.2 запустить как
java -jar selenium-server-standalone-2.46.0.jar 

Что бызапустить удаленное нужно:
- запустить на тестовой машине, селениум сервер
- указан в определении сервера имя удаленной машины вместо localhost
selenium = new DefaultSelenium("ip_adress", 4444, "*chrome", "https://www.google.com.ua/");
