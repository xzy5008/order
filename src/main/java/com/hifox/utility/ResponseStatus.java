package com.hifox.utility;

/**
 * Created by lihao on 2016/6/24.
 */
public class  ResponseStatus {
    /**
     * 正常
     */
    public static final int OK=0;
    /**
     * 内部错误
     */
    public static final int ERROR=1;
    /**
     * 没有找到
     */
    public static final int NOT_FOUND=2;
    /**
     * 表单验证错误
     */
    public static final int FIELD_ERROR =3;

    /**
     * 验证错误
     */
    public static final int AUTHENTICATION_EXCEPTION =4;

    /**
     * 异常错误
     */
    public static final int EXCEPTION =5;
}
