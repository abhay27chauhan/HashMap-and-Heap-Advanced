import java.util.HashMap;
class countOfSubarraysWithEqual0s1sN2s{

    public static int solution(int[] arr){
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        String key = (c1-c0) + "#" + (c2-c0);
        map.put(key, 1);
        int i = -1;

        while(i<arr.length-1){
            i++;
            if(arr[i] == 0){
                c0++;
            }else if(arr[i] == 1){
                c1++;
            }else{
                c2++;
            }

            key = (c1-c0) + "#" + (c2-c0);

            if(map.containsKey(key)){
                ans += map.get(key);
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        } 

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,2,0,1,0};
        System.out.println(solution(arr));
    }
}