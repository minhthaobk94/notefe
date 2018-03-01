package com.thaontm.project.notefeapp.backend.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "segment_type")
public class SegmentType extends AbstractEntity {

    @Column(name = "[text]")
    private String text;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "segmentType")
    private Set<Segment> segments;

    public SegmentType() {
        super();
    }

    public SegmentType(final String type) {
        super();
        this.text = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Segment> getSegments() {
        return segments;
    }

    public void setSegments(Set<Segment> segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SegmentType{");
        sb.append("id=").append(getId());
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
