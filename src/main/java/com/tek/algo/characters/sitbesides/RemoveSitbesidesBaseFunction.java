package com.tek.algo.characters.sitbesides;

import com.tek.algo.characters.functionInterface.PrintFunction;
import com.tek.algo.characters.functionInterface.ReplaceFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * this is a correct class to remove the characters sit besides for morthan 3 times.And this class will remove the
 * likely words by the order it appears.for example ,"dbbbaaacc",we will remove "bbb" at first,but not "aaa".
 * we use this class to validate other implementions of RemoveSitbesidesInterface.
 */
public  class RemoveSitbesidesBaseFunction extends AbstractRemoveSitbesides implements RemoveSitbesidesInterface{


    @Override
    public String process(String str , ReplaceFunction function , PrintFunction printout) {
        if(str.length() < 2){
            return str;
        }
        // "var" just for jdk 11 feature
        var start = -1;
        var end = -1;
        List<Integer> startes = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            char c = (char)(97+i);
            // "repeat" just for jdk 1.8 feature
            String match = ("" + c).repeat(3);
            int index = str.indexOf(match);
            if(index != -1){
                start = index;
                end = index +2;
                startes.add(start);
                ends.add(end);
            }
        }

        //"Stream" computer the min index to be removed, just for jdk 1.8 feature
        AtomicReference<Integer> minindex = new  AtomicReference(Integer.MAX_VALUE);
        AtomicReference<Integer> minValue = new  AtomicReference(Integer.MAX_VALUE);
        Stream.iterate(0, i -> i + 1).limit(startes.size()).forEach(i -> {
            Integer s = startes.get(i);
            if(s < minValue.get()){
                minindex.set(i);
                minValue.set(s);
            }
        });

        if(minindex.get().compareTo(Integer.MAX_VALUE) !=0){
            start = startes.get(minindex.get());
            end = ends.get(minindex.get());
        }
        if(start == -1 || end == -1){
            return str;
        }else{
            while( (end+1 < str.length()) && (str.charAt(start) == str.charAt(end+1)) ){
                end++;
            }
            String result = function.apply(str, start,end + 1).get("rest").toString();
//            String result = (start>0?str.substring(0,start):"") + ( (end < str.length()-1) ? str.substring(end + 1,str.length()): "");
            return process(result,function,printout);
        }
    }
}
