package Beans;

import com.MongoEntities.LocationEntity;
import com.MongoEntities.ProductEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by anuradhawick on 9/4/16.
 */
@XmlRootElement
public class ProductsJaxBean {
    public String productType;
    public LocationEntity location;
    public List<ProductEntity> products;
}
