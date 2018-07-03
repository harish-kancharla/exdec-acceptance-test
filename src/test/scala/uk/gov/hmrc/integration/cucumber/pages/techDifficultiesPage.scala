package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object techDifficultiesPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/this-service-has-been-reset"

  def pageTitle = "For your security, this service has been reset"

}
