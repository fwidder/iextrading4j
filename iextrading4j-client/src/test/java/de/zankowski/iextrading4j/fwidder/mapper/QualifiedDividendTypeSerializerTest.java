package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.refdata.QualifiedDividendType;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QualifiedDividendTypeSerializerTest {

    private QualifiedDividendTypeSerializer serializer;

    @BeforeEach
    public void setUp() {
        serializer = new QualifiedDividendTypeSerializer();
    }

    @AfterEach
    public void tearDown() {
        serializer = null;
    }

    @Test
    void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final QualifiedDividendType input = null;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final QualifiedDividendType input = QualifiedDividendType.UNKNOWN;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    void shouldWriteStringFromNotAvailable() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final QualifiedDividendType input = QualifiedDividendType.NOT_AVAILABLE;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("");
    }

    @Test
    void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final QualifiedDividendType input = QualifiedDividendType.QUALIFIED;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("Y");
    }
}
