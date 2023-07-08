package com.tek.algo.characters.application;

import com.tek.algo.characters.sitbesides.RemoveSitbesidesByDoublePointer;
import com.tek.algo.characters.sitbesides.RemoveSitbesidesInterface;
import com.tek.algo.characters.util.FunctionUtil;

import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

public class SitbesidesApplication {
    /**
     * valid if the string input is correct
     */
    static Function<String, Boolean> function = a -> {
        if (Pattern.matches("[a-z]+", a)) {
            return true;
        } else {
            System.out.println("input invalid:" + a);
            return false;
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input String with range of  [a-z]！");
        String s = in.nextLine();
        RemoveSitbesidesInterface doublePointer = new RemoveSitbesidesByDoublePointer();
        if(doublePointer.valid(s,FunctionUtil.validFunction)){
            // if you want to replace while remove ,youcan use FunctionUtil.replaceFunction
            doublePointer.process(s, FunctionUtil.replaceFunction, FunctionUtil.replacePrintout);

//            // if you just want to remove ,you can choose normalFunction
//            doublePointer.process(s, FunctionUtil.normalFunction,FunctionUtil.removePrintout);
        }
    }
}
