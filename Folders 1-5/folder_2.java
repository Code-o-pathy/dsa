//10 all divisors
// naive solutions
// public class folder_2{
//     public static void main(String args[]){
//         int n=25;
//         for(int i=1;i<=n;i++){
//             if(n%i==0){
//                 System.out.println(i);
//             }
//         }
//     }
// }
//optimized acc to me
// public class folder_2{
//     public static void main(String args[]){
//         int n=25;
//         for(int i=1;i*i<=n;i++){
//             if(n%i==0){
//                 System.out.println(i);
//                 if(i!=n/i){
//                     System.out.println(n/i);                    
//                 }
//             }
//         }
//     }
// }
// optimized and sorted
// public class folder_2{
//     public static void main(String args[]){
//         int n=49;
//         int k=(int) Math.sqrt(n);
//         int count=0;
//         for(int i=1;i*i<n;i++){
//             if(n%i==0){
//                 count++;
//                 System.out.println(i);
//             }
//         }
//         for(int i=k;i>=1;i--){
//             if(n%i==0){
//                 count++;
//                 System.out.println((int)(n/i));

//             }
//         }
//         if(count<=2){
//             System.out.println("the no is prime");
//         }
//     }
// }

// folder 2 video 11 Sieve of Eratosthenes
//bigger implementation
// import java.util.Arrays;

// public class folder_2 {
//this isprime function not needed in sieve earstothenes algo..
// public static boolean isPrime(int n) {
//     if (n < 2) {
//         return false;
//     }
//     if (n == 2 || n == 3) {
//         return true;
//     }
//     if (n % 2 == 0 || n % 3 == 0) {
//         return false;
//     }
//     for (int i = 5; i * i <= n; i += 6) {
//         if (n % (i) == 0 || n % (i + 2) == 0) {
//             return false;
//         }
//     }
//     return true;
// }

//     public static void Sieve(int n) {
//         Boolean[] arr = new Boolean[n + 1];
//         Arrays.fill(arr,true);
//         for(int i=2;i*i<=n;i++){
//             if(arr[i]){
//                 for(int j=2*i;j<=n;j+=i){
//                     arr[j]=false;
//                 }
//             }
//         }

//         for(int i=2;i<=n;i++){
//             if(arr[i]==true){
//                 System.out.println(i);
//             }
//         }

//     }

//     public static void main(String args[]) {
//         int n = 11;
//         Sieve(n);
//     }
// }
// optimized by replacing 2*i for j loop to i*i

// import java.util.Arrays;

// public class folder_2 {
//     public static void main(String args[]) {
//         int n=11;
//         boolean[] arr=new boolean[n+1];
//         Arrays.fill(arr, true);
//         for(int i=2;i<=n;i++){
//             if(arr[i]){
//                 System.out.println(i);
//                 for(int j=i*i;j<=n;j=j+i){
//                     arr[j]=false;
//                 }
//             }
//         }

//     }
// }
//video 12 power
// what i came up with 
// public class folder_2 {
//     public static int power(int n,int m){
//         int solution=1;
//         for(int i=0;i<m;i++){
//             solution*=n;
//         }
//         return solution;
//     }

//     public static void main(String args[]){
//         int n=2;
//         int m=4;
//         int m=power(n,m);
//         System.out.println(m);
//     }
// }
// recursive solution
// public class folder_2 {
//     public static int power(int n,int m ){
//         if(m==0){
//             return 1;
//         }
//         int solution=power(n,m/2);
//          solution=solution*solution;
//         if(m%2==0){
//             return solution;
//         }
//         return solution*n;
//     }

//     public static void main(String args[]){
//         int n=3;
//         int m=3;
//        int ans= power(n,m);
//        System.out.println(ans);

//     }
// }
// iterative solution
// public class folder_2 {
//     public static int power(int n,int m){
//         int res=1;
//         while(m>0){
//             if(m%2!=0){//power is odd
//                 res=res*n;
//             }
//             n*=n; /*no. ko usi se multiply krdo */
//             m/=2;/*power aadhi kr do */

//         }
//         return res;
//     }

