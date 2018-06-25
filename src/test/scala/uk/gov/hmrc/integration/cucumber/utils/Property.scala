package uk.gov.hmrc.integration.cucumber.utils

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.Properties

object Property {
  @throws[IOException]
  def getProperties(propsPath: String): Properties = {
    val propsFile = new File(propsPath)
    val inputStream = new FileInputStream(propsFile)
    val props = new Properties
    props.load(inputStream)
    inputStream.close()
    props
  }

  @throws[IOException]
  def getProperty(key: String): String = {
    val propsPath = System.getProperty("user.dir") + File.separator + "Properties" + File.separator + "project.properties"
    getProperties(propsPath).getProperty(key)
  }

  def setProperty(key: String, value:String) = {
    val propsPath = System.getProperty("user.dir") + File.separator + "Properties" + File.separator + "project.properties"
    getProperties(propsPath).setProperty(key, value)
  }

  @throws[IOException]
  def getProperty(propsPath: String, key: String): String = getProperties(propsPath).getProperty(key)
}

class Property() {
}
