package com.trading;

class TestData {

    static AllocationReport allocationReport() {
        AllocationReport allocationReport = new AllocationReport();

        allocationReport.setAllocationId("12345");
        allocationReport.setTransactionType(TransactionType.NEW);
        allocationReport.setSecurityId("54321");
        allocationReport.setSecurityIdSource(SecurityIDSource.SEDOL);
        allocationReport.setInstrument(instrument());
        allocationReport.setTradeSide(TradeSide.BUY);

        return allocationReport;
    }

    private static Instrument instrument() {
        Instrument instrument = new Instrument();

        instrument.setCurrency("USD");
        instrument.setExchange("NASDAQ");
        instrument.setName("AMAZON STOCKS");
        instrument.setSymbol("AMZN");

        return instrument;
    }
}
