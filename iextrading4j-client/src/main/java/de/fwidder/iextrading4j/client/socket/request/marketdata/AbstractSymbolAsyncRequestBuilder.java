package de.fwidder.iextrading4j.client.socket.request.marketdata;

import de.fwidder.iextrading4j.client.socket.request.IAsyncRequestBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractSymbolAsyncRequestBuilder<R, B extends IAsyncRequestBuilder> implements IAsyncRequestBuilder<R> {

    private Set<String> symbols = new HashSet<>();

    protected Set<String> getSymbols() {
        return symbols;
    }

    protected String getSymbol() {
        return symbols.stream().collect(joining(","));
    }

    public B withSymbol(final String symbol) {
        this.symbols.add(symbol);
        return (B) this;
    }

    public B withSymbols(final String... symbols) {
        this.symbols.addAll(Arrays.asList(symbols));
        return (B) this;
    }

}
