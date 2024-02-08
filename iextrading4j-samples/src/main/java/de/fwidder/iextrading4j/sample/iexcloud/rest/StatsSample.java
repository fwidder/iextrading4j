package de.fwidder.iextrading4j.sample.iexcloud.rest;

import de.fwidder.iextrading4j.api.stats.*;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.stats.*;

import java.time.YearMonth;
import java.util.List;

public class StatsSample {

    private final IEXCloudClient iexCloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final StatsSample statsSample = new StatsSample();

        statsSample.intradayRequestSample();
        statsSample.recentRequestSample();
        statsSample.recordsRequestSample();
        statsSample.historicalRequestSample();
        // statsSample.historicalDailyRequestSample();
    }

    private void intradayRequestSample() {
        final IntradayStats intradayStats = iexCloudClient.executeRequest(new IntradayStatsRequestBuilder()
                .build());
        System.out.println(intradayStats);
    }

    private void recentRequestSample() {
        final List<RecentStats> recentStats = iexCloudClient.executeRequest(new RecentStatsRequestBuilder()
                .build());
        System.out.println(recentStats);
    }

    private void recordsRequestSample() {
        final RecordsStats recordsStats = iexCloudClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
        System.out.println(recordsStats);
    }

    private void historicalRequestSample() {
        final List<HistoricalStats> historicalStatsList = iexCloudClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2017, 5))
                .build());
        System.out.println(historicalStatsList);
    }

    private void historicalDailyRequestSample() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexCloudClient.executeRequest(new HistoricalDailyStatsRequestBuilder()
                .withLast(10)
                .build());
        System.out.println(historicalDailyStatsList);
    }

}
