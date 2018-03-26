package com.thaontm.project.notefeapp.backend.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    public Vocabulary() {
        super();
    }

    public Vocabulary(String text, String hiragana, String katakana, String viTranslation, Post post) {
        super();
        this.text = text;
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.viTranslation = viTranslation;
        this.post = post;
    }

    public String getText() {
        return text;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vocabulary{");
        sb.append("text='").append(text).append('\'');
        sb.append(", hiragana='").append(hiragana).append('\'');
        sb.append(", katakana='").append(katakana).append('\'');
        sb.append(", viTranslation='").append(viTranslation).append('\'');
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }
}
