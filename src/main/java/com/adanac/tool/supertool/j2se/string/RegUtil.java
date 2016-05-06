package com.adanac.tool.supertool.j2se.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {
    
    private static final String REG_VAL = "\\{([^}]+)\\}";
    private static final Pattern PATTERN = Pattern.compile(REG_VAL);
    
    private RegUtil(){}
    
    /**
     * 作用查找字符串中所有大括号的中间的字符
     * @param value 字符串
     * */
    public static List<String> findArgs(String value){
        Matcher matcher = PATTERN.matcher(value) ;  
        List<String> array = new ArrayList<>();
        String tempValue = null;
        while(matcher.find()){
            tempValue = matcher.group() ;
            /*取出大括号中间的字符*/
            tempValue = tempValue.substring(1, tempValue.length()-1) ;
            /*判断该字符是否已经查找到*/
            if(!array.contains(tempValue)){
                array.add( tempValue ) ; 
            }
        }
        return array;
    }
    
    /**
     * 替换所有字符串参数
     * @param value
     * @param map
     */
    public static String replace(String value, Map<String, String> map){
        return replace(value, map, false);
    }
    
    /**
     * 替换所有字符串参数
     * @param value 字符串
     * @param map 替换的值
     * @param noExistsReplace 是否全部替换[true-不存在替换的值以空字符替换, false-不替换不存在替换的值]
     */
    public static String replace(String value, Map<String, String> map, boolean noExistsReplace){
        if(null == value || null == map){
            return value;
        }
        for(Map.Entry<String,String> entry : map.entrySet()){
            String key = "\\{" + entry.getKey() + "\\}";
            value = value.replaceAll(key, entry.getValue()) ;
        }
        if(noExistsReplace){
            List<String> datas = findArgs(value) ; 
            Map<String,String> tempValue = new LinkedHashMap<String, String>();
            for(String data : datas){
                tempValue.put(data , "") ; 
            }
            return replace(value , tempValue, false) ;
        }
        return value;
    }
    
}

