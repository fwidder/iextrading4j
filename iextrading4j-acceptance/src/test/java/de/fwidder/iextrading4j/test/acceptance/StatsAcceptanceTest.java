package de.fwidder.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.exception.IEXTradingException;
import de.fwidder.iextrading4j.api.stats.HistoricalDailyStats;
import de.fwidder.iextrading4j.api.stats.HistoricalStats;
import de.fwidder.iextrading4j.api.stats.IntradayStats;
import de.fwidder.iextrading4j.api.stats.RecentStats;
import de.fwidder.iextrading4j.api.stats.RecordsStats;
import de.fwidder.iextrading4j.client.rest.request.stats.HistoricalDailyStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.HistoricalStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.IntradayStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.RecentStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;

import java.time.YearMonth;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
@Disabled
class StatsAcceptanceTest extends AcceptanceTestBase {

    @Test
    void intradayAcceptanceTest() {
        final IntradayStats intradayStats = iexTradingClient.executeRequest(new IntradayStatsRequestBuilder()
                .build());
        assertThat(intradayStats).isNotNull();
    }

    @Test
    void recentAcceptanceTest() {
        try {
            final List<RecentStats> recentStats = iexTradingClient.executeRequest(new RecentStatsRequestBuilder()
                    .build());
            assertThat(recentStats).isNotNull();
        } catch (final IEXTradingException e) {
            // Not reliable endpoint - IEX Trading issue
        }
    }

    @Test
    void recordsAcceptanceTest() {
        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
        assertThat(recordsStats).isNotNull();
    }

    @Test
    void historicalAcceptanceTest() {
        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(
                new HistoricalStatsRequestBuilder()
                        .withDate(YearMonth.of(2017, 5))
                        .build());
        assertThat(historicalStatsList).isNotNull();
    }

    @Test
    void historicalDailyAcceptanceTest() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(
                new HistoricalDailyStatsRequestBuilder()
                        .withLast(10)
                        .build());
        assertThat(historicalDailyStatsList).isNotNull();
    }

}
