package utils;

@FunctionalInterface
public interface QuadFunction<K, R, V, S, RT> {
    RT apply(K k, R r, V v, S s);
}
