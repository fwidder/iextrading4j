package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import de.fwidder.iextrading4j.api.alternative.CryptoEventReason;
import de.fwidder.iextrading4j.api.alternative.CryptoEventType;
import de.fwidder.iextrading4j.api.alternative.CryptoSide;
import de.fwidder.iextrading4j.api.marketdata.SystemEventType;
import de.fwidder.iextrading4j.api.marketdata.TradingStatusReasonType;
import de.fwidder.iextrading4j.api.marketdata.TradingStatusType;
import de.fwidder.iextrading4j.api.refdata.DelistingReason;
import de.fwidder.iextrading4j.api.refdata.DividendTypeId;
import de.fwidder.iextrading4j.api.refdata.FinancialStatus;
import de.fwidder.iextrading4j.api.refdata.Flag;
import de.fwidder.iextrading4j.api.refdata.IssueEvent;
import de.fwidder.iextrading4j.api.refdata.IssueSubType;
import de.fwidder.iextrading4j.api.refdata.IssueType;
import de.fwidder.iextrading4j.api.refdata.ListingCenter;
import de.fwidder.iextrading4j.api.refdata.LuldTier;
import de.fwidder.iextrading4j.api.refdata.PaymentFrequency;
import de.fwidder.iextrading4j.api.refdata.QualifiedDividendType;
import de.fwidder.iextrading4j.api.refdata.SymbolType;
import de.fwidder.iextrading4j.api.stocks.ChartRange;
import de.fwidder.iextrading4j.api.stocks.DividendQualification;
import de.fwidder.iextrading4j.api.stocks.DividendType;
import de.fwidder.iextrading4j.api.stocks.v1.DirectIndirect;
import de.fwidder.iextrading4j.client.properties.PropertiesReader;
import de.fwidder.iextrading4j.client.properties.PropertyType;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Provider
public class IEXTradingMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public IEXTradingMapperContextResolver() {
        objectMapper = initializeObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }

    private ObjectMapper initializeObjectMapper() {
        final ObjectMapper customMapper = new ObjectMapper();

        customMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        customMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                PropertiesReader.getInstance().getBoolean(PropertyType.FAIL_ON_UNKNOWN_PROPERTIES));
        customMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        customMapper.registerModule(new JavaTimeModule());
        customMapper.registerModule(iexTradingModule());

        return customMapper;
    }

    private Module iexTradingModule() {
        final SimpleModule module = new SimpleModule("iexTradingModule");

        module.addDeserializer(BigDecimal.class, new HackyBigDecimalDeserializer());
        module.addDeserializer(LocalDate.class, new HackyLocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new HackyLocalDateTimeDeserializer());

        module.addSerializer(CryptoEventType.class, new CryptoEventTypeSerializer());
        module.addDeserializer(CryptoEventType.class, new CryptoEventTypeDeserializer());

        module.addSerializer(CryptoEventReason.class, new CryptoEventReasonSerializer());
        module.addDeserializer(CryptoEventReason.class, new CryptoEventReasonDeserializer());

        module.addSerializer(CryptoSide.class, new CryptoSideSerializer());
        module.addDeserializer(CryptoSide.class, new CryptoSideDeserializer());

        module.addSerializer(DeepChannel.class, new DeepChannelSerializer());
        module.addDeserializer(DeepChannel.class, new DeepChannelDeserializer());

        module.addSerializer(ChartRange.class, new ChartRangeSerializer());
        module.addDeserializer(ChartRange.class, new ChartRangeDeserializer());

        module.addSerializer(DelistingReason.class, new DelistingReasonSerializer());
        module.addDeserializer(DelistingReason.class, new DelistingReasonDeserializer());

        module.addSerializer(DividendQualification.class, new DividendQualificationSerializer());
        module.addDeserializer(DividendQualification.class, new DividendQualificationDeserializer());

        module.addSerializer(DividendType.class, new DividendTypeSerializer());
        module.addDeserializer(DividendType.class, new DividendTypeDeserializer());

        module.addSerializer(DividendTypeId.class, new DividendTypeIdSerializer());
        module.addDeserializer(DividendTypeId.class, new DividendTypeIdDeserializer());

        module.addSerializer(FinancialStatus.class, new FinancialStatusSerializer());
        module.addDeserializer(FinancialStatus.class, new FinancialStatusDeserializer());

        module.addSerializer(Flag.class, new FlagSerializer());
        module.addDeserializer(Flag.class, new FlagDeserializer());

        module.addSerializer(DirectIndirect.class, new DirectIndirectSerializer());
        module.addDeserializer(DirectIndirect.class, new DirectIndirectDeserializer());

        module.addSerializer(IssueEvent.class, new IssueEventSerializer());
        module.addDeserializer(IssueEvent.class, new IssueEventDeserializer());

        module.addSerializer(IssueSubType.class, new IssueSubTypeSerializer());
        module.addDeserializer(IssueSubType.class, new IssueSubTypeDeserializer());

        module.addSerializer(IssueType.class, new IssueTypeSerializer());
        module.addDeserializer(IssueType.class, new IssueTypeDeserializer());

        module.addSerializer(ListingCenter.class, new ListingCenterSerializer());
        module.addDeserializer(ListingCenter.class, new ListingCenterDeserializer());

        module.addSerializer(LuldTier.class, new LuldTierSerializer());
        module.addDeserializer(LuldTier.class, new LuldTierDeserializer());

        module.addSerializer(PaymentFrequency.class, new PaymentFrequencySerializer());
        module.addDeserializer(PaymentFrequency.class, new PaymentFrequencyDeserializer());

        module.addSerializer(QualifiedDividendType.class, new QualifiedDividendTypeSerializer());
        module.addDeserializer(QualifiedDividendType.class, new QualifiedDividendTypeDeserializer());

        module.addSerializer(SymbolType.class, new SymbolTypeSerializer());
        module.addDeserializer(SymbolType.class, new SymbolTypeDeserializer());

        module.addSerializer(SystemEventType.class, new SystemEventTypeSerializer());
        module.addDeserializer(SystemEventType.class, new SystemEventTypeDeserializer());

        module.addSerializer(TradingStatusType.class, new TradingStatusTypeSerializer());
        module.addDeserializer(TradingStatusType.class, new TradingStatusTypeDeserializer());

        module.addSerializer(TradingStatusReasonType.class, new TradingStatusReasonTypeSerializer());
        module.addDeserializer(TradingStatusReasonType.class, new TradingStatusReasonTypeDeserializer());

        return module;
    }

}
