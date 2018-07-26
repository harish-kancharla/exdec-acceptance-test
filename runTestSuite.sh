#!/bin/bash
echo " --------------------- STARTED  - EXDEC acceptance test suite with Chrome Browser in QA -------------------------"
export DISPLAY=${DISPLAY=":99"}
sbt -Dbrowser=chrome 'testOnly uk.gov.hmrc.integration.cucumber.RunnerFiles.RunWip'
echo " -------------------- ENDED - EXDEC Test Automation Execution with Chrome Browser in QA-----------------------------"
