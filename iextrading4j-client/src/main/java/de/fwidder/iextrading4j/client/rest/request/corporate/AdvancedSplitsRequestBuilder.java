package de.fwidder.iextrading4j.client.rest.request.corporate;

import de.fwidder.iextrading4j.api.corporate.AdvancedSplits;
import de.fwidder.iextrading4j.client.rest.request.datapoint.AbstractStockTimeSeriesRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class AdvancedSplitsRequestBuilder extends AbstractStockTimeSeriesRequestBuilder<List<AdvancedSplits>,
        AdvancedSplitsRequestBuilder> {

    public AdvancedSplitsRequestBuilder() {
        super("advanced_splits", new GenericType<List<AdvancedSplits>>() {
        });
    }
}
