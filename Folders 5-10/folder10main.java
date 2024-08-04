public class folder10main {
    public static  boolean isMatch(String s, String p) {
        String star="*";
        boolean ans=true;
        if (((p.indexOf(star))!=-1)) {
            System.out.println((p.indexOf(star)));

            return true;

        }
        if(s.length()!=p.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i)==p.charAt(i) || p.charAt(i) =='?')) {
                System.out.println(s.charAt(i)==p.charAt(i));

                return false;
            }

        }
        return true;
    }
    public static void  main(String args[]){

        //anagram or not
        // String str1="listen";
        // String str2="silent";
        // boolean ans=true;
        // if(str1.length()!=str2.length()){
        //     ans=false;
        // }zzz
        // int arr[]=new int[26];

        // for(int i=0;i<str1.length();i++){
        //     arr[str1.charAt(i)-'a']++; //a is there only to reduce the array size from 256 to 26 cause ascii code of a  is 97;
        //     arr[str2.charAt(i)-'a']--;
        // }

        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]!=0){
        //         ans=false;
        //     }
        // }
        // System.out.println((int)str1.charAt(3)-'a');
        // System.out.println(ans);


        // String str="geeksforgeeks";
        // int arr[]=new int[26];
        // for(int i=0;i<str.length();i++){
        //     arr[str.charAt(i)-'a']++;
        // }
        // for(int i=0;i<str.length();i++){
        //     if(arr[str.charAt(i)-'a']==2){
        //         char ans=str.charAt(i);
        //         System.out.println(ans);
        //     }
        // }
        // String a="ABCD";
        // String b="E";
        // System.out.println(a.indexOf(b));
        // boolean ans=true;

        // String aRot="CDBB";
        // if(a.length()!=aRot.length()){
        //     ans=false;
        //     System.out.println(ans);
        // }
        // else{
        //     System.out.print((a+a).indexOf(aRot)>=0);
        // }
            String s="aaa";
            String p="?aa";

            System.out.println(isMatch(s, p));
        
    }
}
