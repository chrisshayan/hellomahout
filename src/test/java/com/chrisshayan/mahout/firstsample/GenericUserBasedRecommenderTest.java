package com.chrisshayan.mahout.firstsample;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by chris on 1/14/16.
 */
public class GenericUserBasedRecommenderTest {

    @Test
    public void getRecommendation() throws Exception {
        final GenericUserBasedRecommender recommender = new GenericUserBasedRecommender();
        final List<RecommendedItem> recommendation = recommender.getRecommendation(1001);

        assertNotNull(recommendation);
        assertTrue(recommendation.size() == 3);

        recommendation.forEach(new Consumer<RecommendedItem>() {
            @Override
            public void accept(RecommendedItem recommendedItem) {
                System.out.println("recommendedItem = " + recommendedItem);
            }
        });
    }
}
