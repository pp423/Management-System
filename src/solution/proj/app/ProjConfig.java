package solution.proj.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class ProjConfig extends ResourceConfig {

	public ProjConfig() {
		packages("solution.proj.rest");
	}
}
