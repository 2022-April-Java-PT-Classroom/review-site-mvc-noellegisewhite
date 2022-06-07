package org.wecancoeit.reviews;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

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
}
