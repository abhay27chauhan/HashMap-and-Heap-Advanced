import java.util.HashMap;
class largestSubArrayWith0Sum{

    static int maxSize = Integer.MIN_VALUE;
    public static void solution(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int i = -1;
        hm.put(sum, i);

        while(i<arr.length-1){
            i++;
            sum += arr[i];
            
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }else{
                int sz = i - hm.get(sum);
                if(sz > maxSize){
                    maxSize = sz;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        solution(arr);
        System.out.println(maxSize);
    }
}