package com.yllt.constatns;


/**
 *
 * @author zhouyh
 */
public final class ErrorCode {
    //成功

    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
    /**
     * 使用服务器端的message
     */
    public static final int SERVER_MSG = 9999;
    //Session无效或者过期
    public static final int INVALID_SESSION = 9000;
    //数据库错误
    public static final int DATABASE_ERROR = 9001;
    //服务器维护中
    public static final int SERVER_MAINTAINING = 9002;
    //未知错误
    public static final int UNKNOW_ERROR = 9003;
    //参数错误
    public static final int PARAMETER_ERROR = 9004;
    //接口已经失效或者不存在
    public static final int NO_SERVICE_INTERFACE = 9005;
    //获取认证KEY失败
    public static final int KEY_ERROR = 9006;
    //用户名或者密码错误
    public static final int USERNAME_OR_PASSWORD_ERROR = 9007;
    //没有权限访问
    public static final int NO_PERMISSION = 9008;
    //请登录之后再操作
    public static final int NEED_LOGIN = 9009;
    //解密失败
    public static final int CRYPT_ERROR = 9010;
    //json解析失败
    public static final int JSON_PARSE_ERROR = 9011;
    //处理失败
    public static final int PROCESS_ERROR = 9012;
    //引用数据不存在
    public static final int QUOTE_DATA_DOESNOT_EXIST  = 9013;
    //数据不存在
    public static final int DATA_DOESNOT_EXIST  = 9014;
    //参数不匹配
    public static final int PARAMETER_NO_MATCH = 9015;
    //数据被引用
    public static final int DATA_BE_CITED= 9016;
    //XX参数不能为空
    public static final int PARAMETER_CAN_NOT_BE_NULL= 9017;
    //服务配置错误
    public static final int SERVICE_CONFIG_ERROR= 9018;
    //文件类型不匹配
    public static final int FILE_TYPE_UNMATCH= 9019;
    //文件大小不合适
    public static final int FILE_SIZE_UNMATCH=9020;
}
