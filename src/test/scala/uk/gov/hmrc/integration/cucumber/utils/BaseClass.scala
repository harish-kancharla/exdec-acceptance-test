package uk.gov.hmrc.integration.cucumber.utils

object BaseClass {

  private[utils] val bc = new BaseClass

  def getInstance: BaseClass = bc
}

class BaseClass private() {

  var bankName = ""
  var bankRecordId = "1"
  var bankAccount = "Account number"+"\n"+"****************6789"
  var bankSortCode = "Sort-code"+"\n"+"30 50 60"
  var taxYear = ""

}
