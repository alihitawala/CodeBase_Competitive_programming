package Coding.IBit.Hashing;

import java.util.*;

/**
 * Created by aliHitawala on 8/29/15.
 */
public class SubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        printArray(findSubstring(s, a));
    }

    private static void printArray(ArrayList<Integer> substring) {
        for (int i : substring) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> mapBunch = new HashMap<>();
        int[] ar = new int[b.size()];
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        for (String s : b) {
            if (map.containsKey(s)) {
//                map.put(s, map.get(s) + 1);
                int in = map.get(s);
                ar[in]++;
            }
            else {
                ar[i] = 1;
                map.put(s, i++);

            }
        }

//        HashMap<String, Integer> cloneMap = (HashMap<String, Integer>)map.clone();
        int length = b.get(0).length() * b.size();
        int slength = b.get(0).length();
        for (int j=0;j<a.length()-length+1;j++) {
            int k = j+length;
            int[] tempAr = Arrays.copyOf(ar, ar.length);
            boolean earlyBreak = false;
            for (int l=j;l<k;l+=slength) {
                String temp = a.substring(l,l+slength);
                if (map.containsKey(temp)) {
                    int id = map.get(temp);
                    if (tempAr[id] == 0) {
                        earlyBreak = true;
                        break;
                    }
                    tempAr[id]--;
//                    if (mapBunch.containsKey(id)) {
//                        break;
//                    }
//                    mapBunch.put(id, id);
                }
                else {
                    earlyBreak = true;
                    break;
                }
            }
//            if (mapBunch.keySet().size() == b.size()) {
//                result.add(j);
//            }
//            mapBunch.clear();
            if (!earlyBreak)
                result.add(j);
        }
        return result;
    }
}
