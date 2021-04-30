package org.open.boot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Netty抽象模板
 *
 * @author barnak
 */
public abstract class NettyServiceTemplate {

    private static final EventLoopGroup BOSS_GROUP = new NioEventLoopGroup();
    private static final EventLoopGroup WORKER_GROUP = new NioEventLoopGroup();

    /**
     * 创建处理器
     *
     * @return {@link ChannelHandler}
     */
    protected abstract ChannelHandler[] createHandlers();

    /**
     * 获取监听端口号
     *
     * @return 端口号
     */
    public abstract int getPort();

    /**
     * 获取名称
     *
     * @return 名称
     */
    public abstract String getName();

    @PostConstruct
    public void start() throws Exception {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(BOSS_GROUP, WORKER_GROUP);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ChannelHandler[] handlers = createHandlers();
                for (ChannelHandler channelHandler : handlers) {
                    ch.pipeline().addLast(channelHandler);
                }
            }
        });
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
        serverBootstrap.option(ChannelOption.SO_REUSEADDR, true);

        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, true);

        ChannelFuture channelFuture = serverBootstrap.bind(getPort()).await();
        if (!channelFuture.isSuccess()) {
            System.out.println("无法绑定端口："+ getPort());
            throw new Exception("无法绑定端口："+ getPort());
        }
        System.out.println("服务[{" + getName() + "}]启动完毕，监听端口[{" + getPort() + "}]");
    }

    @PreDestroy
    public void stop() {
        BOSS_GROUP.shutdownGracefully().syncUninterruptibly();
        WORKER_GROUP.shutdownGracefully().syncUninterruptibly();
        System.out.println("服务[{" + getName() + "}]关闭。");
    }

}
