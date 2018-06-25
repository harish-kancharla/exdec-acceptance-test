#!/bin/bash
echo " --------------------- STARTED  - BBSI acceptance test suite with FIREFOX Browser in Local -------------------------"
export DISPLAY=${DISPLAY=":99"}
sbt -Dbrowser=firefox 'test-only uk.gov.hmrc.integration.cucumber.RunnerFiles.RunTestSuite'
echo " -------------------- ENDED - BBSI Test Automation Execution with FIREFOX Browser in local-----------------------------"
