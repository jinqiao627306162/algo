package com.tek.algo.characters.sitbesides;

import com.tek.algo.characters.functionInterface.PrintFunction;
import com.tek.algo.characters.functionInterface.ReplaceFunction;

import java.util.function.Consumer;
import java.util.function.Function;

public interface RemoveSitbesidesInterface {

    /**
     * if 3 or more consecutive
     * characters are identical, remove them from the string,Repeat this process until
     * there is no more than 3 identical characters sitting besides each other
     * @param str
     * @return str
     */
    String process(String str,ReplaceFunction function, PrintFunction printFunction);

    /**
     * if the param str is valid
     * return true when char in a-z,else return false
     * @param str
     * @return
     */
    boolean valid(String str, Function<String, Boolean> function);

}
