package chapter03.simple.beans;

import org.apache.log4j.Logger;

import java.util.*;

public class DataTypesExample {
    private static Logger logger = Logger.getLogger(DataTypesExample.class);
    private Date dateType;

    public DataTypesExample(
            byte[] byteArrayType,
            char charType,
            char[] charArray,
            Class classType,
            Currency currencyType,
            boolean booleanType,
            Date dateType,
            long longType,
            double doubleType,
            Properties propertiesType,
            List<Integer> listType,
            Map mapType,
            Set setType,
            Properties anotherPropertiesType
    ) {
        logger.info("byteArrayType " + new String(byteArrayType));
        logger.info("charType " + charType);
        logger.info("charArray " + new String(charArray));
        logger.info("classType " + classType.getName());
        logger.info("currencyType " + currencyType.getSymbol());
        logger.info("booleanType " + booleanType);
        logger.info("dateType " + dateType);
        logger.info("longType " + longType);
        logger.info("doubleType " + doubleType);
        logger.info("propertiesType " + propertiesType);
        logger.info("listType " + listType);
        logger.info("mapType " + mapType);
        logger.info("setType " + setType);
        logger.info("anotherPropertiesType " + anotherPropertiesType);
    }

    public Date getDateType() {
        return dateType;
    }

    public void setDateType(Date dateType) {
        this.dateType = dateType;
        logger.info("dateType " + dateType);
    }
}
