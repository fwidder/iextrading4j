package de.fwidder.iextrading4j.client.rest.request.corporate;

import de.fwidder.iextrading4j.api.corporate.AdvancedDistribution;
import de.fwidder.iextrading4j.client.rest.request.datapoint.AbstractStockTimeSeriesRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class AdvancedDistributionRequestBuilder extends AbstractStockTimeSeriesRequestBuilder<List<AdvancedDistribution>,
        AdvancedDistributionRequestBuilder> {

    public AdvancedDistributionRequestBuilder() {
        super("advanced_distribution", new GenericType<List<AdvancedDistribution>>() {
        });
    }
}
