package de.fwidder.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class UsExchange implements Serializable {

    private static final long serialVersionUID = 1599060793574929356L;

    private final String name;
    private final String longName;
    private final String mic;
    private final String tapeId;
    private final String oatsId;
    private final String refId;
    private final String type;

    @JsonCreator
    public UsExchange(
            @JsonProperty("name") final String name,
            @JsonProperty("longName") final String longName,
            @JsonProperty("mic") final String mic,
            @JsonProperty("tapeId") final String tapeId,
            @JsonProperty("oatsId") final String oatsId,
            @JsonProperty("refId") final String refId,
            @JsonProperty("type") final String type) {
        this.name = name;
        this.longName = longName;
        this.mic = mic;
        this.tapeId = tapeId;
        this.oatsId = oatsId;
        this.refId = refId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLongName() {
        return longName;
    }

    public String getMic() {
        return mic;
    }

    public String getTapeId() {
        return tapeId;
    }

    public String getOatsId() {
        return oatsId;
    }

    public String getRefId() {
        return refId;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UsExchange that = (UsExchange) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(longName, that.longName) &&
                Objects.equal(mic, that.mic) &&
                Objects.equal(tapeId, that.tapeId) &&
                Objects.equal(oatsId, that.oatsId) &&
                Objects.equal(refId, that.refId) &&
                Objects.equal(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, longName, mic, tapeId, oatsId, refId, type);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("longName", longName)
                .add("mic", mic)
                .add("tapeId", tapeId)
                .add("oatsId", oatsId)
                .add("refId", refId)
                .add("type", type)
                .toString();
    }

}
