package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object confirmationPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/declarationForYourselfOrSomeoneElse"

  def pageTitle = "Consignment"

  def consigmentconfirmationID = "declarationForYourselfOrSomeoneElse.yourself"

}
