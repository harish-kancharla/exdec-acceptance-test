package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object submitPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/submitPage"

  def pageTitle = "submitPage"

  def valueField = "value"



}
