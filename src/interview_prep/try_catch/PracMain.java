package interview_prep.try_catch;

public class PracMain {
    public static void main(String[] args) {

       int resp3 = new PracMain().test3();
        System.out.println(resp3);
    }

    void test() {
        //try block exists with eiether catch or finally or both
        //try-catch
        //try-finally
        //try-catch-finally
        try {
//          throw new Exception();

        } catch (Exception e) {

        }

        try {

        } finally {

        }
    }

    int test2() {
        try{
            return 1;

        } catch (Exception e) {
            return 2;
        }
    }

    int test3() {
        try {
            return -1;

        } finally {
            return 1;
        }
    }
}
