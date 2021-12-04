$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AccountSummary.feature");
formatter.feature({
  "name": "Account summary content",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "verify title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "the user logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zero.step_definitions.LoginStepDef.user_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the title should be \"Zero - Account Summary\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "skipped"
});
});