package org.open.boot.util.wol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author barnak
 */
public class LanIp {


//    public static void main(String[] args) {
//        System.out.println("开始......");
//        LanIp ip = new LanIp();
//        ArrayList<String> list =  ip.getLanIPArrayList();
//        System.out.println("最后有多少个===>"+list.size());
//    }

    public ArrayList<String> getLanIPArrayList() {
        ArrayList<String> arrayIP = null;
        try {
            InitSystem initSystem = null;
            initSystem = new InitSystem();
            Thread thread = new Thread(initSystem);
            thread.start();
            thread.join();
            arrayIP = initSystem.getArrayIPUsed();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arrayIP;
    }

    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {
        LanPing lanPing = new LanPing();
        Thread thread = new Thread(lanPing);
        thread.start();
        thread.join();

        for (FutureTask<HostInfo> futureTask : lanPing.pingList) {
            System.out.println(futureTask.get().host +"->>>>"+ futureTask.get().reachable);
        }
    }

    private class InitSystem implements Runnable {
        private int firstIP = 2;// 查询的 IP 地址的最后一位起始点

        private int lastIP = 255;// 查询的 IP 地址的最后一位结束点

        private volatile ArrayList<Thread> arrayThread;// 子线程段

        private final int MAXTHREADNUM = 30; // 最大同时进行的子线程数量

        private int threadNumNow;// 当前正在进行的子线程数量

        private volatile ArrayList<String> arrayIP;// 局域网查询所有可能的 IP 地址的结果集

        private volatile ArrayList<String> arrayIPUsed;// 局域网查询已经使用的 IP 地址的结果集

        private InitSystem(String ip) {
            System.out.println("IP===>"+ip);
            arrayIP = new ArrayList<String>();
            arrayIPUsed = new ArrayList<String>();
            arrayThread = new ArrayList<Thread>();
            setIPAddressList(ip);
        }

        private InitSystem() throws UnknownHostException {
            this(InetAddress.getLocalHost().getHostAddress());
        }

        private synchronized ArrayList<String> getArrayIPUsed() {
            try {
                System.out.println("getArrayIPUsed:  arrayIP.size===>"+arrayIP.size());
                while (arrayIP.size() > 0) {
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return arrayIPUsed;
        }

        private void setIPAddressList(String ip) {
            // 根据这个 ip 地址查询它所在的局域网的所有可能 IP 地址的集合
            int lastPointIndex = ip.lastIndexOf('.');
            String stringIPHead = ip.substring(0, ++lastPointIndex);
            System.out.println("stringIPHead===>"+stringIPHead);
            String stringIP = null;
            for (int i = firstIP; i <= lastIP; i++) {
                stringIP = stringIPHead + i;
                arrayIP.add(stringIP);
            }
            System.out.println("进放到这里...arrayIP的总个数："+arrayIP.size());
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("run()  arrayIP.size()===>"+arrayIP.size());
                    System.out.println("run()  threadNumNow===>"+threadNumNow);
                    System.out.println("arrayThread.size()"+arrayThread.size());
                    while (arrayIP.size() > 0) {
                        while (threadNumNow >= MAXTHREADNUM) {
                            System.out.println("线程超出30，中止后面的...");
                            for (Thread thread : arrayThread) {
                                if (!thread.getState().equals(
                                        Thread.State.TERMINATED)) {
                                    thread.join(5);
                                }
                                --threadNumNow;
                            }
                            arrayThread = new ArrayList<Thread>();
                        }
                        Thread thread = new Thread(new InnerClass(arrayIP
                                .remove(0)));
                        thread.start();
                        threadNumNow++;
                        arrayThread.add(thread);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private class InnerClass implements Runnable {
            // 线程查询一个 IP 是否是可以连接的 是则加入到相应的 IP 数组
            private String ip;

            private InnerClass(String ip) {
                System.out.println("InnerClass ip===>"+ip);
                this.ip = ip;
            }

            private boolean isUsedIPAddress(String ip) {
                System.out.println("isUsedIPAddress===>"+ip);
                synchronized (this) {
                    System.out.println("进入此地.....");
                    // 判断这个 IP 地址在当前局域网中是否是可连接的 IP
                    Process process = null;
                    BufferedReader bufReader = null;
                    String bufReadLineString = null;
                    try {
                        process = Runtime.getRuntime().exec(
                                "ping " + ip + " -w 100 -n 1");
                        bufReader = new BufferedReader(new InputStreamReader(
                                process.getInputStream()));
                        for (int i = 0; i < 6 && bufReader != null; i++) {
                            bufReader.readLine();
                        }
                        bufReadLineString = bufReader.readLine();
                        System.out.println("bufReadLineString===>"+bufReadLineString);
                        if (bufReadLineString == null) {
                            process.destroy();
                            return false;
                        }
                        if (bufReadLineString.indexOf("timed out") > 0
                                || bufReadLineString.length() < 17
                                || bufReadLineString.indexOf("invalid") > 0) {
                            process.destroy();
                            return false;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    process.destroy();
                    return true;
                }
            }

            @Override
            public void run() {
                synchronized (this) {
                    if (isUsedIPAddress(ip)) {
                        arrayIPUsed.add(ip);
                    }
                }
            }
        }
    }

    private static class LanPing implements Runnable {

        private List<FutureTask<HostInfo>> pingList;

        /**
         * 局域网查询所有可能的 IP 地址的结果集
         */
        private volatile List<String> hostList;

        /**
         * 局域网查询已经使用的 IP 地址的结果集
         */
        private volatile List<String> usedHostList;


        public LanPing() throws UnknownHostException {
            this(InetAddress.getLocalHost().getHostAddress());
        }

        public LanPing(String ip) {
            hostList = new ArrayList<>(255);
            // 局域网查询所有可能的 IP 地址的结果集
            int lastPointIndex = ip.lastIndexOf('.');
            String stringIPHead = ip.substring(0, ++lastPointIndex);
            String stringIP = null;
            for (int i = LanIpConstants.FIRST_IP; i <= LanIpConstants.LAST_IP; i++) {
                stringIP = stringIPHead + i;
                hostList.add(stringIP);
            }
            pingList = new ArrayList<>(hostList.size());
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
         * 并发最大扫描数
         */
        int SCAN_MAX_SIZE = 255;
    }
}
