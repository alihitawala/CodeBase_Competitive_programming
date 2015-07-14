package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/14/15.
 */
public class FullJustified {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x = reader.readLine();
            a.add(x);
        }
        int L = in.nextInt();
        printArray(new FullJustified().fullJustify(a, L));
    }

    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        int start = 0,sz=0;
        ArrayList<String> result = new ArrayList<String>();
        for (int i=0;i<A.size();i++) {
            int wordLength = A.get(i).length();
            if (wordLength + sz > B) {
                ArrayList<String> subList = new ArrayList<String>(A.subList(start, i));
                String a = getString(subList, B);
                result.add(a);
                start=i;
                sz=wordLength+1;
            }
            else sz += wordLength + 1;
        }
        ArrayList<String> subList = new ArrayList<String>(A.subList(start, A.size()));
        String a = getStringLast(subList, B);
        if (a.trim().length() > 0)
            result.add(a);
        return result;
    }

    private String getStringLast(ArrayList<String> subList, int b) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i<subList.size();i++ ){
            result.append(subList.get(i));
            if (i!=subList.size()-1)
                result.append(" ");
        }
        int temp = result.length();
        while (temp != b) {
            result.append(" ");
            temp++;
        }
        return result.toString();
    }

    private String getString(ArrayList<String> subList, int b) {
        int totalLength = totalLength(subList);
        StringBuilder result = new StringBuilder("");
        int gap = subList.size() > 1 ? ((b-totalLength)/(subList.size()-1)) : 0;
        int mod = subList.size() > 1 ? ((b-totalLength) - (gap*(subList.size()-1))) : 0;
        for (int i = 0; i<subList.size();i++ ){
            result.append(subList.get(i));
            int g = gap;
            if (mod>i) g++;
            for (int j=0;j<g && i!=subList.size()-1;j++)
                result.append(" ");
        }
        int temp = result.length();
        while (temp != b) {
            result.append(" ");
            temp++;
        }
        return result.toString();
    }

    private static int totalLength (ArrayList<String> list) {
        int result =0;
        for (String s : list) {
            result += s.length();
        }
        return result;
    }

    private static void printArray(ArrayList<String> solve) {
        for (String j : solve)
            System.out.print(j + "\n");
        System.out.println();
    }
}
