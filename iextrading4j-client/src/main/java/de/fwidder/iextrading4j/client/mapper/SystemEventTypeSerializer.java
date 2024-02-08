package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.marketdata.SystemEventType;

import static de.fwidder.iextrading4j.client.mapper.SystemEventTypeDeserializer.SYSTEM_EVENT_TYPE_MAPPER;

class SystemEventTypeSerializer extends AbstractEnumSerializer<SystemEventType> {

    SystemEventTypeSerializer() {
        super(SYSTEM_EVENT_TYPE_MAPPER.inverse(), SystemEventType.UNKNOWN);
    }
}
