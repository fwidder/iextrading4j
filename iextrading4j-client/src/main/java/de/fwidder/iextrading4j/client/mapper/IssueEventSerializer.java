package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.IssueEvent;

import static de.fwidder.iextrading4j.client.mapper.IssueEventDeserializer.ISSUE_EVENT_MAPPER;

class IssueEventSerializer extends AbstractEnumSerializer<IssueEvent> {

    IssueEventSerializer() {
        super(ISSUE_EVENT_MAPPER.inverse(), IssueEvent.UNKNOWN);
    }

}
