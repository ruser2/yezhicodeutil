package com.yllt.utils;

public class StringUtil {

    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String firstToUpper( String s )
    {
        if ( s == null || s.length() == 0 )
        {
            return s;
        }
        if ( Character.isUpperCase( s.charAt( 0 ) ) )
            return s;
        else
            return ( new StringBuilder() ).append( Character.toUpperCase( s.charAt( 0 ) ) ).append( s.substring( 1 ) ).toString();
    }

    /**
     * 字符串数组转int数组
     * @param strs
     * @return
     * @return int[]
     */
    public static int[] convertStrsToInts( String[] strs )
    {
        int s3[] = new int[strs.length];

        for ( int i = 0; i < strs.length; i++ )
        {
            s3[i] = Integer.parseInt( strs[i] );// 将字符串数组转换成整型,结果出现异常。后面事件处理时，调用sort,出现错误。*/
        }

        return s3;
    }
	/*
	*
	* 数字不足位数左补0
	*
	* @param str
	* @param strLength
	*/
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
		while (strLen < strLength) {
		StringBuffer sb = new StringBuffer();
		sb.append("0").append(str);//左补0
		// sb.append(str).append("0");//右补0
		str = sb.toString();
		strLen = str.length();
		}
		}
		return str;
	}
	
	
	/**
	 * 字符串替换成特殊字符
	 */
	public static String replaceStr(String Str ,String toStr ,int began ,int end){
		String beganStr = Str.substring(0, began);
		String endStr = Str.substring(end,Str.length());
		String toStrs = "";
		for(int i = 0 ; i < (end - began); i++){
			toStrs += toStr;
		}
		return beganStr+toStrs+endStr;
	}
	
	
	public static String miniStr(String str,int num){
		if(str == null){
			return "";
		}
		if(str.length() < num){
			return str;
		}else{
			return str.substring(0, num)+"...";
		}
	}

    /**
     * 是否为空（"     "不为空）
     * @param content
     * @return
     */
    public static boolean isEmpty( String str )
    {
        return ( ( str == null ) || ( str.length() == 0 ) );
    }

    /**
     * 是否空白（"     "也为空）
     * @param content
     * @return
     */
    public static boolean isBlank( String str )
    {
        int length;

        if ( ( str == null ) || ( ( length = str.length() ) == 0 ) )
        {
            return true;
        }

        for ( int i = 0; i < length; i++ )
        {
            if ( !Character.isWhitespace( str.charAt( i ) ) )
            {
                return false;
            }
        }

        return true;
    }
}
