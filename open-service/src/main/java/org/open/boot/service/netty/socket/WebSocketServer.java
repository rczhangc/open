package org.open.boot.service.netty.socket;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.open.boot.netty.NettyServiceTemplate;

/**
 * @author barnak
 */
public class WebSocketServer extends NettyServiceTemplate {

    /**
     * 端口号
     */
    private int port;

    /**
     * 服务名称
     */
    private String name = "Websocket Server";

    public WebSocketServer(int port) {
        this.port = port;
    }

    @Override
    protected ChannelHandler[] createHandlers() {
        System.out.println("收到新连接");
        return new ChannelHandler[] {
                new HttpServerCodec(),
                new ChunkedWriteHandler(),
                new HttpObjectAggregator(8192),
                new WebSocketServerProtocolHandler("/wsa"),
                new WebSocketServerHandler() };
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
