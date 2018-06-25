[![Build Status](https://ci-dev.tax.service.gov.uk/buildStatus/icon?job=tcs-acceptance-tests)](https://ci-dev.tax.service.gov.uk/job/tcs-acceptance-tests/)
tcs-acceptance-tests
====================

Tax Credits Service acceptance tests
------------------------------------

This repo contains all of the acceptance tests which are defined in conjunction with the business using Given, When, 
Then statements written in Gherkin syntax. 
It is built using:

    Cucumber
    Selenium-webDriver
    SBT to build
    
### Getting started

Ensure that you have a working linux development environment. If not follow the [instructions on confluence](https://confluence.tools.tax.service.gov.uk/display/TAXS/Linux+environment+setup)

### Test Automation environment setup

    1. Ensure that you have installed IDEA's InteliJ IDE 
    2. You will also need the Cucumber for scala plugin for IntelliJ
    3. Clone this repo.
    4. Import the project in InteliJ

### Project structure
Each part of the application's functionality is described by feature files which correspond with user stories which 
have been written in [JIRA](https://jira.tools.tax.service.gov.uk/secure/RapidBoard.jspa?rapidView=208&view=planning). 
The feature files are arranged into folders under src/test/features and grouped into the main areas of the application.
 
Each step of the feature files is defined by executable test steps in the scala code under the 
src/test/scala/uk/gov/hmrc/integration/test/cucumber_stepdefs area and those utilise Page object models under
src/test/scala/uk/gov/hmrc/integration/test/pages which are the single place where page specific properties and 
variables are configured.

### Execution
If anyone wants to run Renewals CofCs AT's with Renewals flag false(Without Renewals) they should start tcs-frontend by using this command sm --start TCS_FRONTEND --appendArgs '{"TCS_FRONTEND":["-DDev.external-url.tcr-frontend.host=http://localhost:9364","-DDev.tax-credits-renewals-enabled=false", "-Dws.timeout.request=60000"]}' -f --wait 60 --noprogress 

If anyone wants to run Standalone CofCs AT's with Renewals flag true(With Renewals) they should start tcs-frontend by using this command sm --start TCS_FRONTEND --appendArgs '{"TCS_FRONTEND":["-DDev.external-url.tcr-frontend.host=http://localhost:9364","-DDev.tax-credits-renewals-enabled=true", "-Dws.timeout.request=60000"]}' -f --wait 60 --noprogress

This is the new job to run Renewals CofCs Accepatance tests and this is the downstream job for the tcs-smoke-tests, obviously these tests are with Renewals flag true on tcs-frontend https://ci-dev.tax.service.gov.uk/view/TCS-BuildMonitor/job/tcs-renewals-cofcs-acceptance-tests/

This is the job to run Standalone CofCs Accepatance tests and this is the downstream job for the tcs-smoke-tests, obviously these tests are with Renewals flag true on tcs-frontend https://ci-dev.tax.service.gov.uk/view/TCS-BuildMonitor/job/tcs-acceptance-tests/

In /src/test/scala/uk/gov/hmrc/integration/test there are scala classes which control what is run according to the tests 
tagged with the below tags.
The following @tags are used in the feature files:
*@tcdssmoke* is used for selecting tests to be run before the main test suite
*@tcds* running Non-java sript AT's on standalone CofCS with Renewals flag false 
*@javascripton* running Jvascript tests on standalone CofCS with Renewals flag false 
*@tcdr* running Non-java sript AT's on standalone CofCS with Renewals flag true and for javascript tests  *@tcrjavascripton* running Jvascript tests on standalone CofCS with Renewals flag true
*@solo* is used for selecting a test to be run on its own during test development  
 
### Running on Jenkins
Jenkins is configured to run the script jenkins_run_integration_local.sh which contains instructions to run the above 
referenced scala classes.

### Info for QA's Re ticket TCS-3756
It is required to ensure we do not use the same user for back to back tests that submit a change to WL, Efac or DMS as this can cause test failure due to the way NTC works.
Also care should be taken if no cleardown of WL, DMS or Efac is done that any tests running one after the other do not produce the same output and cause a false positive test.
