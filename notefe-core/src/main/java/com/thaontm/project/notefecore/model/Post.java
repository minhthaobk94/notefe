package com.thaontm.project.notefecore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post extends AbstractEntity {

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private Set<Segment> segments;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "submitted", nullable = false)
    private Date submitted;

    @Column(name = "img_url")
    private String imageURL;

    @Column(name = "audio_url")
    private String audioURL;

    public Post() {
        super();
    }

    public Post(final String link, final Date submitted, final String imageURL, final String audioURL) {
        super();
        this.link = link;
        this.submitted = submitted;
        this.imageURL = imageURL;
        this.audioURL = audioURL;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public Set<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id=").append(getId());
        sb.append(", link='").append(link).append('\'');
        sb.append(", submitted=").append(submitted);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append(", audioURL='").append(audioURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
