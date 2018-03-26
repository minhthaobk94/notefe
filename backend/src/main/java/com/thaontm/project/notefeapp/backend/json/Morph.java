
package com.thaontm.project.notefeapp.backend.json;

import java.util.HashMap;
import java.util.List;
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
    "word",
    "dict",
    "base",
    "class",
    "ruby",
    "kana",
    "dicid"
})
public class Morph {

    @JsonProperty("word")
    private String word;
    @JsonProperty("dict")
    private String dict;
    @JsonProperty("base")
    private String base;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("ruby")
    private List<Ruby> ruby = null;
    @JsonProperty("kana")
    private String kana;
    @JsonProperty("dicid")
    private String dicid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("word")
    public String getWord() {
        return word;
    }

    @JsonProperty("word")
    public void setWord(String word) {
        this.word = word;
    }

    public Morph withWord(String word) {
        this.word = word;
        return this;
    }

    @JsonProperty("dict")
    public String getDict() {
        return dict;
    }

    @JsonProperty("dict")
    public void setDict(String dict) {
        this.dict = dict;
    }

    public Morph withDict(String dict) {
        this.dict = dict;
        return this;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    public Morph withBase(String base) {
        this.base = base;
        return this;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    public Morph withClass(String _class) {
        this._class = _class;
        return this;
    }

    @JsonProperty("ruby")
    public List<Ruby> getRuby() {
        return ruby;
    }

    @JsonProperty("ruby")
    public void setRuby(List<Ruby> ruby) {
        this.ruby = ruby;
    }

    public Morph withRuby(List<Ruby> ruby) {
        this.ruby = ruby;
        return this;
    }

    @JsonProperty("kana")
    public String getKana() {
        return kana;
    }

    @JsonProperty("kana")
    public void setKana(String kana) {
        this.kana = kana;
    }

    public Morph withKana(String kana) {
        this.kana = kana;
        return this;
    }

    @JsonProperty("dicid")
    public String getDicid() {
        return dicid;
    }

    @JsonProperty("dicid")
    public void setDicid(String dicid) {
        this.dicid = dicid;
    }

    public Morph withDicid(String dicid) {
        this.dicid = dicid;
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

    public Morph withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("word", word).append("dict", dict).append("base", base).append("_class", _class).append("ruby", ruby).append("kana", kana).append("dicid", dicid).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dicid).append(dict).append(_class).append(ruby).append(additionalProperties).append(base).append(word).append(kana).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Morph) == false) {
            return false;
        }
        Morph rhs = ((Morph) other);
        return new EqualsBuilder().append(dicid, rhs.dicid).append(dict, rhs.dict).append(_class, rhs._class).append(ruby, rhs.ruby).append(additionalProperties, rhs.additionalProperties).append(base, rhs.base).append(word, rhs.word).append(kana, rhs.kana).isEquals();
    }

}
