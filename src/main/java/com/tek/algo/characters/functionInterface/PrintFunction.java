package com.tek.algo.characters.functionInterface;

@FunctionalInterface
public interface PrintFunction<T extends String,U extends String ,K extends String, R extends String> {
    R apply(T t, U u, K k);
}
