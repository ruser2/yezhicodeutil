package com.yllt.utils;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateTimeUtil {
	/*
	 *字符串的日期格式的计算 
	 */  
	public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
	/*
	 * 字符串计算时间差
	 */
	public static long secondsBetween(String smdate,String bdate) throws ParseException{
		   SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   java.util.Date begin=dfs.parse(smdate);
		   java.util.Date end = dfs.parse(bdate);
		   long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
		   return between;
	}
	
	/*
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日"). 
     * @param date String 想要格式化的日期 
     * @param oldPattern String 想要格式化的日期的现有格式 
     * @param newPattern String 想要格式化成什么格式 
     * @return String  
     */   
    public static String StringDate(String date, String oldPattern, String newPattern) {   
        if (date == null || oldPattern == null || newPattern == null)   
            return "";   
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern) ;        // 实例化模板对象    
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern) ;        // 实例化模板对象    
        Date d = null ;    
        try{    
            d = sdf1.parse(date) ;   // 将给定的字符串中的日期提取出来    
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理    
            e.printStackTrace() ;       // 打印异常信息    
        }    
        return sdf2.format(d);  
    } 
	
	/** 
    * 计算当月最后一天,返回字符串 
    *  
    * @return 
    */  
   public static String getDefaultDay() {  
       String str = "";  
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
       Calendar lastDate = Calendar.getInstance();  
       lastDate.set(Calendar.DATE, 1);// 设为当前月的1号  
       lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号  
       lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天  
 
       str = sdf.format(lastDate.getTime());  
       return str;  
   } 
   
   /** 
    * 获取当月第一天 
    *  
    * @return 
    */  
   public static String getFirstDayOfMonth() {  
       String str = "";  
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
 
       Calendar lastDate = Calendar.getInstance();  
       lastDate.set(Calendar.DATE, 1);// 设为当前月的1号  
       str = sdf.format(lastDate.getTime());  
       return str;  
   }  
   
   /**
    * 获取当前时间
    */
   public static Timestamp getNowTime(){
	   return new Timestamp(System.currentTimeMillis());
   }
}

