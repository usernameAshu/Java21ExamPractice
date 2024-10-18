package interview_prep.dataStructures.leetcode.array_strings;

public class Length_of_Last_Word {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
//        String s = " a ";
        int result = new Length_of_Last_Word().lengthOfLastWord(s);
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        if(s.length()==1 && s.charAt(0)!=32) return 1; /* edge case */
        int start = 0, end = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) != 32) {
                end = i;
                break;
            }
            i--;
        }

        while (i >= 0) {
            if (s.charAt(i) == 32) {
                start = i;
                break;
            }
            i--;
        }
        if(end!=0) start++;
//        System.out.println("end="+end+", start="+start);
        return end - start + 1;
    }
}
