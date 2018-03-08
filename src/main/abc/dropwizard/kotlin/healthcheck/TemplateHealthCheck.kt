package dropwizard.kotlin.service.healthcheck

import com.codahale.metrics.health.HealthCheck
import dropwizard.kotlin.service.core.Template
import java.util.*

class TemplateHealthCheck : HealthCheck() {

    @Throws(Exception::class)
    override fun check(): HealthCheck.Result {
        val template = Template("Family", "Test")
        template.render("woo")
        template.render(null)
        return HealthCheck.Result.healthy()
    }
}
