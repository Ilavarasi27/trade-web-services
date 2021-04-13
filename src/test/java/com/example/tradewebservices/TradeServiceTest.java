package com.example.tradewebservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TradeServiceTest {

    TradeService tradeService = new TradeService();

    @Test
    void testRetrieveAll() {
        List<TradeBean> tradeBeans= tradeService.retrieveAll();
        List<TradeBean> expectedBeans = new ArrayList<TradeBean>();
        assertEquals(expectedBeans,tradeBeans);
    }
}
