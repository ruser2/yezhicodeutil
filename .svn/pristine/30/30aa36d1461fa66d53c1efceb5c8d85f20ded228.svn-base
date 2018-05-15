package com.yllt.utils;
//package com.manager.utils;
//
//import com.hlznt.jf.portal.common.annotation.Option;
//import com.manager.contract.BaseParam;
//import com.manager.pojo.comm.Response;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import java.lang.reflect.Field;
//
///*
//* EEfuse
//* @author Sean Lai
//* @version 1.0,2010/12/7
//* Copyright (c) 2010.
//*/
//
//public abstract class ParamValidator222 {
//
//    private static final Log logger = LogFactory.getLog(ParamValidator222.class);
//
//
//    /**
//     * 对Event进行参数校验
//     *
//     * @param evt 要校验的Event
//     * @return Response
//     */
//    protected Response validate(BaseParam evt) {
//
//        if (evt == null) {
//            return Response.fail("参数不能为空",10000);
//        }
//
//        //设置remoteAddr
//        //evt.setRemoteAddr(getRemoteAddr());
//
////        if (evt instanceof BaseQueryEvt) {
////            if (QueryType.QUERY_RESET.getValue().
////                    equals(((BaseQueryEvt) evt).getQueryType())) {
////
////                if (((BaseQueryEvt) evt).getStartRecordNum() == null) {
////                    ((BaseQueryEvt) evt).setStartRecordNum(0);
////                }
////
////                if (((BaseQueryEvt) evt).getQuerySize() == null) {
////                    ((BaseQueryEvt) evt).setQuerySize(50);
////                } else if (((BaseQueryEvt) evt).getQuerySize() > 1000) {
////                    //TODO 限制查询大小
////                    ((BaseQueryEvt) evt).setQuerySize(1000);
////                }
////
//////                resp.setReturnCode("200001");
//////                resp.setReturnValue(evt.getClass().getName());
//////                return resp;
////            }
////        }
//
//        try {
//            Field[] declaredFields = evt.getClass().getDeclaredFields();
//            Field.setAccessible(declaredFields, true);
//
//            for (Field field : declaredFields) {
//                Response vResp = check(field, null, null, evt, null);
//                if (!vResp.isSuccess())
//                    return vResp;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return resp;
//    }
//
//    private Response check(Field field, Class fieldType, Object value, BaseEvt evt, Object returnValue) throws Exception {
//
//        Response resp = new Response();
//
//        try {
//            if (field.isAnnotationPresent(com.hlznt.jf.portal.common.annotation.Field.class)) {
//                com.hlznt.jf.portal.common.annotation.Field annotation
//                        = field.getAnnotation(com.hlznt.jf.portal.common.annotation.Field.class);
//
//                if (fieldType == null) {
//                    fieldType = field.getType();
//                }
//
//                if (value == null && evt != null) {
//                    value = field.get(evt);
//                }
//
//                boolean isArray = fieldType.isArray();
//
//                //为空检查
//                if (annotation.nullable() && value == null) {
//                    if (!StringUtil.isEmpty(annotation.def()) && !isArray && evt != null)
//                        setFieldValue(field, evt, annotation.def()); //设置默认值
//                    return new Response();
//                } else if (!annotation.nullable() && value == null) {
//                    //不允许为空
//                    String msg = "[" + field.getName() + "]参数值为空";
//                    logger.debug(msg);
//                    resp.setReturnInfo(msg);
//                    resp.setReturnCode("200001");
//                    return resp;
//                }
//
//                if (isArray) {
//                    String name = field.getType().getName();
//                    String typeName = name.replace("[L", "").replace(";", "");
//                    Class typeClass = Class.forName(typeName);
//                    Object[] objects = (Object[]) value;
//                    for (Object object : objects) {
//                        Object rv = null;
//                        Response check = check(field, typeClass, object, null, rv);
//                        if (!check.isSuccess()) {
//                            return check;
//                        } else if (rv != null) {
//                            //TODO
//                            object = rv;
//                            //return new Response();
//                        }
//                    }
//                    return new Response();
//                }
//
//                //长度校验
//                if (value != null && annotation.length() != -1
//                        && value.toString().length() > annotation.length()) {
//                    if (annotation.cut() && fieldType.equals(String.class)) {
//                        //对字符串进行裁剪
//                        String str = value.toString();
//                        if (evt != null) {
//                            setFieldValue(field, evt, str.substring(0, annotation.length()));
//                        } else {
//                            returnValue = str.substring(0, annotation.length());
//                        }
//                        return new Response();
//                    } else {
//                        String msg = "[" + field.getName() + "]参数值的长度超出[" + annotation.length() + "]";
//                        logger.debug(msg);
//                        resp.setReturnInfo(msg);
//                        resp.setReturnCode("200003");
//                        return resp;
//                    }
//                }
//
//                //格式检查 正则式
//                if (!StringUtil.isEmpty(annotation.regex())) {
//                    if (value != null
//                            && !StringUtil.isEmpty(value.toString())
//                            && !value.toString().matches(annotation.regex())) {
//                        String msg = "[" + field.getName() + "]格式错误，请检查参数值是否匹配正则表达式'" + annotation.regex() + "'";
//                        logger.debug(msg);
//                        resp.setReturnInfo(msg);
//                        resp.setReturnCode("200002");
//                        return resp;
//                    }
//                } else if (!annotation.pattern().equals(Pattern.NULL)) {
//                    String parrent = SysConfig.getConfig("pattern." + annotation.pattern().name().toLowerCase());
//                    if (!StringUtil.isEmpty(parrent) && value != null
//                            && !StringUtil.isEmpty(value.toString())
//                            && !value.toString().matches(parrent)) {
//                        String msg = "[" + field.getName() + "]格式错误，请检查参数值是否匹配正则表达式'" + parrent + "'";
//                        logger.debug(msg);
//                        resp.setReturnInfo(msg);
//                        resp.setReturnCode("200002");
//                        return resp;
//                    }
//                }
//
//                //是否在值列表中
//                if (value != null && annotation.option() != null && annotation.option().length > 0) {
//                    boolean pass = false;
//                    for (Option option : annotation.option()) {
//                        if (option.value().equals(value.toString())) {
//                            pass = true;
//                            break;
//                        }
//                    }
//                    if (!pass) {
//                        String msg = "[" + field.getName() + "]参数值不在有效值范围内";
//                        logger.debug(msg);
//                        resp.setReturnInfo(msg);
//                        resp.setReturnCode("200002");
//                        return resp;
//                    }
//                }
//
//            }
//
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return new Response();
//    }
//}
