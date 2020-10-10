package io.quarkus.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
public class HealthService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response redirect() {
        return Response.ok(getServerHealthStatsAsMap()).build();
    }

    private HealthResource getServerHealthStatsAsMap() {
        Runtime runtime = Runtime.getRuntime();

        HealthResource healthResource = new HealthResource();
        healthResource.setUsedMemory(format(runtime.totalMemory() - runtime.freeMemory()));
        healthResource.setTotalMemory(format(runtime.totalMemory()));
        healthResource.setMaxMemory(format(runtime.maxMemory()));
        healthResource.setFreeMemory(format(runtime.freeMemory()));
        healthResource.setAvailableProcessors(runtime.availableProcessors());

        return healthResource;
    }

    public static String format(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB",
                (double)v / (1L << (z*10)),
                " KMGTPE".charAt(z));
    }
}
