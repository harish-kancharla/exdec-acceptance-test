package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object whosedeclarationPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/whoseDeclaration"

  def pageTitle = "Declaration for yourself or someone else"

  def consigmentconfirmationID = "declarationForYourselfOrSomeoneElse.yourself"

}
