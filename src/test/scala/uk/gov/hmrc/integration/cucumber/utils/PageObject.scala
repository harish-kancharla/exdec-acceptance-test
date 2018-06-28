package uk.gov.hmrc.integration.cucumber.utils

trait PageObject {

  val exdecRootUrl = ""
  val titleSuffix = "- GOV.UK"
  def pageUrl: String
  def pageHeading: String
  def pageTitle: String
  def pageUrlEditMode: String = ""
}
