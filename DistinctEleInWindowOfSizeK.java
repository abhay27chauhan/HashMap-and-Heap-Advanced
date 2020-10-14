import java.util.HashMap;
import java.util.ArrayList;
class DistinctEleInWindowOfSizeK{

    public static ArrayList<Integer> solution(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int i=0;
        while(i<=k-2){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            i++;
        }

        i--;
        int j=-1;
        while(i<arr.length-1){
            i++;
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            
            list.add(hm.size());
            
            j++;

            int f = hm.get(arr[j]);
            if(f == 1){
                hm.remove(arr[j]);
            }else{
                hm.put(arr[j], f-1);
            }
        }

        return list;
    }

    public static void main(String[] args){
        int[] arr = {2,5,5,6,32,32,4,5,2,2,2,2,3,6};
        int k =4;

        ArrayList<Integer> list = solution(arr, k);
        System.out.println(list);
    }
}