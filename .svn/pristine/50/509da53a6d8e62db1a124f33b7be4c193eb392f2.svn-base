package com.yllt.utils;

/**
 * Created by Administrator on 2015/11/25.
 */
public class PageUtil {

    public static int getTotalPage(int totalCount, int pageCount) {
        int totalPage = 0;
        if (pageCount > 0) {
            if(totalCount % pageCount == 0){
                totalPage = totalCount / pageCount;
            }else{
                totalPage = (totalCount / pageCount) + 1;
            }
        }
        return totalPage;
    }
}
