import scala.sys.process.Process

import play.sbt.PlayRunHook
import sbt._

/**
  * This is a PlayRunHook that runs the frontend build process (npm start) in a separate process. It
  * also watches for changes in the frontend source files and restarts the process if needed.
  *
  * @param base
  *   The base directory of the project.
  */
object UIRunHook {

  def apply(base: File): PlayRunHook = {

    object NpmProcess extends PlayRunHook {

      var watchProcess: Option[Process] = None

      override def afterStarted(): Unit = {
        // don't run "npm start" directly as it leaves zombie node.js child processes on termination
        watchProcess = Some(
          Process(
            "node node_modules/react-scripts/scripts/start.js",
            base,
            "EXTEND_ESLINT" -> "true"
          ).run()
        )
      }

      override def afterStopped(): Unit = {
        println("[sbt log] Shutting down UI...")
        watchProcess.foreach(_.destroy())
        watchProcess = None
      }
    }

    NpmProcess
  }

}
