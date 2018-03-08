package dropwizard.kotlin.service

import dropwizard.kotlin.service.filter.ContextFilter
import dropwizard.kotlin.service.healthcheck.TemplateHealthCheck
import dropwizard.kotlin.service.resource.*
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class ABCService : Application<HomeServiceConfig>() {

    override fun run(config: HomeServiceConfig, env: Environment) {
        env.jersey().register(EcoResource())
        env.healthChecks().register("default", TemplateHealthCheck())
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            ABCService().run(*args)
        }
    }

}

