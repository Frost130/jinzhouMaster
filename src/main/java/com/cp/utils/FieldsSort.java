/**
 * 
 */
package com.cp.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

/**字段排序工具
 */
public class FieldsSort {
    public static Field[] sortFields(Field[] fieldArray)
    {
        Arrays.sort(fieldArray, new Comparator<Field>(){
            public int compare(Field f1, Field f2) {
                return f1.getName().compareTo(f2.getName());
            }

            });    
       return fieldArray;
    }

}
