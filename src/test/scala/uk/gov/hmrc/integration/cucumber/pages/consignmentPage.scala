package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object consignmentPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/consignment"

  def pageTitle = "Consignment"

  def consigmentID = "radio-consolidation"

  def ducrConsolidation = "ducr-consolidation-input"

}
