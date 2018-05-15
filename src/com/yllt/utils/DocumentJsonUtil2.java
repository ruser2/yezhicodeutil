package com.yllt.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/12/4.
 */
public class DocumentJsonUtil2 {

    public static String getSetFieldName(String filedName)
    {

        if(isFirstNeedUpper(filedName)){
            return "set"+StringUtil.firstToUpper(filedName);
        }
        return "set"+filedName;
    }

    public static boolean isFirstNeedUpper(String filedName)
    {
//            StringUtil.firstToUpper()
        //filedname 第一个数字 为小写 第二个大写则不需要首字母大学
        if(filedName.length()>1){
            //如果第二个字符是小写或者数字、符号  firstChar要大写
            return !Character.isUpperCase(filedName.charAt(1));
        }
        return true;
    }

    //List 里面的内容
    public static Object parseList(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (clazz.equals(Integer.class)) {
            return new String("【Integer】");
        } else if (clazz.equals(String.class)) {
            return new String("【String】");
        } else if (clazz.equals(Date.class)) {
            return new String("【Date】");
        } else if (clazz.equals(Timestamp.class)) {
            return new String("【Timestamp】");
        } else if (clazz.equals(Double.class)) {
            return new String("【Double】");
        } else if (clazz.equals(Float.class)) {
            return new String("【Float】");
        } else if (clazz.equals(Long.class)) {
            return new String("【Long】");
        } else if (clazz.equals(Character.class)) {
            return new String("【Character】");
        } else if (clazz.equals(Boolean.class)) {
            return new String("【Boolean】");
        }


        return null;
    }    //List 里面的内容
    public static Object parse(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (clazz.equals(Integer.class)) {
            return new Integer(1);
        } else if (clazz.equals(String.class)) {
            return new String("【String】");
        } else if (clazz.equals(Date.class)) {
            return new Date();
        } else if (clazz.equals(Timestamp.class)) {
            return new Timestamp(System.currentTimeMillis());
        } else if (clazz.equals(Double.class)) {
            return new Double(1.1);
        } else if (clazz.equals(Float.class)) {
            return new Float(1.1f);
        } else if (clazz.equals(Long.class)) {
            return new Long(1L);
        } else if (clazz.equals(Character.class)) {
            return new Character('c');
        } else if (clazz.equals(Boolean.class)) {
            return new Boolean(false);
        }

        return null;
    }
    //
    public static void fill(Object obj) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

//        Class cla=obj.getClass();
//        Field[] fs = clazz.getDeclaredFields();
        for(Class<?> cla = obj.getClass() ; cla != Object.class ; cla = cla.getSuperclass()) {
            Field[] fs = cla.getDeclaredFields();
            for (Field f : fs) {
                Class fieldClazz = f.getType(); // 得到field的class及类型全路径
                //获取真实的filed 的set方法名称;
                String fieldSetName = getSetFieldName(f.getName());
//            Character.isUpperCase(f.getName().substring())
                if (fieldClazz.isPrimitive()) continue;  //【1】 //判断是否为基本类型
                Object value=parse(fieldClazz);
                if(null!=value) {
                    Method method = cla.getDeclaredMethod(fieldSetName, fieldClazz);
                    method.invoke(obj, value);
                    continue;
                }
                //TODO  数组没处理
                if (fieldClazz.isAssignableFrom(List.class)) //【2】
                {
                    Type fc = f.getGenericType(); // 关键的地方，如果是List类型，得到其Generic的类型

                    if (fc == null) continue;
                    //泛型
                    if (fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型
                    {
                        ParameterizedType pt = (ParameterizedType) fc;
                        Class genericClazz = (Class) pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。
                        Object o = parseList(genericClazz);
                        if (o == null) {
                            Object inner = genericClazz.newInstance();
                            fill(inner);
                            o = inner;
                        }
                        List list = new ArrayList();
                        list.add(o);

                        Method method = cla.getDeclaredMethod(fieldSetName, fieldClazz);
                        method.invoke(obj, list);
                    }
                    continue;
                }
                if (fieldClazz.isArray()) {
                    //TODO 数组只处理一维的对象数组  不能处理多维或基本类型数组
                    Class elementType = f.getType().getComponentType();
                    Object arrayObj = Array.newInstance(elementType, 1);
                    Object parseObj = parse(elementType);
                    if (null == parseObj) {
                        parseObj = elementType.newInstance();
                        fill(parseObj);
                    }
                    Array.set(arrayObj, 0, parseObj);
                    Method method = cla.getDeclaredMethod(fieldSetName, fieldClazz);
                    method.invoke(obj, arrayObj);
                    continue;
                }
                //对象类型
                Object o = fieldClazz.newInstance();
                fill(o);
                Method method = cla.getDeclaredMethod(fieldSetName, fieldClazz);
                method.invoke(obj, o);
                continue;
            }
        }
}

    public static void getStr(Class clazz){
        try {
//            AddClerkParam addClerkParam=new AddClerkParam();
            Object o=clazz.newInstance();
            fill(o);
//            ListClerkResult listClerkResult=new ListClerkResult();
//            AddClerkParam addClerkParam=new AddClerkParam();
//            fill(listClerkResult);

            System.out.println(JsonUtil.getShowJson(o));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
