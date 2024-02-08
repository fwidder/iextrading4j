package de.fwidder.iextrading4j.sample.iexapi.rest;

import de.fwidder.iextrading4j.api.stats.HistoricalDailyStats;
import de.fwidder.iextrading4j.api.stats.HistoricalStats;
import de.fwidder.iextrading4j.api.stats.IntradayStats;
import de.fwidder.iextrading4j.api.stats.RecentStats;
import de.fwidder.iextrading4j.api.stats.RecordsStats;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.stats.HistoricalDailyStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.HistoricalStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.IntradayStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.RecentStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;

import java.time.YearMonth;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class StatsSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final StatsSample sampleSuite = new StatsSample();

        sampleSuite.intradayRequestSample();
        sampleSuite.recentRequestSample();
        sampleSuite.recordsRequestSample();
        sampleSuite.historicalRequestSample();
        sampleSuite.historicalDailyRequestSample();
    }

    private void intradayRequestSample() {
        final IntradayStats intradayStats = iexTradingClient.executeRequest(new IntradayStatsRequestBuilder()
                .build());
        System.out.println(intradayStats);
    }

    private void recentRequestSample() {
        final List<RecentStats> recentStats = iexTradingClient.executeRequest(new RecentStatsRequestBuilder()
                .build());
        System.out.println(recentStats);
    }

    private void recordsRequestSample() {
        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
        System.out.println(recordsStats);
    }

    private void historicalRequestSample() {
        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2017, 5))
                .build());
        System.out.println(historicalStatsList);
    }

    private void historicalDailyRequestSample() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(new HistoricalDailyStatsRequestBuilder()
                .withLast(10)
                .build());
        System.out.println(historicalDailyStatsList);
    }

}
