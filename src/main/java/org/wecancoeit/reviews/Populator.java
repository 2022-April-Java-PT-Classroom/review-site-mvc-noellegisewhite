package org.wecancoeit.reviews;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.wecancoeit.reviews.model.Hashtags;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repository.HashtagsRepository;
import org.wecancoeit.reviews.repository.ReviewRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private ReviewRepository reviewStorage;

    @Resource
    private HashtagsRepository hashtagsStorage;

    @Override
    public void run(String...args) throws Exception {

        Hashtags single = new Hashtags(1L, "single");
        Hashtags married = new Hashtags(2L, "married");
        Hashtags adult = new Hashtags(3L, "adult");
        Hashtags youngadult = new Hashtags(4L, "young adult");
        Hashtags child = new Hashtags(5L, "child");
        Hashtags artist = new Hashtags(6L, "artist");
        Hashtags worker = new Hashtags(7L, "worker");
        Hashtags unemployed = new Hashtags(8L, "unemployed");
        hashtagsStorage.addHashtags(single, married, adult, youngadult, child, artist, worker, unemployed);

        // Bachelors
        // (Long id, String title, String imgURL, String content, String category, Hashtags...hashtags)
        Review alex = new Review(1L, "Alex",
                "../images/Alex.png",
                "Alex loves sports and hanging out at the beach. He is quite arrogant and brags to everyone that he is going to be a professional athlete. Is his cockiness just a facade to mask his crushing self-doubt? Is he using his sports dream to fill the void left by the disappearance of his parents? Or is he just a brazen youth trying to 'look cool?",
                "bachelor", single, youngadult, unemployed);
        Review elliott = new Review(2L, "Elliot",
                "../images/Elliott.png",
                "Elliott lives alone in a cabin on the beach. He is a writer who dreams of one day writing a magnificent novel. He is a sentimental “romantic” with a tendency to go off onto flowery, poetic tangents. When he can afford it, he enjoys a strong beverage at the Stardrop Saloon. Could a humble farmer such as yourself be the inspiration Elliott is looking for? There’s only one way to find out…",
                "bachelor", single, adult, artist);
        Review harvey = new Review(3L, "Harvey",
                "../images/Harvey.png",
                "Harvey is the town doctor. He’s a little old for a bachelor, but he has a kind heart and a respected position in the community. He lives in a small apartment above the medical clinic, but spends most of his time working. You can sense a sadness about him, as if there’s something he’s not telling you…",
                "bachelor", single, adult, worker);
        Review sam = new Review(4L, "Sam",
                "../images/Sam.png",
                "Sam is an outgoing, friendly guy who is brimming with youthful energy. He plays guitar and drums, and wants to start a band with Sebastian as soon as he has enough songs together. However, he does have a habit of starting ambitious projects and not finishing them. Sam is a little stressed about the impending return of his father, who has been away for years due to his line of work.",
                "bachelor", single, youngadult, worker);
        Review sebastian = new Review(5L, "Sebastian",
                "../images/Sebastian.png",
                "Sebastian is a rebellious loner who lives in his parents’ basement. He is Maru’s older half-brother, and feels like his sister gets all the attention and adoration, while he is left to rot in the dark. He tends to get deeply absorbed in his work, computer games, comic books, sci-fi novels, and will sometimes spend great lengths of time pursuing these hobbies alone in his room. He can be a bit unfriendly to people he doesn’t know. Could a charming new farmer cultivate the wasteland of his heart? Who knows?",
                "bachelor", single, youngadult, worker);
        Review shane = new Review(6L, "Shane",
                "../images/Shane.png",
                "Shane is a villager in Pelican Town who is often rude and unhappy, and suffers from depression and alcohol dependence. However, his attitude starts to change towards any player who chooses to befriend him. He works at JojaMart most days between 9am and 5pm, and after work he frequently spends his evenings in The Stardrop Saloon. He doesn't work on the weekend except on rainy days, and is frequently around the ranch.",
                "bachelor", single, adult, worker);
        reviewStorage.bulkAddReview(alex, elliott, harvey, sam, sebastian, shane);

        // Bachelorettes
        // (Long id, String title, String imgURL, String content, String category, Hashtags...hashtags)
    }
}
