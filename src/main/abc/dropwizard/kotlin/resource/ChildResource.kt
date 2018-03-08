package dropwizard.kotlin.service.resource

import dropwizard.kotlin.service.api.MyMemory
import java.util.concurrent.ConcurrentHashMap
import javax.validation.constraints.NotNull
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response


@Path("/child")
@Consumes(*arrayOf(APPLICATION_JSON))
@Produces(*arrayOf(APPLICATION_JSON))
class ChildResource {
    private val db = ConcurrentHashMap<String, MyMemory>()

    @Path("/ask")
    @GET
    fun get(@QueryParam("key") key: String): Response {
        if (db.containsKey(key)) {
            return Response.ok().entity(db[key]).build()
        }
        return Response.noContent().build()
    }

    @Path("/teach")
    @PUT
    fun put(@NotNull myMemory: MyMemory): Response {
        db.put(myMemory.key, myMemory)
        return Response.ok().build()
    }

    @Path("/tutor")
    @POST
    fun post(@NotNull myMemory: MyMemory): Response {
        db.put(myMemory.key, myMemory)
        return Response.ok().build()
    }

    @Path("/")
    @DELETE
    fun delete(@NotNull @QueryParam("key") key: String): Response {
        db.remove(key)
        return Response.ok().build()
    }

}
