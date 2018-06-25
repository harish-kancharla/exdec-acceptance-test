package uk.gov.hmrc.integration.cucumber.stepdefs

import java.io._

import uk.gov.hmrc.integration.cucumber.utils.Property
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import org.zaproxy.clientapi.core.{ApiResponse, ApiResponseElement, ClientApi}

import scala.reflect.io.{File, Path}

class ZapScannerSteps extends ScalaDsl with EN {

  When("""^Spider scan is triggered and allowed to complete$"""){ () =>
    ZapScannerSteps.spiderScan
  }

  When("""^Active scan is triggered and allowed to complete$""") { () =>
    ZapScannerSteps.activeScan
  }

  When("""^Zap scan results are exported to an external xml and html file$"""){ () =>
    ZapScannerSteps.exportZapReport
  }

  Then("""^Zap scan results are generated successfully$"""){ () =>
    ZapScannerSteps.verifyZapReportGenerated
  }
}

object ZapScannerSteps extends ScalaDsl with Matchers{

  private val ZAP_SESSION_IP: String = "127.0.0.1"
  private val ZAP_PROXYHOST: String = "localhost"
  private val ZAP_PROXYPORT: Int = 8090
  private val ZAP_APIKEY: String = "2q6oo8ql47fqduqoirfjhfnqcu"

  private val api: ClientApi = new ClientApi(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY)
  private val reportPath: String = System.getProperty("user.dir") + "/zapReport."

  def initZapScanner {
    File(Path(reportPath + "xml")).delete()
    File(Path(reportPath + "html")).delete()
  }



  def scan(scanId: String, status: (String) => ApiResponse, scanType:String) {

    var progress = 0
    // Poll the status until it completes
    while (progress < 100) {
      Thread.sleep(1000)
      progress = Integer.parseInt(status(scanId).asInstanceOf[ApiResponseElement].getValue)
      println(scanType+" Scan progress : " + progress + "%")
    }
    println(scanType+" Scan complete")
  }

  def activeScan = {
    val scanId: String = api.ascan.scan(Property.getProperty("targetApp"), "True", "False", null, null, null)
      .asInstanceOf[ApiResponseElement]
      .getValue()


    scan(scanId,api.ascan.status, "Active")
  }
  def spiderScan = {
    val scanId: String = api.spider.scan(Property.getProperty("targetApp"), null, null, null, null)
      .asInstanceOf[ApiResponseElement]
      .getValue()


    scan(scanId, api.spider.status, "Spider")
  }


  def exportZapReport {
    exportReport(api.core.xmlreport, "xml")
    exportReport(api.core.htmlreport, "html")

    def exportReport(report:Array[Byte], ext:String) {
      val bos = new BufferedOutputStream(new FileOutputStream(reportPath+ext))
      bos.write(report)
      bos.close() // You may end up with 0 bytes file if not calling close.
    }
  }

  def verifyZapReportGenerated {
    File(Path(reportPath + "xml")).exists shouldBe true
    File(Path(reportPath + "html")).exists shouldBe true
  }
}







