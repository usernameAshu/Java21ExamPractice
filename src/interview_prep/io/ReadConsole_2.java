package interview_prep.io;

import java.io.Console;

public class ReadConsole_2 {
    public static void main(String[] args) {
        Console c = System.console();
        if(c == null) {
            System.out.println("Console is not supported");
            return;
        }
    }
}
