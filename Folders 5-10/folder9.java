import java.util.*;

public class folder9 {
    public static void main(String args[]) {

        // HASHSET

        // Gyaan on Hashset
        // add remove and contain function is O(1) on avg;
        // size and isempty O(1)
        // HashSet<String> h = new HashSet<String>();
        // h.add("gfg");
        // h.add("gfg1");
        // h.add("gfg2");
        // System.out.println(h.size());
        // System.out.println(h.isEmpty());
        // // h.clear();
        // // h.remove("gfg2");
        // // h.remove("gfg1");
        // // h.remove("gfg");
        // System.out.println(h.isEmpty());
        // System.out.println(h.size());

        // Iterator<String> it = h.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next() + " ");
        // }
        // {

        // }
        // for(String i:h){
        // System.out.println(i);
        // }

        // HASHMAP

        // put containeskey remove O(1) avg
        // get O(1)
        // size isempty O(1) worst case
        // HashMap<String,Integer> m=new HashMap<String,Integer>();
        // m.put("abc", 123);
        // m.put("adc", 223);
        // m.put("aec", 243);
        // System.out.println(m.size());
        // if(m.containsValue(123)){
        // System.out.println("yes");
        // }
        // else{
        // System.out.println("no");
        // }
        // System.out.println(m.get("aec"));
        // System.out.println(m);
        // for(Map.Entry<String, Integer> e:m.entrySet() ){
        // System.out.println(e.getKey()+" "+e.getValue());
        // }

        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();

        int arr[] = { 10, 12, 10, 15, 10, 20, 12, 12 };
        for (int i :arr) {
            m.put(i,m.getOrDefault(i, 0) +1);
        }
        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }

        // HashSet<Integer> h=new HashSet<>();
        // int preSum=0;
        // int arr[]={2,1,-3,1,1};
        // boolean ans=false;

        // for(int i=0;i<arr.length;i++){
        //     preSum+=arr[i];
        //     if(h.contains(preSum)){
        //         ans= true;
        //     }

        //     if(preSum==0){  
        //         ans=true;
        //     }

        //     h.add(preSum);
        // }
        // System.out.println(ans);
    }
}