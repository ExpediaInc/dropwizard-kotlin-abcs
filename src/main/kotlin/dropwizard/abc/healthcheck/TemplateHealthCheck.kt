package dropwizard.abc.healthcheck

import com.codahale.metrics.health.HealthCheck
import dropwizard.abc.core.Template

class TemplateHealthCheck : HealthCheck() {

    @Throws(Exception::class)
    override fun check(): HealthCheck.Result {
        val template = Template("Family", "Test")
        template.render("woo")
        template.render(null)
        return HealthCheck.Result.healthy()
    }
}
