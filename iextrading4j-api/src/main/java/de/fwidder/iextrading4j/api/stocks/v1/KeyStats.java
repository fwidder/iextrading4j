package de.fwidder.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class KeyStats implements Serializable {

    private static final long serialVersionUID = -3732743440177222315L;

    private final String companyName;
    private final BigDecimal marketcap;
    private final BigDecimal week52high;
    private final BigDecimal week52low;
    private final BigDecimal week52change;
    private final BigDecimal week52highSplitAdjustOnly;
    private final BigDecimal week52lowSplitAdjustOnly;
    private final BigDecimal sharesOutstanding;
    private final BigDecimal Float;
    private final String symbol;
    private final BigDecimal avg10Volume;
    private final BigDecimal avg30Volume;
    private final BigDecimal day200MovingAvg;
    private final BigDecimal day50MovingAvg;
    private final BigDecimal employees;
    private final BigDecimal ttmEPS;
    private final BigDecimal ttmDividendRate;
    private final BigDecimal dividendYield;
    private final LocalDate nextDividendDate;
    private final LocalDate exDividendDate;
    private final LocalDate nextEarningsDate;
    private final BigDecimal peRatio;
    private final BigDecimal maxChangePercent;
    private final BigDecimal year5ChangePercent;
    private final BigDecimal year2ChangePercent;
    private final BigDecimal year1ChangePercent;
    private final BigDecimal ytdChangePercent;
    private final BigDecimal month6ChangePercent;
    private final BigDecimal month3ChangePercent;
    private final BigDecimal month1ChangePercent;
    private final BigDecimal day5ChangePercent;
    private final BigDecimal day30ChangePercent;
    private final BigDecimal beta;

    @JsonCreator
    public KeyStats(
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("marketcap") final BigDecimal marketcap,
            @JsonProperty("week52high") final BigDecimal week52high,
            @JsonProperty("week52low") final BigDecimal week52low,
            @JsonProperty("week52highSplitAdjustOnly") final BigDecimal week52highSplitAdjustOnly,
            @JsonProperty("week52lowSplitAdjustOnly") final BigDecimal week52lowSplitAdjustOnly,
            @JsonProperty("week52change") final BigDecimal week52change,
            @JsonProperty("sharesOutstanding") final BigDecimal sharesOutstanding,
            @JsonProperty("float") final BigDecimal aFloat,
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("avg10Volume") final BigDecimal avg10Volume,
            @JsonProperty("avg30Volume") final BigDecimal avg30Volume,
            @JsonProperty("day200MovingAvg") final BigDecimal day200MovingAvg,
            @JsonProperty("day50MovingAvg") final BigDecimal day50MovingAvg,
            @JsonProperty("employees") final BigDecimal employees,
            @JsonProperty("ttmEPS") final BigDecimal ttmEPS,
            @JsonProperty("ttmDividendRate") final BigDecimal ttmDividendRate,
            @JsonProperty("dividendYield") final BigDecimal dividendYield,
            @JsonProperty("nextDividendDate") final LocalDate nextDividendDate,
            @JsonProperty("exDividendDate") final LocalDate exDividendDate,
            @JsonProperty("nextEarningsDate") final LocalDate nextEarningsDate,
            @JsonProperty("peRatio") final BigDecimal peRatio,
            @JsonProperty("maxChangePercent") final BigDecimal maxChangePercent,
            @JsonProperty("year5ChangePercent") final BigDecimal year5ChangePercent,
            @JsonProperty("year2ChangePercent") final BigDecimal year2ChangePercent,
            @JsonProperty("year1ChangePercent") final BigDecimal year1ChangePercent,
            @JsonProperty("ytdChangePercent") final BigDecimal ytdChangePercent,
            @JsonProperty("month6ChangePercent") final BigDecimal month6ChangePercent,
            @JsonProperty("month3ChangePercent") final BigDecimal month3ChangePercent,
            @JsonProperty("month1ChangePercent") final BigDecimal month1ChangePercent,
            @JsonProperty("day5ChangePercent") final BigDecimal day5ChangePercent,
            @JsonProperty("day30ChangePercent") final BigDecimal day30ChangePercent,
            @JsonProperty("beta") final BigDecimal beta) {
        this.companyName = companyName;
        this.marketcap = marketcap;
        this.week52high = week52high;
        this.week52low = week52low;
        this.week52highSplitAdjustOnly = week52highSplitAdjustOnly;
        this.week52lowSplitAdjustOnly = week52lowSplitAdjustOnly;
        this.week52change = week52change;
        this.sharesOutstanding = sharesOutstanding;
        this.Float = aFloat;
        this.symbol = symbol;
        this.avg10Volume = avg10Volume;
        this.avg30Volume = avg30Volume;
        this.day200MovingAvg = day200MovingAvg;
        this.day50MovingAvg = day50MovingAvg;
        this.employees = employees;
        this.ttmEPS = ttmEPS;
        this.ttmDividendRate = ttmDividendRate;
        this.dividendYield = dividendYield;
        this.nextDividendDate = nextDividendDate;
        this.exDividendDate = exDividendDate;
        this.nextEarningsDate = nextEarningsDate;
        this.peRatio = peRatio;
        this.maxChangePercent = maxChangePercent;
        this.year5ChangePercent = year5ChangePercent;
        this.year2ChangePercent = year2ChangePercent;
        this.year1ChangePercent = year1ChangePercent;
        this.ytdChangePercent = ytdChangePercent;
        this.month6ChangePercent = month6ChangePercent;
        this.month3ChangePercent = month3ChangePercent;
        this.month1ChangePercent = month1ChangePercent;
        this.day5ChangePercent = day5ChangePercent;
        this.day30ChangePercent = day30ChangePercent;
        this.beta = beta;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getMarketcap() {
        return marketcap;
    }

    public BigDecimal getWeek52high() {
        return week52high;
    }

    public BigDecimal getWeek52low() {
        return week52low;
    }

    public BigDecimal getWeek52highSplitAdjustOnly() {
        return week52highSplitAdjustOnly;
    }

    public BigDecimal getWeek52lowSplitAdjustOnly() {
        return week52lowSplitAdjustOnly;
    }

    public BigDecimal getWeek52change() {
        return week52change;
    }

    public BigDecimal getSharesOutstanding() {
        return sharesOutstanding;
    }

    public BigDecimal getFloat() {
        return Float;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getAvg10Volume() {
        return avg10Volume;
    }

    public BigDecimal getAvg30Volume() {
        return avg30Volume;
    }

    public BigDecimal getDay200MovingAvg() {
        return day200MovingAvg;
    }

    public BigDecimal getDay50MovingAvg() {
        return day50MovingAvg;
    }

    public BigDecimal getEmployees() {
        return employees;
    }

    public BigDecimal getTtmEPS() {
        return ttmEPS;
    }

    public BigDecimal getTtmDividendRate() {
        return ttmDividendRate;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public LocalDate getNextDividendDate() {
        return nextDividendDate;
    }

    public LocalDate getExDividendDate() {
        return exDividendDate;
    }

    public LocalDate getNextEarningsDate() {
        return nextEarningsDate;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public BigDecimal getMaxChangePercent() {
        return maxChangePercent;
    }

    public BigDecimal getYear5ChangePercent() {
        return year5ChangePercent;
    }

    public BigDecimal getYear2ChangePercent() {
        return year2ChangePercent;
    }

    public BigDecimal getYear1ChangePercent() {
        return year1ChangePercent;
    }

    public BigDecimal getYtdChangePercent() {
        return ytdChangePercent;
    }

    public BigDecimal getMonth6ChangePercent() {
        return month6ChangePercent;
    }

    public BigDecimal getMonth3ChangePercent() {
        return month3ChangePercent;
    }

    public BigDecimal getMonth1ChangePercent() {
        return month1ChangePercent;
    }

    public BigDecimal getDay5ChangePercent() {
        return day5ChangePercent;
    }

    public BigDecimal getDay30ChangePercent() {
        return day30ChangePercent;
    }

    public BigDecimal getBeta() {
        return beta;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final KeyStats keyStats = (KeyStats) o;
        return Objects.equals(companyName, keyStats.companyName) &&
                Objects.equals(marketcap, keyStats.marketcap) &&
                Objects.equals(week52high, keyStats.week52high) &&
                Objects.equals(week52low, keyStats.week52low) &&
                Objects.equals(week52change, keyStats.week52change) &&
                Objects.equals(week52highSplitAdjustOnly, keyStats.week52highSplitAdjustOnly) &&
                Objects.equals(week52lowSplitAdjustOnly, keyStats.week52lowSplitAdjustOnly) &&
                Objects.equals(sharesOutstanding, keyStats.sharesOutstanding) &&
                Objects.equals(Float, keyStats.Float) && Objects.equals(symbol, keyStats.symbol) &&
                Objects.equals(avg10Volume, keyStats.avg10Volume) &&
                Objects.equals(avg30Volume, keyStats.avg30Volume) &&
                Objects.equals(day200MovingAvg, keyStats.day200MovingAvg) &&
                Objects.equals(day50MovingAvg, keyStats.day50MovingAvg) &&
                Objects.equals(employees, keyStats.employees) &&
                Objects.equals(ttmEPS, keyStats.ttmEPS) &&
                Objects.equals(ttmDividendRate, keyStats.ttmDividendRate) &&
                Objects.equals(dividendYield, keyStats.dividendYield) &&
                Objects.equals(nextDividendDate, keyStats.nextDividendDate) &&
                Objects.equals(exDividendDate, keyStats.exDividendDate) &&
                Objects.equals(nextEarningsDate, keyStats.nextEarningsDate) &&
                Objects.equals(peRatio, keyStats.peRatio) &&
                Objects.equals(maxChangePercent, keyStats.maxChangePercent) &&
                Objects.equals(year5ChangePercent, keyStats.year5ChangePercent) &&
                Objects.equals(year2ChangePercent, keyStats.year2ChangePercent) &&
                Objects.equals(year1ChangePercent, keyStats.year1ChangePercent) &&
                Objects.equals(ytdChangePercent, keyStats.ytdChangePercent) &&
                Objects.equals(month6ChangePercent, keyStats.month6ChangePercent) &&
                Objects.equals(month3ChangePercent, keyStats.month3ChangePercent) &&
                Objects.equals(month1ChangePercent, keyStats.month1ChangePercent) &&
                Objects.equals(day5ChangePercent, keyStats.day5ChangePercent) &&
                Objects.equals(day30ChangePercent, keyStats.day30ChangePercent) &&
                Objects.equals(beta, keyStats.beta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, marketcap, week52high, week52low, week52change, week52highSplitAdjustOnly,
                week52lowSplitAdjustOnly, sharesOutstanding, Float, symbol, avg10Volume, avg30Volume, day200MovingAvg,
                day50MovingAvg, employees, ttmEPS, ttmDividendRate, dividendYield, nextDividendDate, exDividendDate,
                nextEarningsDate, peRatio, maxChangePercent, year5ChangePercent, year2ChangePercent, year1ChangePercent,
                ytdChangePercent, month6ChangePercent, month3ChangePercent, month1ChangePercent, day5ChangePercent,
                day30ChangePercent, beta);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KeyStats.class.getSimpleName() + "[", "]")
                .add("companyName='" + companyName + "'")
                .add("marketcap=" + marketcap)
                .add("week52high=" + week52high)
                .add("week52low=" + week52low)
                .add("week52change=" + week52change)
                .add("week52highSplitAdjustOnly=" + week52highSplitAdjustOnly)
                .add("week52lowSplitAdjustOnly=" + week52lowSplitAdjustOnly)
                .add("sharesOutstanding=" + sharesOutstanding)
                .add("Float=" + Float)
                .add("symbol='" + symbol + "'")
                .add("avg10Volume=" + avg10Volume)
                .add("avg30Volume=" + avg30Volume)
                .add("day200MovingAvg=" + day200MovingAvg)
                .add("day50MovingAvg=" + day50MovingAvg)
                .add("employees=" + employees)
                .add("ttmEPS=" + ttmEPS)
                .add("ttmDividendRate=" + ttmDividendRate)
                .add("dividendYield=" + dividendYield)
                .add("nextDividendDate=" + nextDividendDate)
                .add("exDividendDate=" + exDividendDate)
                .add("nextEarningsDate=" + nextEarningsDate)
                .add("peRatio=" + peRatio)
                .add("maxChangePercent=" + maxChangePercent)
                .add("year5ChangePercent=" + year5ChangePercent)
                .add("year2ChangePercent=" + year2ChangePercent)
                .add("year1ChangePercent=" + year1ChangePercent)
                .add("ytdChangePercent=" + ytdChangePercent)
                .add("month6ChangePercent=" + month6ChangePercent)
                .add("month3ChangePercent=" + month3ChangePercent)
                .add("month1ChangePercent=" + month1ChangePercent)
                .add("day5ChangePercent=" + day5ChangePercent)
                .add("day30ChangePercent=" + day30ChangePercent)
                .add("beta=" + beta)
                .add("float=" + getFloat())
                .toString();
    }
}
