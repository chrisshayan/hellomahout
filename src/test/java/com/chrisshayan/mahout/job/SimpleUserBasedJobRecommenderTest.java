package com.chrisshayan.mahout.job;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by chris on 1/14/16.
 */
public class SimpleUserBasedJobRecommenderTest {
    @Test
    public void getRecommendation() throws Exception {
        final SimpleUserBasedJobRecommender recommender = new SimpleUserBasedJobRecommender();
        final List<RecommendedItem> recommendation = recommender.getRecommendation(83);

        assertNotNull(recommendation);

        System.out.println("recommendation.size() = " + recommendation.size());
        recommendation.forEach(new Consumer<RecommendedItem>() {
            @Override
            public void accept(RecommendedItem recommendedItem) {
                System.out.println("recommendedItem = " + recommendedItem);
            }
        });
    }

}
