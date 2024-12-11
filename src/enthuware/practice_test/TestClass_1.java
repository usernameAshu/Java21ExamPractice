package enthuware.practice_test;

record Student(int id, String... subjects) {
    public Student {
        if (id < 0) throw new IllegalArgumentException();
        if (subjects == null || subjects.length == 0) {
            subjects = new String[]{"english"};
        }
    }
}

public class TestClass_1 {
    public static void main(String[] args) {
        Student s = new Student(100, null);
        switch (s) {
            case Student(var id, var subjects):
                System.out.println(s);
            default:
                System.out.println("default");
        }
    }
}
