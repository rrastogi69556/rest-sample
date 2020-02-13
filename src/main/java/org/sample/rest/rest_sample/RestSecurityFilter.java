package org.sample.rest.rest_sample;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;


@Provider
public class RestSecurityFilter implements ContainerRequestFilter{
	
	private static final String AUTHORIZATION = "Authorization";
	private static final String BASIC_AUTHORIZATION = "Basic ";
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		if(context.getUriInfo().getPath().contains("employees")) {
			if(context.getHeaders().containsKey(AUTHORIZATION)) {
				String key = context.getHeaders().getFirst(AUTHORIZATION);
				String encodedString = key.replaceAll(BASIC_AUTHORIZATION, "");
				//byte[] decodedString = Base64.decodeBase64(encodedString);
				/*StringTokenizer st = new StringTokenizer(new String(decodedString));
				*/
				byte[] decoded = Base64.getDecoder().decode(encodedString);
				
				String cred = new String(decoded,  StandardCharsets.UTF_8);
				StringTokenizer st = new StringTokenizer(cred, ":");
				String user = st.nextToken();
				String passString  = st.nextToken();
				if("test@britebill.com" .equals(user) && "britebill".equals(passString)) {
					return;
				}
			}
		
		Response rsp = Response.status(Status.UNAUTHORIZED)
				.entity("User is not authorized to access this resource")
				.build();
		context.abortWith(rsp);
		}
		
	}

}
