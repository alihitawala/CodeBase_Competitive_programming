package Coding.PureStorage;

import java.util.Stack;

/**
 * Created by aliHitawala on 3/14/16.
 */
public class StackMy
{
    public static void main(String[] args) {
        String[] input = {"ACQUIRE 10", "ACQUIRE 20", "RELEASE 20", "RELEASE 10"};
        System.out.println(isGood(input));
    }
    private static final String ACQUIRE  = "ACQUIRE";
    private static final String RELEASE  = "RELEASE";

    static Stack<Event> stack = new Stack<>();
    public static boolean isGood(String[] events) {
        for(String s : events) {
            String[] values = s.split(" ");
            String name = values[0];
            int c = Integer.parseInt(values[1]);
            if(name.equals(ACQUIRE)){
                stack.push(new Event(name, c));
            }else{
                if(stack.peek().name.equals(name)&&stack.peek().count==c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
    static class Event {
        String name;
        int count;

        public Event(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
