package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object selectRolePage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/selectRole"

  def pageTitle = "Select role"

  def selectRoleId = "selectRole.webLoaderArrivingGoods"

  def exporterMakingDecisionId = "selectRole.exporterMakingDeclaration"

}
