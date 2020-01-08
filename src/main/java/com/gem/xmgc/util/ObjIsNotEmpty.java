package com.gem.xmgc.util;

/**
 * 判断是否为空/判断是否为空字符串/判断是否为空格
 * @author jiowww
 * @data 2019/10/26.
 */
public class ObjIsNotEmpty {
    public static Boolean isNotEmpty(Object object){
        //判断是否为空
        if (object == null){
            return false;
        }
        //判断是否为字符串
        if (object instanceof String){
            String str = (String)object;

            //判断去除空格之后是否是空串
            if ("".equals(str.trim()) && str.trim().length() == 0){
                return false;
            }
        }
        //不是null或者空字符串或空格字符串
        return true;
    }
}
