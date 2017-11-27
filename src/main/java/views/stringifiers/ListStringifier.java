package views.stringifiers;

import java.util.List;

public class ListStringifier<T> extends Stringifier<List<T>> {
    private final Stringifier<T> elementStringifier;

    public ListStringifier(Stringifier<T> elementStringifier) {
        this.elementStringifier = elementStringifier;
    }

    @Override
    public String apply(List<T> ts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ts.size(); i++) {
            sb.append(String.format("%20s", i));
            sb.append(elementStringifier.apply(ts.get(i)));
            sb.append("\n");
        }
        //return repository.all().stream().map(elementStringifier).collect(Collectors.joining("\n"));
        return sb.toString();
    }
}
