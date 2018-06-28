#!/bin/bash
echo " --------------------- STARTED  - EXDEC acceptance test suite with Chrome Browser in QA -------------------------"
export DISPLAY=${DISPLAY=":99"}
sbt -Dbrowser=firefox 'test-only uk.gov.hmrc.integration.cucumber.RunnerFiles.RunTestSuite'
echo " -------------------- ENDED - EXDEC Test Automation Execution with Chrome Browser in QA-----------------------------"
