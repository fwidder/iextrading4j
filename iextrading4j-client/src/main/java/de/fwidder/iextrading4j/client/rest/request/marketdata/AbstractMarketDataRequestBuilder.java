package de.fwidder.iextrading4j.client.rest.request.marketdata;

import com.google.common.collect.ImmutableMap;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractMarketDataRequestBuilder<R, B extends IRestRequestBuilder>
        extends AbstractRequestFilterBuilder<R, B> {

    public static final String ALL_SYMBOLS = "firehose";

    private Set<String> symbols = new HashSet<>();

    public B withSymbol(String symbol) {
        this.symbols.add(symbol);
        return (B) this;
    }

    public B withSymbols(String... symbols) {
        this.symbols.addAll(Arrays.asList(symbols));
        return (B) this;
    }

    public B withAllSymbols() {
        this.symbols.clear();
        this.symbols.add(ALL_SYMBOLS);
        return (B) this;
    }

    protected Map<String, String> getSymbols() {
        return ImmutableMap.<String, String>builder()
                .put("symbols", symbols.stream().collect(joining(",")))
                .build();
    }

}
