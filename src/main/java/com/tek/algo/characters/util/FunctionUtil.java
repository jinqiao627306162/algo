package com.tek.algo.characters.util;

import com.tek.algo.characters.functionInterface.PrintFunction;
import com.tek.algo.characters.functionInterface.ReplaceFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class FunctionUtil {

    // "Function" just for jdk 11 feature
    public static   Function<String, Boolean> validFunction = a -> {
        if (Pattern.matches("[a-z]+", a)) {
            return true;
        } else {
            System.out.println("输入不合法:" + a);
            return false;
        }
    };

    // print replace result
    public static PrintFunction replacePrintout = (a,b,c) -> {
        StringBuilder sb = new StringBuilder(a);
        if(c.isBlank()){
            System.out.println(sb.toString());
        }else{
            sb.append("    ").append(b).append(" replaced by: ").append(c);
            System.out.println(sb.toString());
        }
        return null;
    };

    // print remove result
    public static PrintFunction removePrintout = (a,b,c) -> {
        System.out.println(a) ;
        return null;
    };

    public static ReplaceFunction replaceFunction = (s, l, r)->{
        Map<String,String> result = new HashMap<>();
        if(l-2>=0 && s.charAt(l-1) == s.charAt(l-2)){
            result.put("replace",s.charAt(l-1)+"");
            s = s.substring(0,l)+ s.charAt(l-1) + s.substring(r,s.length()) ;
            result.put("replace",s.charAt(l-1)+"");

        }else if(l-1 >= 0 && r < s.length() && s.charAt(l-1) == s.charAt(r)){
            result.put("replace",s.charAt(l-1)+"");
            s = s.substring(0,l)+ s.charAt(l-1) + s.substring(r,s.length()) ;


        }else if(r+1 < s.length() && s.charAt(r) == s.charAt(r+1)){
            result.put("replace",s.charAt(r)+"");
            s = s.substring(0,l)+ s.charAt(r) + s.substring(r,s.length()) ;


        }else{
            s = s.substring(0,l) + s.substring(r,s.length()) ;
            result.put("replace","");

        }
        result.put("rest",s);

        return result;
    };

    public static ReplaceFunction normalFunction = (s, l, r)->{
        Map<String,String> result = new HashMap<>();
        String rs = s.substring(0,l) + s.substring(r, s.length()) ;
        result.put("rest",rs);
        result.put("replace","");
        return result;
    };
}
