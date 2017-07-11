package org.omnishore.OauthService;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.omnishore.oauth.GoogleAuth;

@Path("/auth")
public class ReqHandler {
	
	GoogleAuth helper = new GoogleAuth();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getLoginUrl() {
		return helper.buildLoginUrl();
	}
	
	@GET
	@Path("{code}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserInfo(@PathParam("code") String code) throws IOException {
		
		//Decoding the url 
		code = code.replace("%25", "%").replace("%2F", "/");
		String json = helper.getUserInfoJson(code);
		System.out.println(json);
		return json;
	}
	
}
