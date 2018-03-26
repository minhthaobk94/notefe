package com.thaontm.project.notefeapp.backend.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "newsid",
    "text",
    "morph"
})
public class VocabularyList {

    @JsonProperty("newsid")
    private String newsid;
    @JsonProperty("text")
    private String text;
    @JsonProperty("morph")
    private List<Morph> morph = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("newsid")
    public String getNewsid() {
        return newsid;
    }

    @JsonProperty("newsid")
    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public VocabularyList withNewsid(String newsid) {
        this.newsid = newsid;
        return this;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public VocabularyList withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("morph")
    public List<Morph> getMorph() {
        return morph;
    }

    @JsonProperty("morph")
    public void setMorph(List<Morph> morph) {
        this.morph = morph;
    }

    public VocabularyList withMorph(List<Morph> morph) {
        this.morph = morph;
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

    public VocabularyList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("newsid", newsid).append("text", text).append("morph", morph).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(additionalProperties).append(newsid).append(morph).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VocabularyList) == false) {
            return false;
        }
        VocabularyList rhs = ((VocabularyList) other);
        return new EqualsBuilder().append(text, rhs.text).append(additionalProperties, rhs.additionalProperties).append(newsid, rhs.newsid).append(morph, rhs.morph).isEquals();
    }

}
