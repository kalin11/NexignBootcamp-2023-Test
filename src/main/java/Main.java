import manager.Manager;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("US"));
        Manager manager = new Manager("cdr.txt");
        manager.manage();
    }
}
