package com.chrisshayan.mahout.firstsample;

import com.sun.istack.NotNull;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by chris on 1/14/16.
 */
public class GenericUserBasedRecommender {

    /**
     * @param userId the user to generate recommendation
     * @return recommendation for userId based on sample data in data/sampleDataUserItemScore.csv
     */
    public List<RecommendedItem> getRecommendation(@NotNull long userId) throws TasteException, IOException {
        final File sampleDataUserItemScore = new File(
                System.getProperty("user.dir") + File.separator + "src/main/resources/data/sampleDataUserItemScore.csv");
        final DataModel dataModel = new FileDataModel(sampleDataUserItemScore);

        final UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
        final UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(2, userSimilarity, dataModel);

        Recommender recommender = new org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

        // Generate a list of 3 recommended items for userId
        return recommender.recommend(userId, 3);
    }
}
