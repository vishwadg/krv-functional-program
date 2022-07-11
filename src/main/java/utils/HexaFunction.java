package utils;

@FunctionalInterface
public interface HexaFunction<K, R, V, S, U, RT> {
    RT apply(K k, R r, V v, S s, U u);
}
