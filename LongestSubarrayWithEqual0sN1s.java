import java.util.HashMap;
class LongestSubarrayWithEqual0sN1s{

    public static int solution(int[] arr){
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int i = -1;
        map.put(sum, i);

        while(i<arr.length-1){
            i++;
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                int len = i-map.get(sum);
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(sum, i);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0,1,1,0,1,1};
        int ans = solution(arr);
        System.out.println(ans);
    }
}