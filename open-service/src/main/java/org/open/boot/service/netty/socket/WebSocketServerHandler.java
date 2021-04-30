package org.open.boot.service.netty.socket;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.open.boot.netty.MessageDTO;
import org.springframework.web.socket.AbstractWebSocketMessage;
import java.util.List;

/**
 * @author barnak
 */
@Slf4j
public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        MessageDTO messageDTO = JSONObject.parseObject(msg.text(), MessageDTO.class);
        if (messageDTO.getMessageType().equals(MessageDTO.Type.TYPE_NEW.getMessageType())) {
            WebSocketUser.add(messageDTO.getFromUserName(), ctx.channel());
            messageDTO.setTargetUserName(messageDTO.getFromUserName());
            messageDTO.setFromUserName("SYSTEM");
            messageDTO.setMessage(JSONObject.toJSONString(WebSocketUser.getUserList()));
            ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(messageDTO)));
        } else {
            List<Channel> webUsers = WebSocketUser.getSessionByUserName(messageDTO.getTargetUserName());
            if (webUsers == null || webUsers.size() == 0) {
                System.out.print("发送给" + messageDTO.getTargetUserName() + ",当前无session");
                MessageDTO messageDTOError = new MessageDTO();
                messageDTOError.setFromUserName("SYSTEM");
                messageDTOError.setTargetUserName(messageDTO.getFromUserName());
                messageDTOError.setMessageType(MessageDTO.Type.TYPE_ERROR.getMessageType());
                messageDTOError.setMessage("发送失败！");
                ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(messageDTOError)));
                return;
            }
            System.out.print("发送给" + messageDTO.getTargetUserName() + ",当前session个数为：" + webUsers.size());

            for (int i = 0; i < webUsers.size(); i++) {
                Channel session = webUsers.get(i);
                if (!session.isOpen()) {
                    WebSocketUser.removeWebSocketSession(messageDTO.getTargetUserName(), session);
                }

                session.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(messageDTO)));
            }
        }

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("用户：" + ctx.channel().id().asLongText() + "上线");
        WebSocketUser.add(ctx.channel().id().asLongText(), ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("用户下线: " + ctx.channel().id().asLongText());
        WebSocketUser.removeWebSocketSession(ctx.channel().id().asLongText(), ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
        WebSocketUser.removeWebSocketSession(ctx.channel().id().asLongText(), ctx.channel());
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public static void sendMessageToUser(String userName, AbstractWebSocketMessage<?> message) {
        List<Channel> webUsers = WebSocketUser.getSessionByUserName(userName);
        if (webUsers == null || webUsers.size() == 0) {
            log.error("发送给{},当前无session", userName);
            return;
        }
        log.info("发送给{},当前session个数为：{}", userName, webUsers.size());
        for (Channel channel : webUsers) {
            if (!channel.isOpen()) {
                WebSocketUser.removeWebSocketSession(userName, channel);
            }
            channel.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(message)));
        }
    }
}
