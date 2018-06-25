package uk.gov.hmrc.integration.cucumber.RunnerFiles

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.integration.cucumber.stepdefs"),
  tags = Array("@zap")
)
class RunZapScan {
}


