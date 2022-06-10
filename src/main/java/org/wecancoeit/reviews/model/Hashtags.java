package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Hashtags {

    // Variables
    @Id
    @GeneratedValue
    private Long hashId;
    private String hashName;
    @ManyToMany(mappedBy = "hashtagsCollection")
    private Collection<Review> reviewCollection;

    // Getters
    public Long getHashId() {
        return hashId;
    }

    public String getHashName() {
        return hashName;
    }

    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    // Constructors
    public Hashtags() {
    }

    public Hashtags(Long hashId, String hashName) {
        this.hashId = hashId;
        this.hashName = hashName;
    }

    public Hashtags(Long hashId, String hashName, Review...reviewCollection) {
        this.hashId = hashId;
        this.hashName = hashName;
        this.reviewCollection = List.of(reviewCollection);
    }

    // Methods
    @Override
    public String toString() {
        return "Hashtags{" +
                "hashId=" + hashId +
                ", hashName='" + hashName + '\'' +
                ", reviews=" + reviewCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtags)) return false;
        Hashtags hashtags = (Hashtags) o;
        return getHashId().equals(hashtags.getHashId()) && getHashName().equals(hashtags.getHashName()) && getReviewCollection().equals(hashtags.getReviewCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHashId(), getHashName(), getReviewCollection());
    }
}
