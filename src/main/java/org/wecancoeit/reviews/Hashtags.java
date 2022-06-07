package org.wecancoeit.reviews;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

public class Hashtags {

    // Variables
    @Id
    @GeneratedValue
    private Long hashId;
    private String hashName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> reviews;

    // Getters
    public Long getHashId() {
        return hashId;
    }

    public String getHashName() {
        return hashName;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    // Constructors
    public Hashtags() {
    }

    public Hashtags(Long hashId, String hashName) {
        this.hashId = hashId;
        this.hashName = hashName;
    }

    // Methods
    @Override
    public String toString() {
        return "Hashtags{" +
                "hashId=" + hashId +
                ", hashName='" + hashName + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtags)) return false;
        Hashtags hashtags = (Hashtags) o;
        return getHashId().equals(hashtags.getHashId()) && getHashName().equals(hashtags.getHashName()) && getReviews().equals(hashtags.getReviews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHashId(), getHashName(), getReviews());
    }
}
