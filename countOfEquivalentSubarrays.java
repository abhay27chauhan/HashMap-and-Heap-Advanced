import java.util.HashMap;
import java.util.HashSet;
class countOfEquivalentSubarrays{

    public static int solution(int[] arr){
        int ans = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int val: arr){
            set.add(val);
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;

        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i<arr.length-1 && map.size() < set.size()){
                i++;

                int val = arr[i];
                map.put(val, map.getOrDefault(val, 0)+1);

                flag1 = true;
            }

            while(j<i && map.size() == set.size()){

                ans += arr.length - i;

                j++;
                int val = arr[j];
                
                if(map.get(val) == 1){
                    map.remove(val);
                }else{
                    map.put(val, map.get(val) -1);
                }

                flag2 = true;
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {2,1,3,2,3};

        int ans = solution(arr);
        System.out.println(ans);
    }
}