//     public static void main(String args[]){
//         int n=4;
//         int m=5;
//         int res=power(n,m);
//         System.out.println(res);
//     }
// }
//Revision
//f2v1,v2
// public class folder_2 {
//     public static int noOfDigits(int n) {
//         if (n == 0) {
//             return 0;
//         }
//         return 1 + noOfDigits(n / 10);
//     }

//     public static void noOfDigits2(int n) {
//         int count=0;
//         while (n!=0) {
//             count++;
//             n/=10;
//         }
//         System.out.println(count);
//     }
//     public static int noOfDigits3(int n) {
//         return 1+(int)Math.floor(Math.log10(n));
//     }

//     public static void main(String args[]) {

//         int n = 23492481;
//         int c = noOfDigits(n);
//         noOfDigits2(n);
//        int d= noOfDigits3(n);
//         System.out.println(c);
//         System.out.println(d);
//     }
// }
//f1v3;
// public class folder_2 {
//     public static boolean isPallindrom(int n){
//         int rev=0;
//         int corr=n;

//         int lastdigit;
//         while(n>0){
//             lastdigit=n%10;
//             rev=rev*10+lastdigit;
//             n=n/10;

//         }
//         if(rev==corr){
//             return true;
//         }
//     return false;

//     }

//     public static void main(String args[]){
//     int n=98789;
//     boolean n=isPallindrom(n);
//     System.out.println(n);
//     }
// }

//f1v4;
// public class folder_2 {
//     public static int fact(int n){
//       if(n==0){
//         return 1;
//       }

//         return n*fact(n-1);
//     }
//     public static int fact2(int n){
//         int fact=1;
//         for(int i=1;i<=n;i++){
//             fact*=i;
//         }

//         return fact;
//     }

//     public static void main(String args[]){
//         int n=7;
//         int d=fact(n);
//         int e=fact2(n);
//         System.out.println(d);
//         System.out.println(e);

//     }
// }
//f1v5 trailing zeroes
// public class folder_2 {
//     public static int fact(int n) {
//         if (n == 0) {
//             return 1;
//         }

//         return n * fact(n - 1);
//     }

//     public static int trailingZero(int n) {
//         int count = 0;
//         int ans=fact(n);
//         System.out.println(ans);
//         while (ans%10==0) {
//             count++;
//             ans/=10;
//         }
//         return count;
//     }
//     public static int trailingZero2(int n){
//         // int count=(int)Math.floor(n/5)+(int)(Math.floor(n/25))+(int)(Math.floor(n/125));
//         int count=0;
//         for(int i=5;i<=n;i=i*5){
//             count+=n/i;
//         }

//         return count;
//     }

//     public static void main(String agrs[]) {
//         int n = 251;
//         int x = trailingZero2(n);
//         System.out.println(x);
//     }
// }
//f2v6
// public class folder_2 {

//     public static int gcd(int n, int m) {
//     int p = Math.min(n, m);
//     for (int i = p; i >= 1; i--) {
//     if (n % i == 0 && m % i == 0) {
//     return i;
//     }

//     }
//     return -1;

//     }

//     public static int gcd2(int n, int m) {
//         while (n != m) {
//             if (n > m) {
//                 n = n - m;
//                 // System.out.println(n);
//             } else {
//                 m = m - n;
//             }
//         }

//         return n;
//     }
// public static int gcd3(int n,int m){
//     if(m==0){
//         return n;
//     }
//     return gcd3(m,n%m);
// }
//     public static void main(String args[]) {
//         int n = 12;
//         int m = 15;
//         int d = gcd(n, m);
//         int e = gcd2(n, m);
//         int f = gcd3(n, m);
//         System.out.println(d);
//         System.out.println(e);
//         System.out.println(f);

//     }
// }
// f2v8 most optimized way to check whether prime or not

