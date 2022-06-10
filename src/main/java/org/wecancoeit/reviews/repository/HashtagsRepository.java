package org.wecancoeit.reviews.repository;

import org.springframework.stereotype.Repository;
import org.wecancoeit.reviews.model.Hashtags;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@Repository
public class HashtagsRepository {

    // Variables
    Map<Long, Hashtags> hashtagsList = new HashMap<>();

    // Constructor
    public HashtagsRepository(Hashtags...hashtagsToAdd) {
        for(Hashtags hashtagsIndex : hashtagsToAdd) {
            hashtagsList.put(hashtagsIndex.getHashId(), hashtagsIndex);
        }
    }

    // Methods
    public Hashtags findOneHashtag(long hashtagIdToFind) {
        return hashtagsList.get(hashtagIdToFind);
    }

    public Collection<Hashtags> findAllHashtags() {
        return hashtagsList.values();
    }

    public void addHashtags(Hashtags...hashtagsToAdd) {
        for(Hashtags hashtagsIndex : hashtagsToAdd) {
            hashtagsList.put(hashtagsIndex.getHashId(), hashtagsIndex);
        }
    }
}
