package dropwizard.abc

import dropwizard.abc.healthcheck.TemplateHealthCheck
import dropwizard.abc.resource.*
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class ABCService : Application<AbcServiceConfig>() {

    override fun run(config: AbcServiceConfig, env: Environment) {
        env.jersey().register(EcoResource())
        env.healthChecks().register("default", TemplateHealthCheck())
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            ABCService().run(*args)
        }
    }

}

