import com.MongoEntities.LocationEntity;
import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by anuradhawick on 8/29/16.
 */
public class DataSeeder {
    static String[] typeEntities = {"soap", "vegetable", "toothpaste", "juice", "fruit"};
    static MongoOperations ops = MongoTemplate.getOperator();

    public static void main(String[] args) {
        ops.dropCollection(LocationEntity.class);
        // adding dummy locations
        for (int i = 1; i < 11; i++) {
            LocationEntity locationEntity = new LocationEntity();
            locationEntity.setName("" + (int) (Math.random() * 90));
            ops.save(locationEntity);
        }

        ops.dropCollection(TypeEntity.class);
        // saving types and locations
        for (String string :
                typeEntities) {
            TypeEntity typeEntity = new TypeEntity();
            typeEntity.setName(string);
            typeEntity.getLocations().add(ops.findAll(LocationEntity.class).get((int) Math.random() * 10));
            ops.save(typeEntity);
        }

        ops.dropCollection(ProductEntity.class);
        // Adding soaps
        TypeEntity soapEntity = ops.find(Query.query(where("name").regex("soap")), TypeEntity.class).get(0);
        String[] soaps = {"lux", "sunlight", "lifebuoy", "dettol", "peach"};
        for (String string :
                soaps) {
            saveProduct(string, soapEntity);
        }

        // Adding vegetables
        TypeEntity vegetableEntity = ops.find(Query.query(where("name").regex("vegetable")), TypeEntity.class).get(0);
        String[] vegetables = {"cucumber", "spinach", "garlic", "pumpkin", "manioc"};
        for (String string :
                vegetables) {
            saveProduct(string, vegetableEntity);
        }

        // Adding toothpaste
        TypeEntity toothpasteEntity = ops.find(Query.query(where("name").regex("toothpaste")), TypeEntity.class).get(0);
        String[] toothpaste = {"cloguard", "signal", "sensodyne"};
        for (String string :
                toothpaste) {
            saveProduct(string, toothpasteEntity);
        }

        // Adding drinks
        TypeEntity juiceEntity = ops.find(Query.query(where("name").regex("juice")), TypeEntity.class).get(0);
        String[] juices = {"mango", "pineapple", "apple"};
        for (String string :
                juices) {
            saveProduct(string, juiceEntity);
        }

        // Adding fruits
        TypeEntity fruitEntity = ops.find(Query.query(where("name").regex("fruit")), TypeEntity.class).get(0);
        String[] fruits = {"avocado", "guava", "grape"};
        for (String string :
                juices) {
            saveProduct(string, fruitEntity);
        }
    }

    private static void saveProduct(String string, TypeEntity type) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription("description about " + string);
        productEntity.setName(string);
        productEntity.setPrice((float) Math.random() * 200);
        productEntity.setTypeEntity(type);
        ops.save(productEntity);
    }
}
