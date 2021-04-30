package org.open.boot.service.netty.json;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.*;
import org.open.boot.netty.HttpResponseMsg;

import java.util.List;

/**
 * @author barnak
 */
public class HttpMsgResponseEncoder extends MessageToMessageEncoder<HttpResponseMsg> {

    /**
     * 编码
     */
    private String charset;

    /**
     * 超时时间
     */
    private int timeout;

    public HttpMsgResponseEncoder(String charset, int timeout) {
        super();
        this.charset = charset;
        this.timeout = timeout;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, HttpResponseMsg msg, List<Object> out) throws Exception {
        try {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(msg.getResCode()),
                    Unpooled.wrappedBuffer(msg.getMessage().getBytes(charset)));
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, msg.getResType()+";charset=" + charset);
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());

            // 强制keep-alive
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            response.headers().set("Keep-Alive", "timeout=" + timeout);

            out.add(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
