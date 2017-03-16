## Схема работы JAVA SERVLET в связке с JSP на библиотеке тэгов JSTL
*DB-->Servlet-->JSP(JSTL)-->HTML*
Servlet класс, осуществляющий подготовку данных на основании HTTP заголовков, полученных от броузера ппользователя 
*в файле web.xml указываем имя и класс сервлета, а также URL по которому мы получаем доступ к нему*
## JSP
Подготавливает отображение, которое выводит на HTML. В JSP джавовый код можно писать и он будет исполняться с тэгах <% %>, 
но нужно использовать JSTL(библиотека тэгов), для её подключения нужно указать в index.jsp сверху страницы :
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
*!!! если адрес подсвечивается красным - подключить библиотеку в проекте через maven, через поиск найти jstl 1.2*
Вытаскивать данные(объекты, атрибуты, параметры) нужно при помощи expression language. Пример :
 ```html <c:forEach items="${BookList}" var="book">
 	 <li>Id : ${book.id}, name : ${book.name}</li>
  </c:forEach> ```
## Деплоймент на JBoss(WildFly)
*!!! возможна ситуация с занятым портом 9990 (решается отключением службы NVIDEA)*
* скачать и  установить  WildFly 10.0.0.Final http://wildfly.org/downloads/
* зайти с консоли в папку wildfly-10.0.0.Final\bin и запустить сервер коммандой standalone.bat -c standalone-full.xml
* запускаем в броузере http://127.0.0.1:9990/console/App.html, вводим пользователя и пароль, входим в настройки
   !!!если не выбрасывает поля аутентификации и ругается что нет такого пользователя, в папке bin выполнить комманду add-user.bat и следовать инструкциям по созданию пользователя
* в админке сервера делаем deployments->add->Upload_a_new_deployment->choose_a_file(.war)
* в настройках .war находим Context root: /web_war
* в броузере входим на проект : http://localhost:8080//web_war/getBooks, где getBooks - тот url что мы прописали в *<url-pattern>/getBooks</url-pattern>*
* в Idea в настройке сервера JBoss указать страницу по которой открывать броузер после деплоя и в закладке деплой нашу .war
!!! на основе JSP которое пришло, сервер формирует сервлет на языке Java в /usr/local/share/wildfly-10.0.0.Final/standalone/tmp/web_war.war/org/apache/jsp/books_jsp.java  и уже его и отображает

### Данный пример размещён на сервере по ссылке : http://your_IP:8080/new_web_war/getBooks
