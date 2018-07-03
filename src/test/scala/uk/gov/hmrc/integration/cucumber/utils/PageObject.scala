package uk.gov.hmrc.integration.cucumber.utils

trait PageObject {

  val exdecRootUrl = ""
  val titleSuffix = "- GOV.UK"
  def pageUrl: String
  def pageTitle: String
  def pageUrlEditMode: String = ""
}
