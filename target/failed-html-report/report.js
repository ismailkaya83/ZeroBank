$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Only authorized users should be able to login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zero.step_definitions.LoginStepDef.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in using valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.zero.step_definitions.LoginStepDef.the_user_logs_in_using_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Account Summary\" page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zero.step_definitions.LoginStepDef.the_page_should_be_displayed(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.zero.pages.BasePage.getActivePageTab(BasePage.java:54)\r\n\tat com.zero.step_definitions.LoginStepDef.the_page_should_be_displayed(LoginStepDef.java:39)\r\n\tat ✽.the \"Account Summary\" page should be displayed(file:///C:/Users/tor23/IdeaProjects/ZeroBank/src/test/resources/features/login.feature:6)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
});