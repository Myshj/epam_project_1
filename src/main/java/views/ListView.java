package views;

import views.stringifiers.ListStringifier;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListView<T> extends View {
    public ListView(
            String header,
            List<T> list,
            Comparator<T> comparator,
            ListStringifier<T> stringifier
    ) {
        super(
                list.isEmpty() ? "Empty list..." : header,
                list.isEmpty() ? "" : stringifier.apply(
                        list.stream().sorted(comparator).collect(Collectors.toList())
                ),
                ""
        );
    }
}
