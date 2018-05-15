package com.yllt.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassUtil {
	/**
	 * 根据属性名获取属性值
	 * */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {  
            String firstLetter = fieldName.substring(0, 1).toUpperCase();  
            String getter = "get" + firstLetter + fieldName.substring(1);  
            Method method = o.getClass().getMethod(getter, new Class[] {});  
            Object value = method.invoke(o, new Object[] {});  
            return value;  
        } catch (Exception e) {  
            return null;  
        }  
    } 
    
    /**
     * 获取属性名数组
     * */
    public static String[] getFiledName(Object o){
    	Field[] fields=o.getClass().getDeclaredFields();
       	String[] fieldNames=new String[fields.length];
    	for(int i=0;i<fields.length;i++){
    		System.out.println(fields[i].getType());
    		fieldNames[i]=fields[i].getName();
    	}
    	return fieldNames;
    }
    
    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    public static List<Map<String,Object>> getFiledsInfo(Object o){
    	Field[] fields=o.getClass().getDeclaredFields();
       	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
       	Map<String,Object> infoMap=null;
    	for(int i=0;i<fields.length;i++){
    		if(fields[i].getName().equals("serialVersionUID")){
    			continue;
    		}
    		infoMap = new HashMap<String,Object>();
    		String typeFullName = fields[i].getType().toString();
    		String[]types = typeFullName.split("\\.");
    		infoMap.put("typeFullName", typeFullName);
    		infoMap.put("type", types[types.length-1]);
    		infoMap.put("name", fields[i].getName());
    		infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
    		list.add(infoMap);
    	}
    	return list;
    }
    
    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    public static Object[] getFiledValues(Object o){
    	String[] fieldNames=ClassUtil.getFiledName(o);
    	Object[] value=new Object[fieldNames.length];
    	for(int i=0;i<fieldNames.length;i++){
    		value[i]=ClassUtil.getFieldValueByName(fieldNames[i], o);
    	}
    	return value;
    }	

}
