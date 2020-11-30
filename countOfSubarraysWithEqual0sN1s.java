import java.util.HashMap;
class countOfSubarraysWithEqual0sN1s{

    public static int solution(int[] arr){
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int i = -1;
        map.put(sum, 1);

        while(i<arr.length-1){
            i++;
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                ans += map.get(sum);
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0,1,1,0,1,1};
        System.out.println(solution(arr));
    }
}