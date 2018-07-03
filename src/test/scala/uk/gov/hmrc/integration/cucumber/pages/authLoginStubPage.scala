package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object authLoginStubPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fcustoms-declare-exports-frontend%2FselectRole"

  def pageTitle = "Authority Wizard"

  def credIdField = "authorityId"

}
