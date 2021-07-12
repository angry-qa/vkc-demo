# Демо-проект автотестов на VKConnect

## Покрыт следующий функционал
* UI тесты
  * ✅ Залогин через ВКонтакте
  * ✅ Базовые действия залогиненого пользователя
  * ✅ Навигация и редактирование данных личного кабинет VKConnect
  * ✅ Интегарции VKConnect с внешними сервисами
* API тесты
  * ✅ валидация логина
  * ✅ валидация телефонного номера

## Технологический стек
Java, Gradle, JUnit5, IntelliJ IDEA, Selenide, Project Lombok, Rest-Assured, Jenkins, Selenoid, Allure TestOps, Jira, Github, Telegram

<a href="https://github.com/angry-qa/vkc-demo">
  <img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Seleide"/>
  <img src="https://raw.githubusercontent.com/angry-qa/angry-qa/main/lombok.png" width="40" height="40"  alt="Project Lombok"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Rest-Assured.svg" width="40" height="40"  alt="ResrAssured"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"  alt="Jenkins"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure TestOps"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"  alt="Jira"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"  alt="Github"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"  alt="Telegram"/>
</a>

## Как запустить
Перед выполением необходимо: 
* в local.properies определить параметры конфигурации (для запуска тестов локально)
* в remote.properies определить параметры конфигурации (для запуска тестов удаленно)
* в credential.properties указать логин и пароль от ВКонтакте (без 2fa)
* в credential.properties указать адрес и учетные данные Selenoid (для запуска тестов удаленно или на CI)

### Локально
```
gradle clean test
```
Для запуска в несколько потоков
```
gradle clean test -Dthreads=5
```
### Удаленно
```
gradle clean test -Ddriver=remote 
```
### Через CI
Файл credential.properties в Jenkins можно создать через Create/Update Text File.
Кроме того, нужно определить парамтеры MAXIMIZED и BASE_HOST.
```
clean
test
-Ddriver=remote
-Dweb.maximized=${MAXIMIZED}
-Dbase.host=${BASE_HOST}
-Dbrowser.name=${BROWSER}
-Dbrowser.version=${BROWSER_VERSION}
-Dvideo.storage=${VIDEO_STRORAGE}
```
## Видео о прохождении тестов


## Запуск в Jenkins
Статистика по запускам
<img src="https://raw.githubusercontent.com/angry-qa/vkc-demo/master/src/test/resources/files/jenkins-dashboard.png" alt="Статистика по запускам"/>

Параметры запуска
<img src="https://raw.githubusercontent.com/angry-qa/vkc-demo/master/src/test/resources/files/jenkins-build.png" alt="Параметры запуска"/>

## Отчёт о прохождении автотестов в Allure Report
<img src="https://raw.githubusercontent.com/angry-qa/vkc-demo/master/src/test/resources/files/allure-report.png" alt="Allure Report"/>

## Хранение тестовой документации в Allure TestOps
Тесткейсы

Дашборд

## Интерграция с Jira

## Уведомления о прохождении автотестов в Telegram
