package com.thaontm.project.notefecore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "translation")
public class Translation extends AbstractEntity {

    @Column(name = "[text]")
    private String text;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "segment_id", referencedColumnName = "id")
    private Segment segment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Translation{");
        sb.append("id=").append(getId());
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
