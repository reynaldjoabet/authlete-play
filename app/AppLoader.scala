import java.security.Provider
import java.security.Security

//import com.nimbusds.jose.crypto.bc.BouncyCastleProviderSingleton;
import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal

import play.api.{Application, ApplicationLoader, Logger, LoggerConfigurator}
import play.api.ApplicationLoader.Context

class AppLoader extends ApplicationLoader {

  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }

    new AppComponents(context).application

  }

}
