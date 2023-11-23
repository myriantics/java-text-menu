import java.util.*;

public class Main {

    static Scanner userIn = new Scanner(System.in);

	public static final Map<String, Integer> inputMap =
		Map.of(
			"w", 1,
			"s", -1,
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
        SUSPICIOUS,
        AMONGUS,
    }

    public static void main(String[] args) {

        String input = "";
        boolean running = true;

        TextMenu menu = new TextMenu();
        menu.add("The Robot Controller app is obsolete. You should")
            .add("install the new version of this FTC season.")
            .add("To ensure correct operation of the IMU in this")
            .add()
            .add("colors")
            .add(option1.class)
            .add()
            .add("numbers!! YUH")
            .add(option2.class)
            .add()
            .add("Stuff")
            .add(option3.class)
            .add()
            .add(new MenuSlider("test",  5.0, 10.0, 4.0));
        
        MenuInput menuInput = new MenuInput();

        clear();
        while (running) {

            for (String line : menu.toListOfStrings()) {
				System.out.println(line);
			}
            input = userIn.nextLine().toLowerCase();
            clear();

            if (input.matches("quit|q")) {
                if (menu.isCompleted()) {
                    running = false;
                } else {
                    System.out.println(">>> You must complete the menu!\n");
                }
            } else if (input.matches("[wasdc]")) {
				int x = input.matches("[ad]") ? inputMap.get(input) : 0;
				int y = input.matches("[ws]") ? inputMap.get(input) : 0;
				boolean select = input.matches("c");

				menu.updateWithInput(menuInput.update(x, y, select));

            }
        }
        
        System.out.println(menu.getSelectionResult(option1.class));
        System.out.println(menu.getSelectionResult(option2.class));
        System.out.println(menu.getSelectionResult(option3.class));

        //switch (getEnumValue(option1.class, "RED")) {
        switch (menu.getSelectionResult(option1.class)) {
            case RED:System.out.println("red!");break;
            case BLUE:System.out.println("blue!");break;
            case GREEN:System.out.println("green!");break;
            case YELLOW:System.out.println("yellow!");break;
        }
    }

    // yoinked from random stack overflow thread
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}