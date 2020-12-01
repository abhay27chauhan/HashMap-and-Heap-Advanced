import java.util.HashMap;
class LongestSubarrayWithEqual0s1sN2s{

    public static int solution(int[] arr){
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int countz = 0;
        int counto = 0;
        int countt = 0;
        int c0m1 = counto-countz;
        int c2m1 = countt-countz;
        String key = c0m1 + "#" + c2m1;
        int i = -1;
        map.put(key, i);

        while(i<arr.length-1){
            i++;
            if(arr[i] == 0){
                countz++;
            }else if(arr[i] == 1){
                counto++;
            }else{
                countt++;
            }
            c0m1 = counto-countz;
            c2m1 = countt-countz;
            key = c0m1 + "#" + c2m1;

            if(map.containsKey(key)){
                int len = i-map.get(key);
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(key, i);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,2,0,1,0};
        System.out.println(solution(arr));
    }
}