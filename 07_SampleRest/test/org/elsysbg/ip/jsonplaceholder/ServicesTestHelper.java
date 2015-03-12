package org.elsysbg.ip.jsonplaceholder;

import org.elsys.ip.jsonplaceholder.Services;
import org.elsysbg.ip.jsonplaceholder.service.PostsService;

/**
 * Injection should be used instead
 */
public class ServicesTestHelper {
	public static void setPostsService(PostsService postsService) {
		Services.setPostsService(postsService);
	}
}