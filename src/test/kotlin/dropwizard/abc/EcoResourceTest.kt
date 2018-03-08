package dropwizard.abc

import io.dropwizard.testing.ResourceHelpers.resourceFilePath
import io.dropwizard.testing.junit.DropwizardAppRule
import org.glassfish.jersey.client.ClientConfig
import org.glassfish.jersey.client.ClientProperties
import org.glassfish.jersey.client.JerseyClientBuilder
import org.junit.Assert.assertEquals
import org.junit.ClassRule
import org.junit.Test
import javax.ws.rs.client.Client
import javax.ws.rs.core.Response

class EcoResourceTest {

    companion object {
        @ClassRule @JvmField
        val rule = DropwizardAppRule(ABCService::class.java, resourceFilePath("config/abc.yml"))
    }

    @Test
    fun testDefaultResource() {
        val response = client().target("http://127.0.0.1:${rule.localPort}/").request()
                .get(Response::class.java)
        assertEquals(200, response.status.toLong())
        assertEquals("application/json", response.headers.getFirst("Content-Type"))
        val entity = response.readEntity(String::class.java)
        assertEquals("ECO.... ECO... ECO", entity)
    }

    private fun client(): Client {
        val config = ClientConfig()
        config.property(ClientProperties.CONNECT_TIMEOUT, 2000)
        config.property(ClientProperties.READ_TIMEOUT, 5000)
        return JerseyClientBuilder.createClient(config)
    }
}


