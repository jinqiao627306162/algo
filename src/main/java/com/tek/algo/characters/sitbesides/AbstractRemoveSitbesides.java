package com.tek.algo.characters.sitbesides;

import java.util.function.Function;

public abstract class AbstractRemoveSitbesides  implements RemoveSitbesidesInterface{

    @Override
    public boolean valid(String str,Function<String,Boolean> function) {
        return function.apply(str);
    }
}
