package no.mesan.fagark.persistering.logistikk;

import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

/**
 * REST tjeneste for innlevering/utlevering av ting.
 *
 * @author Geir Nipe
 */
@Service
@Path("/logistikk")
public class LogistikkRestTjeneste {

	final static String JSON_UTF8 = MediaType.APPLICATION_JSON + "; charset=UTF-8";
    final static String TEXT_UTF8 = MediaType.TEXT_PLAIN + "; charset=UTF-8";

    @Context
    UriInfo uriInfo;

    @Inject
    private LogistikkRepository repository;

    /**
     * Personlige eiendeler innlevert av fange.
     *
     * @param ting Ting og tang.
     * @return HTTP response 201 med plassering til innleverte ting.
     */
    @POST
	@Path("/{fangenummer: [0-9]+}/innlevering")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    public Response innlevering(final Long fangenummer, final String ting) {
        final Long personligeEiendelerNokkel = repository.innlevering(fangenummer, ting);
		final URI uri = uriInfo.getAbsolutePathBuilder().path("" + fangenummer).build();
        return Response.created(uri).entity(personligeEiendelerNokkel).build();
    }
	
	/**
	 * Fange fr tilbake det som ble innlevert ved ankomst.
	 **/
    @GET
    @Produces(JSON_UTF8)
	@Path("/{fangenummer: [0-9]+}/tilbakelevering")
	public String tilbakelevering(Long fangenummer) {
		return "HALLO";
	}
	
	/**
	 * Fange fr utlevert det som trengs i et fengsel.
	 **/
    @GET
    @Produces(JSON_UTF8)
	@Path("/{fangenummer: [0-9]+}/startpakke")
	public String startpakke(Long fangenummer) {
		return "HALLO";
	}	
}