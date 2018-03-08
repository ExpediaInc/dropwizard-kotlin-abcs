package dropwizard.abc.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/")
class EcoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun default(): Response {
        return Response.ok().entity("ECO.... ECO... ECO").build()
    }
}