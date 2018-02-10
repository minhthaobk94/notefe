package com.thaontm.project.notefecore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language extends AbstractEntity {

    @Column(unique = true, name = "[code]")
    private String code;

    @Column(name = "[text]")
    private String text;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "language")
    private Set<Translation> translations;

    public Language() {
        super();
    }

    public Language(final String code, final String text) {
        super();
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Language{");
        sb.append("id=").append(getId());
        sb.append(", code='").append(code).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
