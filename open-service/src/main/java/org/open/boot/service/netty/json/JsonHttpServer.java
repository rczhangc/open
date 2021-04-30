package org.open.boot.service.netty.json;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.open.boot.netty.NettyServiceTemplate;

/**
 * JSON请求服务
 *
 * @author barnak
 */
public class JsonHttpServer extends NettyServiceTemplate {

    /**
     * 端口号
     */
    private int port;

    /**
     * 服务名称
     */
    private String name = "Json Server";

    public JsonHttpServer(int port) {
        this.port = port;
    }

    @Override
    protected ChannelHandler[] createHandlers() {
        String charset = "UTF-8";
        int timeout = 60;
        System.out.println(name + "收到新的请求");
        return new ChannelHandler[] {
                new HttpResponseEncoder(),
                new HttpRequestEncoder(),
                new HttpObjectAggregator(1048576),
                new HttpMsgResponseEncoder(charset, timeout),
                new HttpMsgRequestDecoder(charset),
                new JsonHttpServerHandler()
        };
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setName(String name) {
        this.name = name;
    }
}
