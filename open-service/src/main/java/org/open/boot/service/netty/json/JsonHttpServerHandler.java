package org.open.boot.service.netty.json;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.open.boot.netty.HttpResponseMsg;

/**
 * @author barnak
 */
public class JsonHttpServerHandler extends SimpleChannelInboundHandler<String> {

    String charset = "UTF-8";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("post内容:" + msg);
        HttpResponseMsg hrm = new HttpResponseMsg();
        hrm.setResType(HttpResponseMsg.ResType.JSON.getValue());
        hrm.setResCode(HttpResponseMsg.ResCode.OK.getValue());
        hrm.setMessage(msg);
        ctx.writeAndFlush(hrm);
    }
}
