package com.yllt.response;

import com.yllt.constatns.ErrorCode;

/**
 * Created by Administrator on 2015/10/28.
 */
public class Response<T> {

    private String errorMsg = "运行正确";
    private int errorCode = ErrorCode.SUCCESS;
    private T result;
    private int encryptType;

    public int getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(int encryptType) {
        this.encryptType = encryptType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Response(String errorMsg, int errorCode) {
        if(null!=errorMsg){
            this.errorMsg = errorMsg;
        }else {
            this.errorMsg="未知错误";
        }
        this.errorCode = errorCode;
    }

    public Response(T result) {
        this.result = result;
    }

    public static  < T> Response< T > success()
    {
        return success( null );
    }

    public static < T > Response< T > success( T result )
    {
        return new Response< T >(result);
    }

    public static < T > Response< T > fail( String errorMsg,int errorCode )
    {
        return new Response< T >(errorMsg,errorCode);
    }


//    public static < T > Response< T > fail( BaseBiz biz )
//    {
//        return new Response< T >(biz.getErrorMsg(),biz.getErrorCode());
//    }


    @Override
    public String toString() {
        return "Response{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                ", result=" + result +
                '}';
    }
}
