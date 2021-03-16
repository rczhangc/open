package org.open.boot.util.wol;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * @author barnak
 */
public class RemoteBootUtil {

    public static void main(String[] args) throws IOException {
        int port = 20105;
        String macAddress = "00-E0-B4-0C-9F-10";
        // 广播地址
        // String destIP = "255.255.255.255";
        // 广播地址
        String destIp = "192.168.3.210";
        mains(macAddress,destIp,port);
    }

    /**
     * 发送开机请求
     *
     * @param macAddress MAC地址
     * @param host 广播目标IP地址
     * @param port IP端口号
     * @throws IOException 发送异常 {@link IOException}
     */
    public static void mains(String macAddress, String host, int port) throws IOException {
        // 检测 mac 地址,并将其转换为二进制
        byte[] destMac = getMacBytes(macAddress);
        // 获取IP地址数据
        InetAddress destHost = InetAddress.getByName(host);
        // 幻数据包数组
        byte[] magicBytes = Arrays.copyOf(MagicPacketConstants.HEAD_BYTE, MagicPacketConstants.LENGTH);
        // 从第7个位置开始把mac地址放入16次
        for (int i = 0; i < MagicPacketConstants.MAC_ADDRESS_NUM; i++) {
            for (int j = 0; j < destMac.length; j++) {
                magicBytes[6 + destMac.length * i + j] = destMac[j];
            }
        }
        // 发送数据包
        DatagramPacket dp = new DatagramPacket(magicBytes, magicBytes.length, destHost, port);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
    }

    /**
     * 获取MAC地址十进制字节
     *
     * @param macStr MAC地址
     * @return 对应的十进制
     * @throws IllegalArgumentException 非法参数异常 {@link IllegalArgumentException}
     */
    private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        String[] hex = macStr.split(MacAddressConstants.SPLIT_REG_EXP);
        if (hex.length != MacAddressConstants.LENGTH) {
            // 错误的MAC地址
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        byte[] bytes = new byte[MacAddressConstants.LENGTH];
        try {
            for (int i = 0; i < MacAddressConstants.LENGTH; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], MacAddressConstants.RADIX);
            }
        } catch (NumberFormatException e) {
            // MAC地址中的十六进制数字无效
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }

    /**
     * MAC地址相关常量
     */
    interface MacAddressConstants {

        /**
         * MAC地址进制数
         */
        int RADIX = 16;

        /**
         * MAC地址长度
         */
        int LENGTH = 6;

        /**
         * 分割规则
         */
        String SPLIT_REG_EXP = "([:\\-])";
    }

    interface MagicPacketConstants {

        /**
         * 幻数据包长度
         */
        int LENGTH = 102;

        /**
         * 换数据包前6位，0xFF即 "FF"的二进制（FF FF FF FF FF FF）
         */
        byte[] HEAD_BYTE = new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};

        /**
         * 幻数据包MAC地址次数
         */
        int MAC_ADDRESS_NUM = 16;
    }
}
