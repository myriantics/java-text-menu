import java.util.*;

import javax.swing.text.html.Option;

public class Main {

    static Scanner userIn = new Scanner(System.in);

	public static final Map<String, Integer> inputMap =
		Map.of(
			"w", -1,
			"s", 1,
			"a", -1,
			"d", 1
		)
	;
    
    public enum option1 {
        RED,
        BLUE,
        GREEN,
        YELLOW,
    }
    public enum option2 {
        ONE,
        TWO,
        THREE,
    }
    public enum option3 {
        HELLO_WORLD,
        GOODBYE,
        SUSIPCIOUS,
        AMONGUGSNGS,
    }

    public static void main(String[] args) {

        String input = "";
        boolean running = false;
        
        /*Object[] e = EnumSet.allOf(option1.class).toArray();
        for (Object E : e) {
            switch (Enum.valueOf(option1.class, E.toString())) {
                case RED:
                case BLUE:
                case GREEN:
                case YELLOW:
                    System.out.println(E);
            }
        }*/


        TextMenu menu = new TextMenu();
        //menu.add(new MenuSelection(option1.values()))
        //    .add(new MenuSelection(option2.values()))
        //    .add(new MenuSelection(option3.values()));

        while (running) {

            clear();
            for (String line : menu.toListOfStrings()) {
				System.out.println(line);
			}
            input = userIn.nextLine().toLowerCase();

            if (input.matches("quit|q")) {
                running = false;
            } else if (input.matches("[wasdc]")) {
				int x = input.matches("[ad]") ? inputMap.get(input) : 0;
				int y = input.matches("[ws]") ? inputMap.get(input) : 0;
				boolean select = input.matches("c");
				menu.updateWithInput(x, y, select);
            }
        }

		//System.out.println(menu.getResult(option1.class));

        //System.out.println("hello world!");

    }

    // yoinked from random stack overflow thread
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}