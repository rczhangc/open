package org.open.boot.service.netty.string;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.open.boot.netty.NettyServiceTemplate;

/**
 * 字符串服务
 *
 * @author barnak
 */
public class StringTcpServer extends NettyServiceTemplate {

    /**
     * 端口号
     */
    private int port;

    /**
     * 服务名称
     */
    private String name = "String Server";

    public StringTcpServer(int port) {
        this.port = port;
    }

    @Override
    protected ChannelHandler[] createHandlers() {
        System.out.println(name + "收到新的请求");
        return new ChannelHandler[] {
                new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()),
                new StringDecoder(),
                new StringEncoder(),
                new StringTcpServerHandler()
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
