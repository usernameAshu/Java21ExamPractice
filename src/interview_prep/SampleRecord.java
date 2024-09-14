package interview_prep;

public record SampleRecord(int a, String b) {

    @Override
    public String toString() {
        return "SampleRecord[" +
                "a=" + a + ", " +
                "b=" + b + ']';
    }


}
