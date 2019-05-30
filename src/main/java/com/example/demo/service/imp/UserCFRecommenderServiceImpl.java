package com.example.demo.service.imp;

import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import com.example.demo.service.UserCFRecommenderService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserCFRecommenderServiceImpl implements UserCFRecommenderService {

    @Value("${com.kadoufall.mahout.table-name}")
    private String tableName;

    @Value("${com.kadoufall.mahout.user-column}")
    private String userColumn;

    @Value("${com.kadoufall.mahout.item-column}")
    private String itemColumn;

    @Value("${com.kadoufall.mahout.pref-column}")
    private String prefColumn;

    @Value("${com.kadoufall.mahout.recommendNum}")
    private int recommendNum;

    @Autowired
    DataSource dataSource;

    @Resource
    InfoMapper infoMapper;

    private DataModel dataModel = null;
    private Recommender recommender = null;



   // @PostConstruct
    public void init() {
        try {
           dataModel = new MySQLBooleanPrefJDBCDataModel(dataSource, tableName, userColumn, itemColumn, prefColumn);
            UserSimilarity similarity = new LogLikelihoodSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, dataModel);
            recommender = new GenericBooleanPrefUserBasedRecommender(dataModel, neighborhood, similarity);
        } catch (Exception e) {
          System.out.print(e.toString());
        }
    }

    @Override
    public List<Long> recommend(Integer userId) {
        init();
        List<Long> ret = new ArrayList<>();
        try {
            List<RecommendedItem> recommendedItems = recommender.recommend(userId.longValue(), this.recommendNum);
            Set<Long> newIds = new HashSet<>();
            for (RecommendedItem item : recommendedItems) {
                newIds.add(item.getItemID());
            }
            ret.addAll(newIds);
        } catch (TasteException e) {
            System.out.print(e.toString());
        }
        return ret;
    }

    @Override
    public List<Info> recommendNews(Integer userId) {
        return this.recommend(userId)
                .parallelStream()
                .map(newId -> infoMapper.getInfoById(newId.intValue()))
                .collect(Collectors.toList());
    }
}
