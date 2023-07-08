package com.tek.algo.characters.functionInterface;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface ReplaceFunction<T extends String,U extends Integer,K extends Integer,R extends Map<String,String>> {
    R apply(T t,U u,K k);
}
