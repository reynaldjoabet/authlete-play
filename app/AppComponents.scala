import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future

import controllers.AssetsComponents
import play.api.i18n.I18nComponents
import play.api.libs.concurrent.PekkoComponents
import play.api.libs.mailer.Attachment
import play.api.libs.mailer.AttachmentData
import play.api.libs.mailer.AttachmentDataSource
import play.api.libs.mailer.AttachmentFile
import play.api.libs.mailer.AttachmentURL
import play.api.libs.mailer.CommonsMailer
import play.api.libs.mailer.Email
import play.api.libs.mailer.MailerClient
import play.api.libs.mailer.MailerComponents
import play.api.libs.mailer.MailerConfigurationModule
import play.api.libs.mailer.MailerModule
import play.api.libs.mailer.SMTPConfiguration
import play.api.libs.mailer.SMTPConfigurationModule
import play.api.libs.mailer.SMTPDynamicMailer
import play.api.libs.mailer.SMTPMailer
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.Logging
import play.core.server.ssl.noCATrustManager
import play.core.server.ssl.DefaultSSLEngineProvider
import play.core.server.ssl.ServerSSLEngine
import play.filters.cors
import play.filters.csp
import play.filters.csrf
import play.filters.csrf.CSRFComponents
import play.filters.gzip
import play.filters.gzip.GzipFilterComponents
import play.filters.headers
import play.filters.hosts
import play.filters.https
import play.filters.ip

class AppComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with PekkoComponents
    with AhcWSComponents
    with I18nComponents
    with CSRFComponents
    with GzipFilterComponents
    with AssetsComponents
    with Logging {

  override def router: Router = ???

  override def httpFilters: Seq[EssentialFilter] = ???

}
