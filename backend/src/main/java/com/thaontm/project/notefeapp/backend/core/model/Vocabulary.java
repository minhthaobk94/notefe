package com.thaontm.project.notefeapp.backend.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "[vocabulary]")
public class Vocabulary extends AbstractEntity implements Serializable {

    @Column(name = "[text]")
    private String text;

    @Column(name = "[hiragana]")
    private String hiragana;

    @Column(name = "[katakana]")
    private String katakana;

    @Column(name = "[vi_translation]")
    private String viTranslation;

    @Column(name = "[classifier]")
    private String classifier;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    public Vocabulary() {
        super();
    }

    public Vocabulary(String text, String hiragana, String katakana, String viTranslation, String classifier, Post post) {
        super();
        this.text = text;
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.viTranslation = viTranslation;
        this.classifier = classifier;
        this.post = post;
    }

    public String getText() {
        return text == null ? null : text.trim();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getKatakana() {
        return katakana;
    }

    public void setKatakana(String katakana) {
        this.katakana = katakana;
    }

    public String getViTranslation() {
        return viTranslation;
    }

    public void setViTranslation(String viTranslation) {
        this.viTranslation = viTranslation;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(final String classifier) {
        this.classifier = classifier;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("text", text)
            .append("hiragana", hiragana)
            .append("katakana", katakana)
            .append("viTranslation", viTranslation)
            .append("classifier", classifier)
            .append("post", post)
            .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof Vocabulary)) return false;

        final Vocabulary that = (Vocabulary) o;

        // only text is enough
        return new EqualsBuilder()
            .append(getText(), that.getText())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(getText())
            .append(getHiragana())
            .append(getKatakana())
            .append(getViTranslation())
            .append(getClassifier())
            .append(getPost())
            .toHashCode();
    }
}
