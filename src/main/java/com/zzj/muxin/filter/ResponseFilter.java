package com.zzj.muxin.filter;

import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * //私钥base64-->MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg2uPgTN+MNblSb8hDlbHrTp5+cXezlErvztt1f9YINgegCgYIKoEcz1UBgi2hRANCAAQnjTvYcLJREJtze99F3OVgIPbTEOylh7x8q99dYBq+dK7wwxEjGf+5Qb8iLWgGRQuP8N4Tnq4cx27L1xLIgkGl
 */
@Component
@Provider
public class ResponseFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

//        Entity entity = (Entity) responseContext.getEntity();
        System.out.println("filter--ResponseFilter->");
//        sm2EncUtils();


    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
//       InputStream inputStream =  requestContext.getEntityStream();
//       byte[] bytes = new byte[1024];
//       inputStream.read(bytes);
//       inputStream.close();
//       System.out.println("ContainerRequestFilter--->"+new String(bytes));
    }
}
