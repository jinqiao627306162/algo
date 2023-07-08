package com.tek.algo.characters.sitbesides;

import com.tek.algo.characters.functionInterface.PrintFunction;
import com.tek.algo.characters.functionInterface.ReplaceFunction;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Suggested methods used to remove char sit besides more than three times
 */
public  class RemoveSitbesidesByDoublePointer extends AbstractRemoveSitbesides implements RemoveSitbesidesInterface{
    @Override
    public String process(String s , ReplaceFunction function, PrintFunction printout) {
        var l = 0;
        while (l < s.length()){
            // r for current position
            var r = l ;
            while(r < s.length() && s.charAt(r) == s.charAt(l)) {
                r += 1;
            }
                // char repeatd for three times
            if (r - l >= 3){
                // replace and return a new s
//                s = s.substring(0,l) + s.substring(r,s.length()) ;
                var removed = s.substring(l,r);

                Map<String,String> result = function.apply(s,l,r);
                s = result.get("rest").toString();

                printout.apply(s,removed,result.get("replace").toString());

                // l back 2 position   eg:ccddd ,remove ddd and back to first c
                l -= 2 ;
                if (l < 0){
                    l = 0;
                }
            }else{
                l = r;
            }
        }
        return s;
    }
}
