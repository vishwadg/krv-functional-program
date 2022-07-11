package utils;

@FunctionalInterface
public interface TriFunction<K,R,V,RT> {
    RT apply(K k,R r, V v);
}
