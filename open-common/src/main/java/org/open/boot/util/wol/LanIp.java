package org.open.boot.util.wol;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author barnak
 */
public class LanIp {

    private static ThreadPoolTaskExecutor threadPool;

    /**
     * 网段Ping执行
     */
    private static class LanPing implements Callable<LanPing> {

        private final List<Future<HostInfo>> pingList;

        /**
         * 局域网查询所有可能的 IP 地址的结果集
         */
        private final List<String> hostList;

        /**
         * 局域网查询已经使用的 IP 地址的结果集
         */
        private final List<HostInfo> usedHostList;


        public LanPing() throws UnknownHostException {
            this(InetAddress.getLocalHost().getHostAddress());
        }

        public LanPing(String ip) {
            hostList = new ArrayList<>(LanIpConstants.LOCAL_SIZE);
            // 局域网查询所有可能的 IP 地址的结果集
            int lastPointIndex = ip.lastIndexOf('.');
            String stringIpHead = ip.substring(0, ++lastPointIndex);
            String stringIp;
            for (int i = LanIpConstants.FIRST_IP; i <= LanIpConstants.LAST_IP; i++) {
                stringIp = stringIpHead + i;
                hostList.add(stringIp);
            }
            pingList = new ArrayList<>(hostList.size());
            usedHostList = new ArrayList<>();
        }

        public List<Future<HostInfo>> getPingList() {
            return pingList;
        }

        public List<String> getHostList() {
            return hostList;
        }

        public synchronized List<HostInfo> getUsedHostList() throws ExecutionException, InterruptedException {
            if (CollectionUtils.isEmpty(pingList)) {
                return usedHostList;
            }
            List<FutureTask<HostInfo>> usedHostFutureList = new ArrayList<>();
            for (Future<HostInfo> futureTask : pingList) {
                HostInfo hostInfo = futureTask.get();
                if (!hostInfo.getReachable()) {
                    continue;
                }
                Callable<HostInfo> callable = new ExecuteHostName(hostInfo);
                FutureTask<HostInfo> infoTask = new FutureTask<>(callable);
                getThreadPool().submit(infoTask);
                usedHostFutureList.add(infoTask);
            }

            for (FutureTask<HostInfo> futureTask : usedHostFutureList) {
                long startTime = System.currentTimeMillis();
                usedHostList.add(futureTask.get());
                long endTime = System.currentTimeMillis();
                System.out.println("耗时："+ (endTime - startTime));
            }

            return usedHostList;
        }

        @Override
        public LanPing call() {
            for (String host : getHostList()) {
                Callable<HostInfo> callable = new ExecutePing(host);
                System.out.println("扫描并添加host："+ host);
                Future<HostInfo> submit = getThreadPool().submit(callable);
                pingList.add(submit);
                System.out.println("pingList Size："+ pingList.size());
            }
            return this;
        }
    }

    /**
     * 执行Ping命令
     */
    private static class ExecutePing implements Callable<HostInfo> {

        /**
         * 目标IP地址
         */
        private final String host;

        public ExecutePing(String host) {
            this.host = host;
        }

        @Override
        public synchronized HostInfo call() throws Exception {
            InetAddress inetAddress = InetAddress.getByName(host);
            boolean reachable = inetAddress.isReachable(100);
            return new HostInfo(host, reachable, inetAddress);
        }
    }

    /**
     * 执行获取主机名称
     */
    private static class ExecuteHostName implements Callable<HostInfo> {

        private final HostInfo hostInfo;

        public ExecuteHostName(HostInfo hostInfo) {
            this.hostInfo = hostInfo;
        }

        @Override
        public HostInfo call() {
            InetAddress inetAddress = hostInfo.getInetAddress();
            hostInfo.setHostName(inetAddress.getHostName());
            hostInfo.setCanonicalHostName(inetAddress.getCanonicalHostName());
            return hostInfo;
        }
    }

    private static ThreadPoolTaskExecutor getThreadPool() {
        if (null == threadPool) {
            initThreadPool();
        }
        return threadPool;
    }

    private static void initThreadPool() {
        // 核心线程池数量
        int corePoolSize = 255;
        // 最大线程池数量
        int maximumPoolSize = 255 * 4;
        // 线程最大空闲时间，对核心线程无效
        int keepAliveTime = 0;
        // 拒绝策略，所有配置资源都被占用完毕时抛出异常，分页缓存更新不会产生影响
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(corePoolSize);
        pool.setKeepAliveSeconds(keepAliveTime);
        pool.setMaxPoolSize(maximumPoolSize);
        pool.setQueueCapacity(255 * 4);
        pool.setRejectedExecutionHandler(handler);
        pool.setThreadNamePrefix("page-cache-pool");
        pool.initialize();
        threadPool = pool;
    }

    /**
     * 主机信息
     */
    private static class HostInfo {

        /**
         * 主机IP地址
         */
        private final String host;

        /**
         * 能否Ping通
         */
        private final boolean reachable;

        /**
         * 主机别名
         */
        private String hostName;

        /**
         * 主机名称
         */
        private String canonicalHostName;

        /**
         * 主机信息 {@link InetAddress}
         */
        private final InetAddress inetAddress;

        public HostInfo(String host, boolean reachable, InetAddress inetAddress) {
            this.host = host;
            this.reachable = reachable;
            this.inetAddress = inetAddress;
        }

        public String getHost() {
            return host;
        }

        public boolean getReachable() {
            return reachable;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public String getCanonicalHostName() {
            return canonicalHostName;
        }

        public void setCanonicalHostName(String canonicalHostName) {
            this.canonicalHostName = canonicalHostName;
        }

        public InetAddress getInetAddress() {
            return inetAddress;
        }
    }

    interface LanIpConstants {

        /**
         * 查询的 IP 地址的最后一位起始点
         */
        int FIRST_IP = 2;

        /**
         * 查询的 IP 地址的最后一位结束点
         */
        int LAST_IP = 255;

        /**
         * 本地IP地址数量
         */
        int LOCAL_SIZE = 255;
    }

    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {
        Future<LanPing> submit = getThreadPool().submit(new LanPing());
        LanPing lanPing = submit.get();
        System.out.println("pingList Size："+ lanPing.getPingList().size());
        for (Future<HostInfo> futureTask : lanPing.getPingList()) {
            System.out.println(futureTask.get().getHost() +"->>>>"+ futureTask.get().getReachable());
        }
        List<HostInfo> usedHostList = lanPing.getUsedHostList();
        System.out.println("usedHostList Size："+ usedHostList.size());
        for (HostInfo hostInfo : usedHostList) {
            System.out.println(hostInfo.getHost() +"->>>>"+ hostInfo.getReachable() +"->>>>"+ hostInfo.getHostName() +"->>>>"+ hostInfo.getCanonicalHostName());
        }
        getThreadPool().shutdown();
    }
}
