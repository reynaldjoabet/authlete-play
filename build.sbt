name := """Authlete-Play"""

version                  := "1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.3"
ThisBuild / scalacOptions ++= Seq(
  "-no-indent",
  // "-deprecation", // Warns about deprecated APIs
  "-feature", // Warns about advanced language features
 // "-unchecked",//[warn] Flag -unchecked set repeatedly
  // "-Wunused:imports",
  //   "-Wunused:privates",
  //   "-Wunused:locals",
  //   "-Wunused:explicits",
  //   "-Wunused:implicits",
  //   "-Wunused:params",
  //   "-Wvalue-discard",
  // "-language:strictEquality",
  "-Xmax-inlines:100000"
)
val CirceVersion  = "0.14.13"
val Http4sVersion = "0.23.26"

val silhouetteVersion = "10.0.2"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    // clean / aggregate := false,
    // watchSources ++= ...: Adds those files to the list of sources SBT watches during ~ tasks (like ~compile, ~test, etc.)
    watchSources ++= (baseDirectory.value / "ui/src" ** "*").get,
    libraryDependencies ++= Seq(
      guice,
      ws,
      ehcache,
      evolutions,
      filters,
      // "com.authlete" % "authlete-java-common" % "4.19",
      // https://mvnrepository.com/artifact/org.playframework.silhouette/play-silhouette
      // "org.playframework.silhouette" %% "play-silhouette" % silhouetteVersion,
      "org.playframework"                     %% "play-json"             % "3.0.4",
      "org.playframework"                     %% "play-mailer"           % "10.1.0",
      "org.playframework"                     %% "play-mailer-guice"     % "10.1.0",
      "org.playframework"                     %% "play-slick"            % "6.2.0",
      "org.playframework"                     %% "play-slick-evolutions" % "6.2.0",
      "com.outr"                              %% "scribe"                % "3.16.1",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.35.2",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.35.2" % "provided",
      "com.softwaremill.sttp.client4"         %% "core"                  % "4.0.3",
      "com.softwaremill.sttp.client4"         %% "jsoniter"              % "4.0.3",
      "com.outr"                              %% "scribe"                % "3.16.1",
      "com.outr"                              %% "scribe-slf4j"          % "3.16.1",
      "com.outr"                              %% "scribe-cats"           % "3.16.1",
      // "com.softwaremill.sttp.client4" %% "json4s" % "4.0.3",
      // "com.softwaremill.sttp.client4" %% "pekko-http-backend" % "4.0.5",
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe"        % Http4sVersion,
      "org.http4s" %% "http4s-dsl"          % Http4sVersion,
      "org.http4s" %% "http4s-client"       % Http4sVersion,
      "io.circe"   %% "circe-core"          % CirceVersion,
      "io.circe"   %% "circe-generic"       % CirceVersion,
      "io.circe"   %% "circe-parser"        % CirceVersion
    ),
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
    // libraryDependencies ++= Seq(
    //   "com.softwaremill.sttp.client3" %% "core"           % "3.11.0",
    //   "com.softwaremill.sttp.client3" %% "json4s"         % "3.11.0",
    //   "org.json4s"                    %% "json4s-jackson" % "4.0.7"
    //   // "com.softwaremill.sttp.client3" %% "async-http-client-backend-future" % "3.11.0"
    // )
  )
//.dependsOn(sttp % "compile->compile;test->test")//,http4s % "compile->compile;test->test")
//.aggregate() // no arguments = aggregate nothing
//.aggregate(sttp,http4s)

routesGenerator := InjectedRoutesGenerator

generateJsReverseRouter := false

generateReverseRouter := false

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

Global / onChangedBuildSource := IgnoreSourceChanges

ThisBuild / run / fork := true

ThisBuild / test / fork := true

val commonSettings = Seq(
  openApiOutputDir                  := baseDirectory.value.getAbsolutePath, // (baseDirectory.value / "openapi").getAbsolutePath,
  openApiSkipOverwrite              := Some(false),
  openApiModelNamePrefix            := "",
  openApiModelNameSuffix            := "",
  openApiGenerateMetadata           := SettingDisabled,
  openApiPackageName                := "authlete.core",
  openApiModelPackage               := "authlete.models",
  openApiApiPackage                 := "authlete",
  openApiValidateSpec               := SettingDisabled,                     // SettingEnabled,
  openApiSkipValidateSpec           := SettingEnabled,
  openApiGenerateApiTests           := SettingDisabled,
  openApiGenerateModelTests         := SettingDisabled,
  openApiGenerateApiDocumentation   := SettingDisabled,
  openApiGenerateModelDocumentation := SettingDisabled,
  openApiInvokerPackage             := "authlete.core",
  openApiAdditionalProperties := Map(
    "skipValidateSpec" -> "true",
    "dateLibrary"      -> "java8",
    "useGzipFeature"   -> "true",
    // "library" -> "apache-httpclient",
    "hideGenerationTimestamp" -> "true",
    "supportUrlQuery"         -> "false",
    "annotationLibrary"       -> "none",
    // "templateDir" -> s"$openApiSpecDir/templates",
    "useEnumCaseInsensitive" -> "true",
    "withXml"                -> "false", // optional
    // "scalaVersion" -> "3.3.3", // important: this enables Scala 3 syntax
    "enumClassPrefix" -> "false", // optional,
    "apiNameSuffix"   -> "",      //  prevents "Api" from being appended,
    "modelTests"      -> "false", // Disable model tests
    "apiTests"        -> "false", // Disable API tests
    "apiDocs"         -> "false", // Disable API documentation generation
    "model"           -> "true",  // Generate models (optional, defaults to true)
    "apis"            -> "false"  // Disable API client generation
  )
  // cleanFiles += baseDirectory.value / "src"
  // Compile / sourceGenerators += (Compile / openApiGenerate).taskValue adds all files including readme,build.sbt etc
  // Compile / sourceGenerators += Def.task {
  //     val files = (Compile / openApiGenerate).value
  //     files.filter(_.getName.endsWith(".scala"))
  //   }.taskValue

)

