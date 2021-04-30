package org.open.boot.service.netty.json;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObject;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author barnak
 */
public class HttpMsgRequestDecoder extends MessageToMessageEncoder<HttpObject> {

    private String charset;

    public HttpMsgRequestDecoder(String charset) {
        super();
        this.charset = charset;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, HttpObject msg, List<Object> out) throws Exception {
        FullHttpRequest request = (FullHttpRequest) msg;

        ByteBuf buf = request.content();
        String jsonStr = buf.toString(Charset.forName(charset));
        out.add(jsonStr);
    }
}