// public class folder_2 {
//     public static boolean isprime(int n){
//         if(n<2){
//             return false;
//         }
//         if(n==2 || n==3){
//             return true;
//         }
//         if(n%2==0 || n%3==0){
//             return false;
//         }
//         for(int i=5;i*i<=n;i=i+6){
//             if(n%i==0 || n%(i+2)==0){
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String args[]){
//         int n=17;
//         isprime(n);
//         System.out.println(isprime(n));
//     }
// }
//f2v9 &v10 prime factors & all divisors
// public class folder_2 {

//     public static boolean isprime(int n){
//         if(n<2){
//             return false;
//         }
//         if(n==2 || n==3){
//             return true;
//         }
//         if(n%2==0 || n%3==0){
//             return false;
//         }
//         for(int i=5;i*i<=n;i=i+6){
//             if(n%i==0 || n%(i+2)==0){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public static void primeFact(int n){//basic aim is to start a loop and if its prime check if it divides if yes print i then check if its multiples divide it too and then how many times they divide it print the i
//         for(int i=2;i*i<=n;i++){
//             if(isprime(i)){
//                 int x=i;
//                 while(n%x==0){
//                     System.out.println(i);
//                     x=x*i;
//                 }
//             }
//         }
//     }
//     public static void primeFact2(int n){//rather than reaching the large no.s divide them by every prime factor of its that is found...
//         int x=n;
//         for(int i=2;i*i<=n;i++){
//             if(isprime(i)){
//                 while(x%i==0){
//                     System.out.println(i);
//                     x/=i;
//                 }
//             }
//         }
//         if(x>1){
//             System.out.println(x);
//         }
//     }
//     public static void primeFact3(int n){//rather than reaching the large no.s divide them by every prime factor of its that is found...
//         if(n<=1){
//             return;
//         }
//         while(n%2==0){
//             System.out.println(2);
//             n/=2;//n=n/2;

//         }
//         while(n%3==0){
//             System.out.println(3);
//             n/=3;//n=n/2;
//         }
//         for(int i=5;i*i<=n;i+=6){
//             while(n%i==0){
//                 System.out.println(i);
//                 n/=i;

//             }
//             while(n%(i+2)==0){
//                 System.out.println((i+2));
//                 n/=(i+2);

//             }
//         }
//         if(n>3){
//             System.out.println(n);
//         }
//     }
//     public static void allDiv(int n){

//         for(int i=1;i*i<n;i++){
//             if(n%i==0){
//                 System.out.println(i);

//                 // n/=i;
//             }
//         }
//         int p=(int)Math.sqrt(n);
//         for(int i=p;i>=1;i--){
//             if(n%i==0){
//                 System.out.println(n/i);

//                 // n/=i;
//             }
//         }
//     }
//     public static void main(String args[]){
//         int n=48;
//         // primeFact3(n);
//         allDiv(n);
//     }

// }
// f2v11 sieve of erastosthenes

// import java.util.Arrays;

// public class folder_2 {
//     public static void sieve(int n) {
//         boolean[] arr = new boolean[n + 1];
//         Arrays.fill(arr, true);
//         for (int i = 2; i <= n; i++) {
//             if (arr[i]) {
//                 System.out.println(i);
//             }

//         for(int j=i*i;j<=n;j=j+i){
//             arr[j]=false;
//         }
//         }
//     }

//     public static boolean isprime(int n) {
//         if (n < 2) {
//             return false;
//         }
//         if (n == 2 || n == 3) {
//             return true;
//         }
//         if (n % 2 == 0 || n % 3 == 0) {
//             return false;
//         }
//         for (int i = 5; i * i <= n; i = i + 6) {
//             if (n % i == 0 || n % (i + 2) == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String args[]) {
//         int n = 14;
//         sieve(n);
//     }
// }

// f2v12 power
public class folder_2 {
public static int pow(int n,int m){
    int sol=1;
    // if(m==0){
    //     return sol;
    // }
    for(int i=0;i<m;i++){
        sol=sol*n;
    }
    return sol;

}
public static int pow2(int n,int m){//recursive soln space comp theta(logn)(height of recursion tree if divided by 2 repeatedly)
    if(m==0){
        return 1;
    }
    int sol=pow2(n,m/2);
    sol=sol*sol;//since halfing the power doubling the sol;
    if(m%2==0){ //even power 
        return sol;
    }
    else{//odd power
        return sol*n;
    }
}
public static int pow3(int n,int m){
    int res=1;
    while(m>0){
        if(m%2!=0){//bit is 1 so multiplying the result with no.
            res=res*n;
        }

        m=m/2;//power halfing
        n=n*n;//sqauring the no.
    }
    return res;
}
    public static void  main(String args[]){
        int n=5;
        int m=4;
        int c=pow3(n,m);
        System.out.println(c);
    }
}