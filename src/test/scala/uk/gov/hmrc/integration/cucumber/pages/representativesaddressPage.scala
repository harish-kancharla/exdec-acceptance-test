package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object representativesaddressPage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.qa.tax.service.gov.uk/customs-declare-exports-frontend/representativesAddress"

  def pageTitle = "Full export declaration"

  def textField1 = "fullNameInput"

  def textField2 = "buildingAndStreetInput"

  def textField3 = "townOrCityInput"

  def textField4 = "county-input"

  def textField5 = "postcode-input"

  def textField6 = "country-input"

  def buttonID = "submit"

}
