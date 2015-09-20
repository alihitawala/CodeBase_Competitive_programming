package Coding.IBit.String;

/**
 * Created by aliHitawala on 9/14/15.
 */
public class AtoF {
    String str;
    float result;

    public AtoF(String s) throws Exception{
        this.str = s.trim();
        result = solve(str);
    }

    public float solve(String str) throws Exception{
        int indexOfE = str.indexOf('E');
        if(indexOfE == -1)
            indexOfE= str.indexOf('e');
        if(indexOfE == -1){
            return withoutE(str);
        }else{
            return (float) (withoutE(str.substring(0, indexOfE))*
                    Math.pow(10, withoutE(str.substring(indexOfE+1))));
        }
    }


    private float withoutE(String s) throws Exception{
        if(s.charAt(0) == '-'){
            return -withoutE(s.substring(1));
        }
        int indexOfPeriod = s.indexOf('.');
        if(indexOfPeriod == -1){
            return makeInt(s);
        }else{
            float beforePeriod = makeInt(s.substring(0,indexOfPeriod));
            float afterPeriod = makeInt(s.substring(indexOfPeriod+1));
            float temp = afterPeriod;
            int countDigit = 0;
            while(temp > 10){
                countDigit ++;
                temp /=10;
            }
            countDigit++;

            return (float)(beforePeriod + Math.pow(10, -countDigit)*afterPeriod);
        }

    }


    private float makeInt(String s) throws Exception{
        if(s.length() == 0)
            return 0;
        float res = 0f;
        for (int i = 0; i < s.length(); i++) {
            // for example 234 = ((2*10)+3)*10+4;
            res = res*10 + makeDigit(s.charAt(i));
        }
        return res;
    }


    private float makeDigit(char charAt) throws Exception {
        switch(charAt){
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                throw new Exception();

        }
    }

    public static void main(String[] args) throws Exception {
        AtoF a = new AtoF("3.2");
        System.out.println(a.result);
    }
}
