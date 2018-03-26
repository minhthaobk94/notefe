
package com.thaontm.project.notefeapp.backend.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "r",
    "s"
})
public class Ruby {

    @JsonProperty("r")
    private String r;
    @JsonProperty("s")
    private String s;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("r")
    public String getR() {
        return r;
    }

    @JsonProperty("r")
    public void setR(String r) {
        this.r = r;
    }

    public Ruby withR(String r) {
        this.r = r;
        return this;
    }

    @JsonProperty("s")
    public String getS() {
        return s;
    }

    @JsonProperty("s")
    public void setS(String s) {
        this.s = s;
    }

    public Ruby withS(String s) {
        this.s = s;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Ruby withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("r", r).append("s", s).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(s).append(r).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ruby) == false) {
            return false;
        }
        Ruby rhs = ((Ruby) other);
        return new EqualsBuilder().append(s, rhs.s).append(r, rhs.r).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
