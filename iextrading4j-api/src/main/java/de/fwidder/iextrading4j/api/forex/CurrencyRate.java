package de.fwidder.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyRate implements Serializable {

    private static final long serialVersionUID = -5880260943698563399L;

    private final String symbol;
    private final BigDecimal rate;
    private final Long timestamp;
    private final Boolean isDerived;

    @JsonCreator
    public CurrencyRate(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("rate") final BigDecimal rate,
            @JsonProperty("timestamp") final Long timestamp,
            @JsonProperty("isDerived") final Boolean isDerived) {
        this.symbol = symbol;
        this.rate = rate;
        this.timestamp = timestamp;
        this.isDerived = isDerived;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Boolean isDerived() {
        return isDerived;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CurrencyRate that = (CurrencyRate) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(rate, that.rate) &&
                Objects.equal(timestamp, that.timestamp) &&
                Objects.equal(isDerived, that.isDerived);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, rate, timestamp, isDerived);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("rate", rate)
                .add("timestamp", timestamp)
                .add("isDerived", isDerived)
                .toString();
    }

}
