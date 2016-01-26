package com.trading;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class FinanceDataServiceIntegrationTest {

    @Before
    public void setUp() throws Exception {
        FinanceDataApplication.main(new String[0]);
    }

    @Test
    public void service_returns_data_for_intel_symbol() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Instrument instrument = restTemplate.getForObject(
                "http://localhost:9004/api/instrument/INTC",
                Instrument.class
        );

        assertThat(instrument.getName()).isEqualTo("Intel Corporation Stocks");
        assertThat(instrument.getExchange()).isEqualTo("NMS");
        assertThat(instrument.getCurrency()).isEqualTo("USD");
        assertThat(instrument.getSymbol()).isEqualTo("INTC");
    }
}