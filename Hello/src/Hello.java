import java.util.*;

public class Hello {
    public static void main(String[] args) {
        if (2013%4 == 0) {
            System.out.println("Yes\n");
        }
        else {
            // get first input
            System.out.print("What is your name? ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();

            // get second input
            System.out.print("How old are you? ");
            int age = in.nextInt();

            // display output on console
            System.out.println("Hello, " + name + ". Next year, you'll be " + (age +1));

            System.out.println("No\n");
            String[] greeting = new String[3];
            greeting[0] = "Welcome to Core Java";
            greeting[1] = "by Cay Horstmann";
            greeting[2] = "and Gary Cornell";
            for (String g : greeting)
            	System.out.println(g);
        }
    }
}

