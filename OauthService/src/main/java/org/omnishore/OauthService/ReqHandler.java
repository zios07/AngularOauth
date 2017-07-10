package org.omnishore.OauthService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.omnishore.oauth.GoogleAuth;

@Path("/auth")
public class ReqHandler {
	
	GoogleAuth helper = new GoogleAuth();
	
	@GET
	@Path("/hi")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHi() {
		return helper.buildLoginUrl();
	}
}
