package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Review {

    // Variables
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String imgURL;
    @Lob
    private String content;
    private String category;
    @ManyToMany
    private Collection<Hashtags> hashtagsCollection;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public Collection<Hashtags> getHashtagsCollection() {
        return hashtagsCollection;
    }

    // Constructors
    public Review() {
    }

    public Review(Long id, String title, String imgURL, String content, String category) {
        this.id = id;
        this.title = title;
        this.imgURL = imgURL;
        this.content = content;
        this.category = category;
    }

    public Review(Long id, String title, String imgURL, String content, String category, Hashtags...hashtagsCollection) {
        this.id = id;
        this.title = title;
        this.imgURL = imgURL;
        this.content = content;
        this.category = category;
        this.hashtagsCollection = List.of(hashtagsCollection);
    }

    // Methods
    public void addOneHashtag(Hashtags hashtagsToAdd) {
        hashtagsCollection.add(hashtagsToAdd);
    }

    public void addManyHashtags(Hashtags...hastagsToAdd) {
        hashtagsCollection.addAll(List.of(hastagsToAdd));
        Review appendReview = new Review(id, title, imgURL, content, category, hastagsToAdd);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", hashtags=" + hashtagsCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getId().equals(review.getId()) && getTitle().equals(review.getTitle()) && getImgURL().equals(review.getImgURL()) && getContent().equals(review.getContent()) && getCategory().equals(review.getCategory()) && getHashtagsCollection().equals(review.getHashtagsCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getImgURL(), getContent(), getCategory(), getHashtagsCollection());
    }
}
