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

## Команда для запуска
Перед запуском необходимо определить параметры в local.properies и credential.properties

```
gradle clean test
```
Для запуска в несколько потоков
```
gradle clean test -Dthreads=5
```
