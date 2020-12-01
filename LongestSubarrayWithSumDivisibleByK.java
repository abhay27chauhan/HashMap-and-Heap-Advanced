import java.util.HashMap;
class LongestSubarrayWithSumDivisibleByK{

    public static int solution(int[] arr, int k){
        int ans  = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        int i = -1;
        map.put(rem, i);

        while(i<arr.length-1){
            i++;
            sum += arr[i];
            rem = sum%k;

            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem)){
                int len = i-map.get(rem);
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(rem, i);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {2,7,6,1,4,5};
        int k = 3;

        System.out.println(solution(arr, k));
    }
}