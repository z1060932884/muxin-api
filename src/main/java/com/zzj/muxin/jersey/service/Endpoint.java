package com.zzj.muxin.jersey.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {
    @GET
    @Path("hello")
    public String message() {
        return "Hello 111111111" ;
    }
}
