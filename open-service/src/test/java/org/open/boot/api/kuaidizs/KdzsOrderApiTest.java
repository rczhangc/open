package org.open.boot.api.kuaidizs;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.api.kuaidizs.KdzsOrderApi;
import org.open.boot.api.kuaidizs.dto.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author barnak
 */
public class KdzsOrderApiTest extends BaseUnitTest {

    @Resource
    private KdzsOrderApi kdzsOrderApi;

    @Test
    public void create() {
        KdzsMallTradeDTO request = createTradeUtil();
        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.create(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    @Test
    public void batchCreate() throws InterruptedException {
        KdzsMallTradeListDTO request = new KdzsMallTradeListDTO();
        List<KdzsMallTradeDTO> mallTrades = new ArrayList<>();
        //模拟请求参数 --批量订单
        for (int i = 0; i < 3; i++) {
            KdzsMallTradeDTO mallTrade = createTradeUtil();
            mallTrades.add(mallTrade);
            Thread.sleep(1000);
        }
        request.setMallTradeList(mallTrades);
        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.batchCreate(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    @Test
    public void update() {
        //模拟订单修改数据
        KdzsMallTradeUpdateDTO request = new KdzsMallTradeUpdateDTO();
        request.setModified(new Date());
        request.setTid("trade202007231595496355218");
        request.setReceiverAddress("修改订单地址");
        request.setReceiverName("修改收件人姓名");

        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.update(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    @Test
    public void send() {
        //模拟需要发货的订单数据
        KdzsMallTradeSendDTO request = new KdzsMallTradeSendDTO();
        request.setCompanyCode("YTO");
        request.setTid("trade202007231595496355218");
        request.setSplit(String.valueOf(true));
        ArrayList<String> oids = new ArrayList<>();
        oids.add("order202007231595496355220");
        request.setOids(oids);
        request.setWaybillNo("YTO787878787878");

        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.send(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    @Test
    public void refund() {
        //模拟需要退款的订单数据
        KdzsMallTradeRefundDTO request = new KdzsMallTradeRefundDTO();
        request.setTid("trade202007231595497923437");
        //若传入子订单 则默认更改子订单状态而不改变订单状态 不传子订单 默认更改所有订单状态
        ArrayList<String> oids = new ArrayList<>();
        oids.add("order202007231595481842541");
        request.setOids(oids);
        request.setRefundStatus("REFUND_SUCCESSED");

        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.refund(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    @Test
    public void batchDelete() {
        //模拟需要删除订单
        KdzsMallTradeTidListDTO request = new KdzsMallTradeTidListDTO();
        ArrayList<String> tidList = new ArrayList<>();
        tidList.add("trade202007231595497923437");
        tidList.add("trade202007231595497798431");
        request.setTidList(tidList);

        KdzsResponseDTO<Object> kdzsResponseDTO = kdzsOrderApi.batchDelete(request);
        System.out.println(JSON.toJSONString(kdzsResponseDTO));
    }

    public KdzsMallTradeDTO createTradeUtil() {
        //模拟请求数据 --创建订单
        KdzsMallTradeDTO mallTrade = new KdzsMallTradeDTO();
        mallTrade.setPayTime(new Date());
        mallTrade.setCreated(new Date());
        mallTrade.setModified(new Date());
        mallTrade.setSendTime(new Date());
        mallTrade.setTid("trade" + System.currentTimeMillis());
        mallTrade.setBuyerMessage("买家信息");
        mallTrade.setBuyerNick("买家昵称");
        mallTrade.setReceiverName("收件人");
        mallTrade.setReceiverProvince("XX省");
        mallTrade.setReceiverCity("XX市");
        mallTrade.setReceiverCounty("XX区");
        mallTrade.setReceiverAddress("XX大厦");
        mallTrade.setReceiverPhone("183********");
        mallTrade.setReceiverMobile("183********");
        mallTrade.setReceiverZip("10000");
        mallTrade.setTotalNum(10L);
        mallTrade.setTotalFee("20.0");
        mallTrade.setPayment("20.0");
        mallTrade.setPostFee("20.0");
        mallTrade.setDiscountFee("10.0");
        mallTrade.setSellerMemo("这是卖家备注卖家备注");
        mallTrade.setStatus("ORDER_PAID");
        //mallTrade.setRefundStatus("REFUND_ING");

        //模拟请求参数 --订单下的子订单
        KdzsMallOrderDTO mallOrder = new KdzsMallOrderDTO();
        mallOrder.setOrderId("order" + System.currentTimeMillis());
        mallOrder.setPicPath("商品图片的绝对路径https://");
        mallOrder.setSkuUrl("sku_url");
        mallOrder.setStatus("ORDER_PAID");
        //mallOrder.setRefundStatus("REFUND_ING");
        mallOrder.setTitle("商品标题");
        mallOrder.setOuterId("商品外部商家编码");
        mallOrder.setItemId("商品ID");
        mallOrder.setSkuId("skuID");
        mallOrder.setOuterSkuId("商品sku外部商家编码");
        mallOrder.setNumber(1);
        mallOrder.setPrice("10.0");
        mallOrder.setTotalFee("20.0");
        mallOrder.setDiscountFee("0.0");
        mallOrder.setPayment("20.0");
        //商品sku设置
        KdzsMallSkuPropDTO mallSkuProp = new KdzsMallSkuPropDTO();
        mallSkuProp.setKey("颜色");
        mallSkuProp.setValue("白色");
        mallSkuProp.setName("测试sku");
        List<KdzsMallSkuPropDTO> list = Lists.newArrayList();
        list.add(mallSkuProp);
        mallOrder.setSaleProps(list);
        List<KdzsMallOrderDTO> list1 = Lists.newArrayList();
        list1.add(mallOrder);
        mallTrade.setOrders(list1);
        mallTrade.setMallInvoice(null);
        return mallTrade;
    }
}