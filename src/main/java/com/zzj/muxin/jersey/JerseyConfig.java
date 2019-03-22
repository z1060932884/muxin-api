package com.zzj.muxin.jersey;

import com.zzj.muxin.filter.ResponseFilter;
import com.zzj.muxin.filter.WriterInterceptor;
import com.zzj.muxin.jersey.service.Endpoint;
import com.zzj.muxin.provider.GsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);

        //注册 MultiPart
        register(MultiPartFeature.class);
        //注册json转换器
        register(GsonProvider.class);

        //注册日志打印输出
//        register(Log.class);

        register(ResponseFilter.class);
        register(WriterInterceptor.class);
    }
}