lazy val sttp = project
  .in(file("generated/client/sttp"))
  .settings(
    // scalaVersion := "3.3.3",
    openApiInputSpec     := "openapi.yaml",
    openApiGeneratorName := "scala-sttp",
    target               := file("generated/client/sttp/target"),
    // openApiConfigFile := "client/java/openapi-java-config.json",
    dependencyOverrides ++= Seq(
      "com.softwaremill.sttp.client3" %% "core" % "3.11.0",
      // "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.35.3",
      "com.softwaremill.sttp.client3" %% "json4s"         % "3.11.0",
      "org.json4s"                    %% "json4s-jackson" % "4.0.7"
    )
    // Compile / sourceGenerators += Def.task {
    //       val files = (Compile / openApiGenerate).value
    //       files.filter(_.getName.endsWith(".scala"))
    //     }.taskValue
  )
  .settings(commonSettings)

lazy val pekko = project
  .in(file("generated/client/pekko"))
  .settings(
    scalaVersion         := "3.3.3",
    openApiInputSpec     := "openapi.yaml",
    openApiGeneratorName := "scala-pekko",
    target               := file("generated/client/pekko/target")
  )
  .settings(commonSettings)

// still using sttpclientv3
lazy val sttp4 = project
  .in(file("generated/client/sttp4"))
  .settings(
    scalaVersion                 := "3.3.3",
    openApiInputSpec             := "openapi.yaml",
    openApiGeneratorName         := "scala-sttp4",
    target                       := file("generated/client/sttp4/target"),
    openApiApiFilesConstrainedTo := List[String](""),
    openApiAdditionalProperties := Map(
      "withXml"         -> "false", // optional
      "scalaVersion"    -> "3.3.3", // important: this enables Scala 3 syntax
      "enumClassPrefix" -> "true",  // optional
      "apiNameSuffix"   -> ""       //  prevents "Api" from being appended
    ),
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client4" %% "core"           % "4.0.3",
      "com.softwaremill.sttp.client4" %% "jsoniter"       % "4.0.3",
      "com.softwaremill.sttp.client4" %% "json4s"         % "4.0.3",
      "org.json4s"                    %% "json4s-jackson" % "4.0.6"
    )
  )
  .settings(commonSettings)

lazy val http4s = project
  .in(file("generated/client/http4s"))
  .settings(
    scalaVersion                 := "3.3.3",
    openApiInputSpec             := "openapi.yaml",
    openApiGeneratorName         := "scala-http4s",
    target                       := file("generated/client/http4s/target"),
    openApiApiFilesConstrainedTo := List[String](),
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"    %% "http4s-circe"        % Http4sVersion,
      "org.http4s"    %% "http4s-dsl"          % Http4sVersion,
      "org.http4s"    %% "http4s-client"       % Http4sVersion,
      "io.circe"      %% "circe-core"          % CirceVersion,
      "io.circe"      %% "circe-generic"       % CirceVersion,
      "io.circe"      %% "circe-parser"        % CirceVersion,
      "org.scalatest" %% "scalatest"           % "3.2.19" % "test"
    )
  )
  .settings(commonSettings)
  .settings(
    scalacOptions := Seq(
      "-encoding",
      "UTF-8",
      "-deprecation",
      "-unchecked",
      "-feature",
      "-language:existentials,experimental.macros,higherKinds,implicitConversions,postfixOps,adhocExtensions",
      "-Yretain-trees",
      "-Xmax-inlines:100",
      "-Ykind-projector:underscores",
      "-source:future"
    )
  )

lazy val models = project
  .in(file("generated/client/models"))
  .settings(
    openApiApiFilesConstrainedTo := List.empty,
    scalaVersion                 := "3.3.3",
    openApiInputSpec             := "openapi.yaml",
    openApiGeneratorName         := "scala-http4s",
    target                       := file("generated/client/models/target"),
    libraryDependencies ++= Seq(
      "org.http4s"                            %% "http4s-ember-client"  % Http4sVersion,
      "org.http4s"                            %% "http4s-circe"         % Http4sVersion,
      "org.http4s"                            %% "http4s-dsl"           % Http4sVersion,
      "io.circe"                              %% "circe-core"           % CirceVersion,
      "org.http4s"                            %% "http4s-client"        % Http4sVersion,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-circe" % "2.35.3",
      "org.scalatest"                         %% "scalatest"            % "3.2.19" % "test"
    )
  )
  .settings(commonSettings)
  .settings(
    scalacOptions := Seq(
      "-encoding",
      "UTF-8",
      "-deprecation",
      "-unchecked",
      "-feature",
      "-language:existentials,experimental.macros,higherKinds,implicitConversions,postfixOps,adhocExtensions",
      "-Yretain-trees",
      "-Xmax-inlines:100",
      "-Ykind-projector:underscores",
      "-source:future"
    )
  )

lazy val akka = project
  .in(file("generated/client/akka"))
  .settings(
    openApiInputSpec     := "openapi.yaml",
    openApiGeneratorName := "scala-akka",
    target               := file("generated/client/akka/target"),
    commonSettings
  )

Compile / unmanagedSourceDirectories += baseDirectory.value / "generated/client/sttp"
//Metals requires the semanticdb compiler plugin

Global / parallelExecution := true

Global / concurrentRestrictions += Tags.limit(Tags.Compile, 4) // 4 cores