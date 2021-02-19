package org.open.boot.util.wol;

import org.apache.commons.collections4.CollectionUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author barnak
 */
public class LanIp {

    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {
        LanPing lanPing = new LanPing();
        Thread thread = new Thread(lanPing);
        thread.start();
        thread.join();
//        for (FutureTask<HostInfo> futureTask : lanPing.getPingList()) {
//            System.out.println(futureTask.get().host +"->>>>"+ futureTask.get().reachable);
//        }
        for (String ip : lanPing.getUsedHostList()) {
            System.out.println(ip +"->>>>"+ true);
        }
    }


    private static class LanPing implements Runnable {

        private final List<FutureTask<HostInfo>> pingList;

        /**
         * 局域网查询所有可能的 IP 地址的结果集
         */
        private final List<String> hostList;

        /**
         * 局域网查询已经使用的 IP 地址的结果集
         */
        private final List<String> usedHostList;


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

        @Override
        public synchronized void run() {
            try {
                for (String host : hostList) {
                    Callable<HostInfo> callable = new ExecutePing(host);
                    FutureTask<HostInfo> futureTask = new FutureTask<>(callable);
                    pingList.add(futureTask);
                    new Thread(futureTask).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<FutureTask<HostInfo>> getPingList() {
            return pingList;
        }

        public List<String> getHostList() {
            return hostList;
        }

        public List<String> getUsedHostList() throws ExecutionException, InterruptedException {
            if (CollectionUtils.isEmpty(pingList)) {
                return usedHostList;
            }
            for (FutureTask<HostInfo> futureTask : pingList) {
                HostInfo hostInfo = futureTask.get();
                if (hostInfo.getReachable()) {
                    usedHostList.add(hostInfo.getHost());
                }
            }
            return usedHostList;
        }
    }


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
     * 主机信息
     */
    private static class HostInfo {

        /**
         * 主机IP地址
         */
        private String host;

        /**
         * 能否Ping通
         */
        private boolean reachable;

        /**
         * 主机信息 {@link InetAddress}
         */
        private InetAddress inetAddress;

        public HostInfo(String host, boolean reachable, InetAddress inetAddress) {
            this.host = host;
            this.reachable = reachable;
            this.inetAddress = inetAddress;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public boolean getReachable() {
            return reachable;
        }

        public void setReachable(boolean reachable) {
            this.reachable = reachable;
        }

        public InetAddress getInetAddress() {
            return inetAddress;
        }

        public void setInetAddress(InetAddress inetAddress) {
            this.inetAddress = inetAddress;
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
}
