package views.stringifiers;

import java.util.function.Function;

public class Stringifier<T> implements Function<T, String> {
    @Override
    public String apply(T t) {
        return t.toString();
    }
}
