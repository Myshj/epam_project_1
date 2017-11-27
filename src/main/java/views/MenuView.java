package views;

import java.util.List;

public class MenuView extends PromtingView {

    public MenuView(
            String header,
            List<String> choices,
            String hint
    ) {
        super(
                header,
                new MenuListMaker().make(choices),
                hint
        );
    }
}
