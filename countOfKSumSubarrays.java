import java.util.HashMap;
class countOfKSumSubarrays{

    public static int solution(int[] arr, int k){
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int i=-1;
        map.put(sum, 1);

        while(i<arr.length-1){
            i++;
            sum += arr[i];
            int rsum = Math.abs(sum-k);

            if(map.containsKey(rsum)){
                ans += map.get(rsum);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1};
        int k = 3;

        System.out.println(solution(arr, k));
    }
}