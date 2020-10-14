import java.util.HashMap;
class arrayPairsAreDivisibleByK{

    public static void solution(int[] arr, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int val: arr){
            int rem = val%k;

            int of = hm.getOrDefault(rem, 0);
            hm.put(rem, of + 1);
        }

        for(int rem: hm.keySet()){
            if(rem == 0){
                int f = hm.get(rem);
                if(f%2 == 1){
                    System.out.println(false);
                    return;
                }
            }else if(2*rem == k){
                int f = hm.get(rem);
                if(f%2 == 1){
                    System.out.println(false);
                    return;
                }
            }else{
                int f1 = hm.get(rem);
                int f2 = hm.getOrDefault(k-rem, 0);

                if(f1 != f2){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static void main(String[] args){
        int[] arr = {77,22,56,11,20,45,34,78,29,23,55,30};
        int k =10;
        solution(arr, k);
    }
}