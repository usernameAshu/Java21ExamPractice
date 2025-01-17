import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestJPMC {

  void main() {

    //array : st, et
    //[ 10, 30, 12]
    //How many jobs can be done ?
    //1 job at a time

    /**
     * job2: [2,3]
     * job1: [1,2]
     * job3: [1,3]
     * jobs : [job1, job2, job3]
     *
     * [1,2]
     * [2,3]
     * [1,3]
     */

    /**
     * end-time of job1 =< start time of job2 : criteria for non-overlapping
     * start-time of job1 >= end-time of job2
     */

    int[][] jobs = {{1, 3}, {1, 3}, {2, 4}, {3, 4}, {1, 4}};
    Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));
    for (int[] job : jobs) {
      System.out.print("{" + job[0] + "," + job[1] + "},");
    }

    int count = 0;
    int lastEndTime = Integer.MIN_VALUE;

    for (int[] job : jobs) {
      int start = job[0], end = job[1];
      if (start >= lastEndTime) {
        count++;
        lastEndTime = end;
      }
    }

    System.out.println("\nMax jobs: " + count);
    /// //////////

    /**
     * Array of integers => array of ints
     * [1,3,9,3,2,4,1,2] => [3,9,-1,4,4,-1,2,-1]
     * [1,3,2,16,5,9,3,2,4,1,2,17] => [3,16,16,17,9,17,4,4,17,2,17,-1]
     *                 i j , maxEl= 17  [,2,17,-1]
     * [1,3,1,4,1,9,2,34]
     *      i     j  maxEl=34
     *
     * currEl < prevEl ? outArr => prevEl : outArr =>  currEl < maxEl ? maxEl : -1;
     * maxEl = currEl > maxEl ?
     * if(i < j) i--;
     * if(i > j) i--; j--;
     * 2 pointers
     *
     */
  }

  static void process() {
    int[] a = {1, 3, 4, 1, 2};

  }

}


