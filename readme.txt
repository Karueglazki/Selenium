тесты на Selenium Remote Control используя фреймвор JUnit4
1.запускать отдельно selenium server нужно
1.1 перейти в папку(/home/sandra/apps/java) где лежит сервер. selenium-server-standalone-2.46.0 
1.2 запустить как
java -jar selenium-server-standalone-2.46.0.jar 

Что бызапустить удаленное нужно:
- запустить на тестовой машине, селениум сервер
- указан в определении сервера имя удаленной машины вместо localhost
selenium = new DefaultSelenium("ip_adress", 4444, "*chrome", "https://www.google.com.ua/");

Конфиг файл.
можно использовать теги groups и для тегов before
создавать отдельные конфиги для разных тестовых писочниц 
запускать тест если есть конфиг нужно:
- запускать сам конфиг файл.


Что бы запустить паралельно
1.указываем паарметры в настройках:
"<suite name="Default suite" parallel="classes" thread-count="2">"
2. в настройках запуска браузера указываем  верный тег 	@AfterClass в зависимости что указано в паралель в настрйоках