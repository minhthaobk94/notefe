package com.thaontm.project.notefeapp.backend.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "[segment]")
public class Segment extends AbstractEntity implements Serializable {

    @Column(name = "[index]", nullable = false)
    private long index;

    @Column(name = "[text]", nullable = false)
    private String text;

    @Column(name = "[vi_translation]")
    private String viTranslation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "segment_type_id", referencedColumnName = "id")
    private SegmentType segmentType;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "segment")
    private Set<Translation> translations;

    public Segment() {
        super();
    }

    public Segment(long index, String text, Post post, SegmentType segmentType) {
        this.index = index;
        this.text = text;
        this.post = post;
        this.segmentType = segmentType;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SegmentType getSegmentType() {
        return segmentType;
    }

    public void setSegmentType(SegmentType segmentType) {
        this.segmentType = segmentType;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getViTranslation() {
        return viTranslation;
    }

    public void setViTranslation(final String viTranslation) {
        this.viTranslation = viTranslation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Segment{");
        sb.append("id=").append(getId());
        sb.append(", index=").append(getIndex());
        sb.append(", text='").append(getText()).append('\'');
        sb.append(", viTranslation='").append(getViTranslation()).append('\'');
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }
}
