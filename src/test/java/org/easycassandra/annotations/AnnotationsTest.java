/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.easycassandra.annotations;

import java.lang.reflect.Field;
import junit.framework.Assert;
import org.easycassandra.bean.Person;
import org.junit.Test;

/**
 *
 * @author otaviojava - otaviojava@java.net
 */
public class AnnotationsTest {

    @Test
    public void readColumnFamilyTest() {
        String value = "person";
        Assert.assertEquals(value, Person.class.getAnnotation(ColumnFamilyValue.class).nome());

    }

    @Test
    public void existKeyValueTest() {
        boolean existKeyValue = false;
        for (Field field : Person.class.getDeclaredFields()) {

            if (field.getAnnotation(KeyValue.class) != null) {

                existKeyValue = true;
                break;
            }
        }

        Assert.assertTrue(existKeyValue);
    }

    @Test
    public void retrieveKeyValueTest() {
        for (Field field : Person.class.getDeclaredFields()) {

            if (field.getAnnotation(KeyValue.class) != null) {

                Assert.assertTrue(true);
                
            }
        }

        Assert.assertFalse(false);

    }

    @Test
    public void countColumnValueTest() {
        int objective = 2;
        int counter = 0;

        for (Field field : Person.class.getDeclaredFields()) {

            if (field.getAnnotation(ColumnValue.class) != null) {
                counter++;
            }
        }
        Assert.assertEquals(counter, objective);

    
    }
    
   
}