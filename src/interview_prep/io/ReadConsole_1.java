package interview_prep.io;

import java.util.Scanner;

public class ReadConsole_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String txt = null;

        System.out.println("Enter exit to escape");
        while( !(txt = s.nextLine()).equalsIgnoreCase("exit") ) {
            System.out.println("User input: " +txt);
        }
    }
}
