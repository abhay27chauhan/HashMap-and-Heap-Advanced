import java.util.HashMap;
import java.util.ArrayList;
class FindAnagramMappings{

    public static class Pair {
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static void display(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }System.out.println();
    }

    public static int[] solution(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length];
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i=0; i<arr2.length; i++){
            int val = arr2[i];
            if(map.containsKey(val)){
                Pair p = map.get(val);
                p.list.add(i);
            }else{
                Pair p = new Pair();
                p.list.add(i);
                map.put(val, p);
            }
        }

        for(int i=0; i<arr1.length; i++){
            Pair p = map.get(arr1[i]);
            int val = p.list.get(p.idx);
            ans[i] = val;
            p.idx++;
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5,2};
        int[] arr2 = {4,3,2,1,5,2};

        int[] ans = solution(arr1, arr2);
        display(ans);
    }
}