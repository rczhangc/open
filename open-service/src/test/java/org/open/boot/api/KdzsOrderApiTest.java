package org.open.boot.api;

import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.api.kuaidizs.KdzsOrderApi;
import org.open.boot.api.kuaidizs.dto.KdzsMallTradeDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;

import javax.annotation.Resource;

/**
 * @author barnak
 */
public class KdzsOrderApiTest extends BaseUnitTest {

    @Resource
    private KdzsOrderApi kdzsOrderApi;

    @Test
    public void create() {
        KdzsMallTradeDTO request = new KdzsMallTradeDTO();
        request.setTid("ADDDSDFSDFSD");
        KdzsResponseDTO kdzsResponseDTO = kdzsOrderApi.create(request);

    }

    @Test
    void batchCreate() {
    }

    @Test
    void update() {
    }

    @Test
    void send() {
    }

    @Test
    void refund() {
    }

    @Test
    void batchDelete() {
    }
}