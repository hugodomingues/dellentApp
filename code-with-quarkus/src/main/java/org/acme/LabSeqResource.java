package org.acme;

import io.quarkus.cache.CacheResult;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("labseq")
public class LabSeqResource {

    @GET
    @Path("/{n}")
    @CacheResult(cacheName = "labseq-cache")
    public String getLabSeq(@PathParam("n") int n) {
        return String.valueOf(calculateLabSeq(n));
    }

    private int calculateLabSeq(int n) {
        if( n == 0) return 0;
        else if (n == 1) {
            return 1;
        } else if( n == 2) {
            return 0;
        } else if( n == 3) {
            return 1;
        } else return calculateLabSeq(n - 4) + calculateLabSeq(n- 3);
    }
}
