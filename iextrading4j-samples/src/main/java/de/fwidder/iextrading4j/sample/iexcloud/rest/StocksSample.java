package de.fwidder.iextrading4j.sample.iexcloud.rest;

import de.fwidder.iextrading4j.api.stocks.Book;
import de.fwidder.iextrading4j.api.stocks.Chart;
import de.fwidder.iextrading4j.api.stocks.ChartRange;
import de.fwidder.iextrading4j.api.stocks.Company;
import de.fwidder.iextrading4j.api.stocks.DelayedQuote;
import de.fwidder.iextrading4j.api.stocks.Earnings;
import de.fwidder.iextrading4j.api.stocks.EffectiveSpread;
import de.fwidder.iextrading4j.api.stocks.Ipos;
import de.fwidder.iextrading4j.api.stocks.LargestTrade;
import de.fwidder.iextrading4j.api.stocks.Logo;
import de.fwidder.iextrading4j.api.stocks.Ohlc;
import de.fwidder.iextrading4j.api.stocks.Quote;
import de.fwidder.iextrading4j.api.stocks.SectorPerformance;
import de.fwidder.iextrading4j.api.stocks.TodayEarnings;
import de.fwidder.iextrading4j.api.stocks.TodayIpos;
import de.fwidder.iextrading4j.api.stocks.VenueVolume;
import de.fwidder.iextrading4j.api.stocks.v1.AdvancedStats;
import de.fwidder.iextrading4j.api.stocks.v1.BalanceSheets;
import de.fwidder.iextrading4j.api.stocks.v1.BarData;
import de.fwidder.iextrading4j.api.stocks.v1.CashFlows;
import de.fwidder.iextrading4j.api.stocks.v1.Dividends;
import de.fwidder.iextrading4j.api.stocks.v1.Estimates;
import de.fwidder.iextrading4j.api.stocks.v1.Financials;
import de.fwidder.iextrading4j.api.stocks.v1.FundOwnership;
import de.fwidder.iextrading4j.api.stocks.v1.IncomeStatements;
import de.fwidder.iextrading4j.api.stocks.v1.InsiderRoster;
import de.fwidder.iextrading4j.api.stocks.v1.InsiderSummary;
import de.fwidder.iextrading4j.api.stocks.v1.InsiderTransaction;
import de.fwidder.iextrading4j.api.stocks.v1.Intraday;
import de.fwidder.iextrading4j.api.stocks.v1.KeyStats;
import de.fwidder.iextrading4j.api.stocks.v1.News;
import de.fwidder.iextrading4j.api.stocks.v1.Ownership;
import de.fwidder.iextrading4j.api.stocks.v1.PriceTarget;
import de.fwidder.iextrading4j.api.stocks.v1.RecommendationTrends;
import de.fwidder.iextrading4j.api.stocks.v1.Split;
import de.fwidder.iextrading4j.api.stocks.v1.TechnicalIndicator;
import de.fwidder.iextrading4j.api.stocks.v1.TechnicalIndicatorType;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.CollectionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.CollectionType;
import de.fwidder.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.DelayedQuoteRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.DividendRange;
import de.fwidder.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.LargestTradeRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ListRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ListType;
import de.fwidder.iextrading4j.client.rest.request.stocks.LogoRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.PeersRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.SectorPerformanceRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.SplitsRange;
import de.fwidder.iextrading4j.client.rest.request.stocks.TodayEarningsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.TodayIposRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.UpcomingIposRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.AdvancedStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.CashFlowRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.DividendsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.EstimatesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.FinancialsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.FundOwnershipRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.IncomeStatementRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.InsiderRosterRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.InsiderSummaryRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.InsiderTransactionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.InstitutionalOwnershipRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.IntradayRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.KeyStatsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.NewsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.Period;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.PreviousMarketRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.PreviousRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.PriceTargetRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.RecommendationTrendsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.SplitsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.v1.TechnicalIndicatorRequestBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StocksSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final StocksSample stocksSample = new StocksSample();

        // This data is not available to free tier accounts
        stocksSample.advancedStatsRequestSample();
        stocksSample.fundOwnershipRequestSample();
        stocksSample.insiderRosterRequestSample();
        stocksSample.insiderSummaryRequestSample();
        stocksSample.insiderTransactionRequestSample();
        stocksSample.institutionalOwnershipRequestSample();

        stocksSample.keyStatsRequestSample();
        stocksSample.balanceSheetRequestSample();
        stocksSample.bookRequestSample();
        stocksSample.cashFlowRequestSample();
        stocksSample.delayedQuoteRequestSample();
        stocksSample.companyRequestSample();
        stocksSample.collectionRequestSample();
        stocksSample.dividendsRequestSample();
        stocksSample.earningsRequestSample();
        stocksSample.todayEarningsRequestSample();
        stocksSample.effectiveSpreadRequestSample();
        stocksSample.estimatesRequestSample();
        stocksSample.financialsRequestSample();
        stocksSample.chartRequestSample();
        stocksSample.incomeStatementRequestSample();
        stocksSample.intradayRequestSample();
        stocksSample.todayIposRequestSample();
        stocksSample.upcomingIposRequestSample();
        stocksSample.largestTradesRequestSample();
        stocksSample.listRequestSample();
        stocksSample.logoRequestSample();
        stocksSample.newsRequestSample();
        stocksSample.ohlcRequestSample();
        stocksSample.peersRequestSample();
        stocksSample.previousRequestSample();
        stocksSample.previousMarketRequestSample();
        stocksSample.priceRequestSample();
        stocksSample.priceTargetRequestSample();
        stocksSample.quoteRequestSample();
        stocksSample.recommendationTrendsRequestSample();
        stocksSample.sectorPerformanceRequestSample();
        stocksSample.splitsRequestSample();
        stocksSample.venueVolumeRequestSample();
        stocksSample.technicalIndicatorSample();

    }

    private void advancedStatsRequestSample() {
        final AdvancedStats advancedStats = cloudClient.executeRequest(new AdvancedStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(advancedStats);
    }

    private void keyStatsRequestSample() {
        final KeyStats keyStats = cloudClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(keyStats);
    }

    private void balanceSheetRequestSample() {
        final BalanceSheets balanceSheets = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        System.out.println(balanceSheets);
    }

    private void bookRequestSample() {
        final Book book = cloudClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(book);
    }

    private void cashFlowRequestSample() {
        final CashFlows cashFlows = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(cashFlows);
    }

    private void collectionRequestSample() {
        final List<Quote> collection = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.LIST)
                .withCollectionName("iexvolume")
                .build());
        System.out.println(collection);
    }

    private void companyRequestSample() {
        final Company company = cloudClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    private void delayedQuoteRequestSample() {
        final DelayedQuote delayedQuote = cloudClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(delayedQuote);
    }

    private void dividendsRequestSample() {
        final List<Dividends> dividends = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("AAPL")
                .withDividendRange(DividendRange.ONE_YEAR)
                .build());
        System.out.println(dividends);
    }

    private void earningsRequestSample() {
        final Earnings earnings = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(earnings);
    }

    private void todayEarningsRequestSample() {
        final TodayEarnings todayEarnings = cloudClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());
        System.out.println(todayEarnings);
    }

    private void effectiveSpreadRequestSample() {
        final List<EffectiveSpread> effectiveSpreads = cloudClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
    }

    private void estimatesRequestSample() {
        final Estimates estimates = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(estimates);
    }

    private void financialsRequestSample() {
        final Financials financials = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(financials);
    }

    private void fundOwnershipRequestSample() {
        final List<FundOwnership> fundOwnerships = cloudClient.executeRequest(new FundOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(fundOwnerships);
    }

    private void chartRequestSample() {
        final List<Chart> charts = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
        System.out.println(charts);
    }

    private void incomeStatementRequestSample() {
        final IncomeStatements incomeStatements = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(incomeStatements);
    }

    private void insiderRosterRequestSample() {
        final List<InsiderRoster> insiderRosters = cloudClient.executeRequest(new InsiderRosterRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(insiderRosters);
    }

    private void insiderSummaryRequestSample() {
        final List<InsiderSummary> insiderSummaries = cloudClient.executeRequest(new InsiderSummaryRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(insiderSummaries);
    }

    private void insiderTransactionRequestSample() {
        final List<InsiderTransaction> transactions = cloudClient.executeRequest(new InsiderTransactionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(transactions);
    }

    private void institutionalOwnershipRequestSample() {
        final List<Ownership> ownerships = cloudClient.executeRequest(new InstitutionalOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ownerships);
    }

    private void intradayRequestSample() {
        final List<Intraday> intradays = cloudClient.executeRequest(new IntradayRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(intradays);
    }

    private void todayIposRequestSample() {
        final TodayIpos todayIpos = cloudClient.executeRequest(new TodayIposRequestBuilder().build());
        System.out.println(todayIpos);
    }

    private void upcomingIposRequestSample() {
        final Ipos ipos = cloudClient.executeRequest(new UpcomingIposRequestBuilder().build());
        System.out.println(ipos);
    }

    private void largestTradesRequestSample() {
        final List<LargestTrade> largestTrades = cloudClient.executeRequest(new LargestTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(largestTrades);
    }

    private void listRequestSample() {
        final List<Quote> quoteList = cloudClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
        System.out.println(quoteList);
    }

    private void logoRequestSample() {
        final Logo logo = cloudClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(logo);
    }

    private void newsRequestSample() {
        final List<News> news = cloudClient.executeRequest(new NewsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(news);
    }

    private void ohlcRequestSample() {
        final Ohlc ohlc = cloudClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ohlc);
    }

    private void peersRequestSample() {
        final List<String> peers = cloudClient.executeRequest(new PeersRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(peers);
    }

    private void previousRequestSample() {
        final BarData previous = cloudClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(previous);
    }

    private void previousMarketRequestSample() {
        final Map<String, BarData> previous = cloudClient.executeRequest(new PreviousMarketRequestBuilder()
                .build());
        System.out.println(previous);
    }

    private void priceRequestSample() {
        final BigDecimal price = cloudClient.executeRequest(new PriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(price);
    }

    private void priceTargetRequestSample() {
        final PriceTarget priceTarget = cloudClient.executeRequest(new PriceTargetRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(priceTarget);
    }

    private void quoteRequestSample() {
        final Quote quote = cloudClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(quote);
    }

    private void recommendationTrendsRequestSample() {
        final List<RecommendationTrends> trends = cloudClient.executeRequest(new RecommendationTrendsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(trends);
    }

    private void sectorPerformanceRequestSample() {
        final List<SectorPerformance> sectorPerformances = cloudClient.executeRequest(
                new SectorPerformanceRequestBuilder().build());
        System.out.println(sectorPerformances);
    }

    private void splitsRequestSample() {
        final List<Split> splits = cloudClient.executeRequest(new SplitsRequestBuilder()
                .withSymbol("AAPL")
                .withSplitsRange(SplitsRange.FIVE_YEARS)
                .build());
        System.out.println(splits);
    }

    private void venueVolumeRequestSample() {
        final List<VenueVolume> venueVolumes = cloudClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(venueVolumes);
    }

    private void technicalIndicatorSample() {
        final TechnicalIndicator indicator = cloudClient.executeRequest(new TechnicalIndicatorRequestBuilder()
                .withSymbol("TWTR")
                .withTechnicalIndicatorType(TechnicalIndicatorType.BBANDS)
                .withRange(ChartRange.SIX_MONTHS)
                .build());
        System.out.println(indicator);
    }

}
