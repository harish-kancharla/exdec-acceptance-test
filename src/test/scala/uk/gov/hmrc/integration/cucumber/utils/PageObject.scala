package uk.gov.hmrc.integration.cucumber.utils

trait PageObject {

  val bbsiRootUrl = ""
  val titleSuffix = "- GOV.UK"
  def pageUrl: String
  def pageHeading: String
  def pageTitle: String
  def pageUrlEditMode: String = ""
}
