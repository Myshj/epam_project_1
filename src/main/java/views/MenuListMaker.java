package views;

import java.util.List;

class MenuListMaker {
    String make(List<String> choices) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < choices.size(); i++) {
            sb.append(String.format("%d. %s\n", i + 1, choices.get(i)));
        }
        return sb.toString();
    }
}
