package com.yxw.demo.utils;

public class ResultUtils {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;

    public  static  Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setStatus(SUCCESS);
        result.setMsg(Constant.SUCCESS);
        result.setData(object);
        return result;

    }

    public  static  Result<Object> fail(){
        Result<Object> result = new Result<>();
        result.setStatus(FAIL);
        result.setMsg(Constant.AUTHORITY);
        result.setData(null);
        return result;
    }
    public  static  Result<Object> exist(){
        Result<Object> result = new Result<>();
        result.setStatus(FAIL);
        result.setMsg(Constant.EXIST);
        result.setData(null);
        return result;
    }

    public  static  Result<Object> lack(){
        Result<Object> result = new Result<>();
        result.setStatus(FAIL);
        result.setMsg(Constant.NO_PARAMETER);
        result.setData(null);
        return result;
    }
}
