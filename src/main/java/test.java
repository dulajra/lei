import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.lei.logic.Comparators;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by anuradhawick on 8/31/16.
 */
public class test {
    public static void main(String[] args) {
        String s = "lux soap";
//        System.out.println(Comparators.getProduct("lux|lifebuoy").getName());
        MongoOperations ops = com.utils.MongoTemplate.getOperator();
        TypeEntity ety= ops.find(Query.query(Criteria.where("name").regex("sanitary")),TypeEntity.class).get(0);
        ProductEntity pr = ops.find(Query.query(Criteria.where("name").regex("razor")),ProductEntity.class).get(0);
        System.out.println(pr.getTypeEntity().getName());
    }
}
