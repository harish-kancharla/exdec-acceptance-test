#!/bin/bash
echo " --------------------- STARTED  - BBSI acceptance tests on FIREFOX browser with ZAP enabled -------------------------"
export DISPLAY=${DISPLAY=":99"}
sbt -Dbrowser=firefox -DzapEnabled=true 'test-only uk.gov.hmrc.integration.cucumber.RunnerFiles.RunTestSuite'
echo " --------------------- ENDED - BBSI acceptance tests on FIREFOX browser with ZAP enabled -------------------------"
echo " --------------------- STARTED - ZAP SCAN -------------------------"
sbt -Dbrowser=firefox 'test-only uk.gov.hmrc.integration.cucumber.RunZapScan'
echo " -------------------- ENDED - ZAP SCAN-----------------------------"
