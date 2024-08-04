import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class linkedin1 {
    public static void main(String args[]) {
        String s = "aababcaab";
        int  minSize=3;
        HashMap<String,Integer> m=new HashMap<String,Integer>();

        for(int i=0;i<=s.length()-minSize;i++){
            String subString=s.substring(i, i+minSize);
            if(m.containsKey(subString)){
                m.put(subString, m.get(subString) + 1);
            }
            else{
                m.put(subString, 1);
            }
        }


        for(Map.Entry<String,Integer> e:m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }


        //maximum from the hashmap
        int y=Collections.max(m.entrySet(), Map.Entry.comparingByValue()).getValue();
        // String y=Collections.max(m.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(y);


    }
}
