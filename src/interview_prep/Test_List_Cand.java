package interview_prep;

import java.util.*;

/*
       23 floors building
       3 lifts
       First lift to serve for a request
       (up/down)-> {group lift direction} -> {nearest direction lift should come}
        */
public class Test_List_Cand {
    public static void main(String[] args) {
        //lift1 - 0, lift2- 1, lift3 -2
        //up= 1, down = 0
        Lift l1 = new Lift(0,1); //1st lift
        Lift l2 = new Lift(5,0); //2nd lift
        Lift l3 = new Lift(7,0);
        List<Lift> lifts = List.of(l1,l2,l3);


        int userFloor = 3;
        int userDirection = 0;

        fetchLiftId(userFloor,userDirection, lifts);

    }

    public static int fetchLiftId(int userFloor, int userDirection, List<Lift> lifts) {

        Map<Integer, Integer> weightMap = new HashMap<>(); //distance: liftIndex
        Set<Integer> distSet = new HashSet<>();
        //calculate distance : isSameDirection
        for(int i =0; i< lifts.size();i++) {
            Lift l = lifts.get(i);
            int dist = Math.abs(userFloor - l.pos);
           if(weightMap.containsKey(dist)) {
               //check for direction
               if(userDirection == l.direction){
                   weightMap.put(dist, i+1);
               }
           } else {
               weightMap.put(dist, i+1);
           }
        }

        weightMap.forEach((k,v)-> System.out.println(k+":"+v));

        //sort the map by key
        //first value is your lift number which should serve the user
        List<Integer> keys = new ArrayList<>(weightMap.keySet());



        return 0;
    }
}

class Lift {

    int pos;
    int direction;

    public Lift(int pos, int direction) {
        this.pos = pos;
        this.direction = direction;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
