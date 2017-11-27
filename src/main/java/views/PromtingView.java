package views;

public class PromtingView extends View {
    private static final String PROMT = "> ";

    public PromtingView(
            String header,
            String body,
            String hint
    ) {
        super(
                header,
                body,
                String.format("%s\n%s", hint, PROMT)
        );
    }
}
