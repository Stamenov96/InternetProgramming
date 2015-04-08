package org.elsys.ip.jsonplaceholder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class PostsApplication extends ResourceConfig {
	public PostsApplication() {
		register(RolesAllowedDynamicFeature.class);
	}
}