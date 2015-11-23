package MiscTopic;

import java.util.*;

/**
 * Created by aliHitawala on 11/23/15.
 */
public class SortedMap {
    public static void main(String[] args) {
        new SortedMap().sortedMap();
    }

    public void sortedMap() {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("a", 4);
//        map.put("b", 1);
//        map.put("c", 2);
//        map.put("d", 5);
//        map.put("e", 6);
//        Map<String, Integer> map2 = new TreeMap<>(new ValueComparator(map));
//        map2.putAll(map);
//        for (String s : map2.keySet()) {
//            System.out.println("Key :: " + s + " Value :: " + map2.get(s));
//        }
//
        Map<String, Pair> newMap = new HashMap<>();
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(20, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.f-a.f;
            }
        });
//
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<10;i++) {
            String s = sc.next();
            if (newMap.containsKey(s)) {
                newMap.get(s).f++;
            }
            else {
                Pair pair = new Pair(s, 1);
                newMap.put(s, pair);
                pairPriorityQueue.add(pair);
            }
        }
        for (Pair p : pairPriorityQueue) {
            System.out.println("Pair:: String :: " + p.s + "  freq :: " + p.f);
        }
    }

    class Pair {
        String s;
        int f;

        public Pair(String s, int f) {
            this.f = f;
            this.s = s;
        }
    }
    class ValueComparator implements Comparator<String> {
        Map<String, Integer> map;
        public ValueComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String a, String b) {
            return this.map.get(b) - this.map.get(a);
        }
    }
}
