package com.lei.ai;

import com.LanguageUtils.Classifier;
import com.MongoEntities.LocationEntity;
import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.lei.logic.Comparators;
import com.lei.logic.Finder;
import com.lei.logic.Locator;
import com.utils.MessageTemplate;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.List;

/**
 * Created by anuradhawick on 8/30/16.
 */
public class Responder {
    private static Responder responder = null;

    private Responder() {

    }

    public static Responder getResponder() {
        if (responder == null) {
            synchronized (Responder.class) {
                if (responder == null) {
                    responder = new Responder();
                }
            }
        }
        return responder;
    }

    public MessageTemplate getResponse(Classifier classifier) {
        HashMap<String, List<String>> classfiedHashMap = classifier.getHashMap();
        // location and price logic
        if (wrbAnalyzer(classfiedHashMap) && classfiedHashMap.get("WRB").contains("where")) {
            // location logic :: where -> product || how -> much -> product
            if (Finder.findProduct(classfiedHashMap.get("NN")) != null) {
                // locate the product
                LocationEntity location = Locator.getLocationByItem(Finder.findProduct(classfiedHashMap.get("NN")).getName());
                MessageTemplate msg = new MessageTemplate();
                msg.message = "You can find " +
                        Finder.findProduct(classfiedHashMap.get("NN")).getName() +
                        " at " + location.getName();
                msg.array.add(location);
                msg.type = "location";
                return msg;

            } else if (Finder.findType(classfiedHashMap.get("NN")) != null) {
                // locate the type
                LocationEntity location = Locator.getLocationByType(Finder.findType(classfiedHashMap.get("NN")).getName());
                MessageTemplate msg = new MessageTemplate();
                msg.message = "You can find " + Finder.findType(classfiedHashMap.get("NN")).getName() +
                        " at " + location.getName();
                msg.array.add(location);
                msg.type = "location";
                return msg;
            } else {
                // error
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Ops! We could not find what you were looking for!";
                msg.error = true;
                return msg;
            }

        } else if (wrbAnalyzer(classfiedHashMap) && classfiedHashMap.get("WRB").contains("how")) {
            // price logic :: how much -> noun
            if (Finder.findProduct(classfiedHashMap.get("NN")) != null) {
                // details of the product
                ProductEntity product = Finder.findProduct(classfiedHashMap.get("NN"));
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Product details: ";
                msg.type = "product";
                msg.array.add(product);
                return msg;
            } else {
                // error
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Ops! We could not find what you were looking for!";
                msg.error = true;
                return msg;
            }
        } else if (jjsAnalyzer(classfiedHashMap)) {
            if (classfiedHashMap.get("JJS").contains("cheapest") && Finder.findType(classfiedHashMap.get("NN")) != null) {
                // cheapest by type
                ProductEntity product = Comparators.getCheapest(Finder.findType(classfiedHashMap.get("NN")));
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Cheapest type of " + product.getTypeEntity().getName() + " is ";
                msg.type = "product";
                msg.array.add(product);
                return msg;
            } else {
                // error
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Ops! We could not find what you were looking for!";
                msg.error = true;
                return msg;
            }
        } else if (jjjjrAnalyzer(classfiedHashMap)) {
            // cheap cheaper expensive etc
            if (Finder.findType(classfiedHashMap.get("NN")) != null) {
                List<ProductEntity> productEntities = Comparators.getProducts(Finder.findType(classfiedHashMap.get("NN")).getName());
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Details of " + Finder.findType(classfiedHashMap.get("NN")).getName() + " products are as follows";
                msg.type = "products";
                for (ProductEntity productEntity : productEntities) {
                    msg.array.add(productEntity);
                }
                return msg;
            } else {
                // error
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Ops! We could not find what you were looking for!";
                msg.error = true;
                return msg;
            }
        } else if (nounAnalyzer(classfiedHashMap)) {
            MongoOperations ops = MongoTemplate.getOperator();
            if (Finder.findType(classfiedHashMap.get("NN")) != null) {
                TypeEntity typeEntity = Finder.findType(classfiedHashMap.get("NN"));
                List<ProductEntity> productEntities = ops.find(Query.query(Criteria.where("typeEntity").is(typeEntity)),ProductEntity.class);
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Details of " + Finder.findType(classfiedHashMap.get("NN")).getName() + " products are as follows";
                msg.type = "products";
                for (ProductEntity productEntity : productEntities) {
                    msg.array.add(productEntity);
                }
                return msg;
            } else if (Finder.findProduct(classfiedHashMap.get("NN")) != null) {
                ProductEntity product = Comparators.getProduct(Finder.findProduct(classfiedHashMap.get("NN")).getName());
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Details of " + product + " :";
                msg.type = "product";
                msg.array.add(product);
                return msg;
            } else {
                // error
                MessageTemplate msg = new MessageTemplate();
                msg.message = "Ops! We could not find what you were looking for!";
                msg.error = true;
                return msg;
            }
        } else {
            // error
            MessageTemplate msg = new MessageTemplate();
            msg.message = "Ops! We could not find what you were looking for!";
            msg.error = true;
            return msg;
        }
    }

    /*
    * Check for nouns
    * NN, NNS
    *
    * */
    private boolean nounAnalyzer(HashMap<String, List<String>> hashMap) {
        return hashMap.containsKey("NN") || hashMap.containsKey("NNS");
    }

    /*
    * Check for WHERE, HOW
    * WRB
    *
    * */
    private boolean wrbAnalyzer(HashMap<String, List<String>> hashMap) {
        return hashMap.containsKey("WRB");
    }

    /*
    * Check for WHAT
    * WP
    *
    * */
    private boolean wpAnalyzer(HashMap<String, List<String>> hashMap) {
        return hashMap.containsKey("WP");
    }

    /*
    * Check CHEAP, CHEAPER, EXPENSIVE, MUCH
    * JJ, JJR
    *
    * */
    private boolean jjjjrAnalyzer(HashMap<String, List<String>> hashMap) {
        return hashMap.containsKey("JJ") || hashMap.containsKey("JJR");
    }

    /*
    * Check CHEAPEST, LATEST
    * JJS
    *
    * */
    private boolean jjsAnalyzer(HashMap<String, List<String>> hashMap) {
        return hashMap.containsKey("JJS");
    }

    /*
    * Get the message object
    *
    * */
    private Object getMessageSingeObject(Object object) {
        if (object instanceof TypeEntity) {

        } else {

        }
        return null;
    }

    /*
    * Get the message object
    *
    * */
    private Object getMessageArray(Object object) {
        if (object instanceof TypeEntity) {

        } else {

        }
        return null;
    }
}
