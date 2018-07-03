name := "exdec-acceptance-test"

version := "1.0"

scalaVersion := "2.11.8"

//autoScalaLibrary := false

//credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

// enable publishing the jar produced by `test:package`
publishArtifact in(Test, packageBin) := true

// enable publishing the test API jar
publishArtifact in(Test, packageDoc) := true

// enable publishing the test sources jar
publishArtifact in(Test, packageSrc) := true
//
//val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")
//
//resolvers ++= Seq(
//  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
//  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
//  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")
//
//
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Sonatype Repo" at "http://oss.sonatype.org/content/groups/public/"
//

//resolvers += "HMRC Bintray" at "https://dl.bintray.com/hmrc/releases"
//
//resolvers += "HMRC Bintray RCs" at "https://dl.bintray.com/hmrc/release-candidates"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium"   %   "selenium-firefox-driver"   %  "3.6.0",
  "org.seleniumhq.selenium"   %   "selenium-java"             %  "3.6.0",
  "org.scalatest"             %   "scalatest_2.11"            %  "2.2.4",
  "org.pegdown"               %   "pegdown"                   %  "1.1.0"   %  "test",
  "info.cukes"                %   "cucumber-scala_2.11"       %  "1.2.4",
  "info.cukes"                %   "cucumber-junit"            %  "1.2.4",
  "info.cukes"                %   "cucumber-core"            %  "1.2.4",
  "info.cukes"                %   "cucumber-picocontainer"    %  "1.2.4",
  "junit"                     %   "junit"                     %  "4.12"    %  "test",
  "com.novocode"              %   "junit-interface"           %  "0.11"    %  "test",
  "org.scalaj"                %%  "scalaj-http"               %  "0.3.16",
  "org.zaproxy"               %  "zap-clientapi"             %  "1.3.0",
  "org.specs2"                %  "specs2-junit_2.11"              % "4.3.0",
  "org.scala-lang"                %  "scala-library"              % "2.11.8",
  "com.typesafe"              % "config"                          % "1.2.0",
  "im.mange"                  %% "flakeless"                 % "0.0.29"
)
