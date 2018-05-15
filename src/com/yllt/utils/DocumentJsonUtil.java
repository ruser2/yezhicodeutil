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
public class DocumentJsonUtil {

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
    public static Object parse(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if(clazz.equals(Integer.class)){
            return new Integer(1);
        }else if(clazz.equals(String.class)){
            return new String("【str】");
        }else if(clazz.equals(Date.class)){
            return new String("【date】");
//            return new Date();
        }else if(clazz.equals(Timestamp.class)){
            return new String("【timestamp】");
//            return new Timestamp(System.currentTimeMillis());
        }else if(clazz.equals(Boolean.class)){
            //正常不该出现
            return new String("【boolean】");
        }
        return null;
    }
    //
    public static void fill(Object obj) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Class clazz=obj.getClass();
        Field[] fs = clazz.getDeclaredFields();
        for(Field f : fs)
        {
            Class fieldClazz = f.getType(); // 得到field的class及类型全路径
            //获取真实的filed 的set方法名称;
            String fieldSetName=getSetFieldName(f.getName());
//            Character.isUpperCase(f.getName().substring())
            if(fieldClazz.isPrimitive())  continue;  //【1】 //判断是否为基本类型
            Object value=parse(fieldClazz);
            if(null!=value) {
                Method method = clazz.getDeclaredMethod(fieldSetName, fieldClazz);
                method.invoke(obj, value);
                continue;
            }
//            if(fieldClazz.equals(Integer.class)){
//                //数字
//                Integer integer=new Integer(1);
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,integer);
//                continue;
//            }else if(fieldClazz.equals(String.class)){
//                //字符串
//                String string=new String("【str】");
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,string);
//                continue;
//            }else if(fieldClazz.equals(Date.class)){
//                //Date
//                Date date=new Date();
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,date);
//                continue;
//            }else if(fieldClazz.equals(Timestamp.class)){
//                //Timestamp
//                Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,timestamp);
//                continue;
//            }else if(fieldClazz.equals(Double.class)){
//                //Double
//                Double aDouble=new Double(0);
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,aDouble);
//                continue;
//            }else if(fieldClazz.equals(Float.class)){
//                //Float
//                Float aFloat=new Float(System.currentTimeMillis());
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,aFloat);
//                continue;
//            }else if(fieldClazz.equals(Long.class)){
//                //Long
//                Long aLong=new Long(0);
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,aLong);
//                continue;
//            }else if(fieldClazz.equals(Character.class)){
//                Character character=new Character('c');
//                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
//                method.invoke(obj,character);
//                continue;
//            }else if(fieldClazz.equals(Boolean.class)) {
//                //不推荐Boolean  直接用int
//                Boolean aBoolean = new Boolean(false);
//                Method method = clazz.getDeclaredMethod(fieldSetName, fieldClazz);
//                method.invoke(obj, aBoolean);
//                continue;
//            }
            //TODO  数组没处理
            if(fieldClazz.isAssignableFrom(List.class)) //【2】
            {
                Type fc = f.getGenericType(); // 关键的地方，如果是List类型，得到其Generic的类型

                if(fc == null) continue;
                //泛型
                if(fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型
                {
                    ParameterizedType pt = (ParameterizedType) fc;
                    Class genericClazz = (Class)pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。
                    Object o=parse(genericClazz);
                    if(o==null){
                        Object inner=genericClazz.newInstance();
                        fill(inner);
                        o=inner;
                    }
                    List list=new ArrayList();
                    list.add(o);

                    Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
                    method.invoke(obj,list);
                }
                continue;
            }
            if(fieldClazz.isArray()){
                //TODO 数组只处理一维的对象数组  不能处理多维或基本类型数组
                Class elementType = f.getType().getComponentType();
                Object arrayObj=Array.newInstance(elementType,1);
                Object parseObj=parse(elementType);
                if(null==parseObj){
                    parseObj=elementType.newInstance();
                    fill(parseObj);
                }
                Array.set(arrayObj,0,parseObj);
                Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
                method.invoke(obj,arrayObj);
                continue;
            }
            //对象类型
            Object o=fieldClazz.newInstance();
            fill(o);
            Method method=clazz.getDeclaredMethod(fieldSetName,fieldClazz);
            method.invoke(obj,o);
            continue;

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
