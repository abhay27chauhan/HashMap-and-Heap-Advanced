import java.util.HashMap;
class rabbitsInAForest{

    public static int solution(int[] arr){
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for(int key: map.keySet()){
            int gs = key + 1;
            int reportee = map.get(key);
            int mul = (int)(Math.ceil(reportee*(1.0)/gs*(1.0)));
            ans += mul*gs;
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {4,1,3,2,3,2,3,4,3,2,3,4,2,4,3,4,3,4,1,4,2,2,4,4,0,0,1};

        System.out.println(solution(arr));
    }
}