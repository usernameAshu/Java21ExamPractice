package enthuware.practice_test;

public class StringExpression {
    public static void main(String[] args) {
        String s = """     
                hello     
                world     
                """.trim();

        System.out.println(s);

        s = new StringBuilder("world").append("hello ", 0, 6).toString();

        System.out.println(s);

        s = new StringBuilder("world").insert(0, "hello ").toString();

        System.out.println(s);

    }
}
