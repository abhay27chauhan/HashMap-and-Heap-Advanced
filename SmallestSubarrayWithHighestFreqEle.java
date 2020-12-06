import java.util.HashMap;
class SmallestSubarrayWithHighestFreqEle{

    public static void solution(int[] arr){
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();

        int hf = 0;
        int si = 0;
        int ei = 0;
        int len = 0;

        for(int i=0; i<arr.length; i++){
            if(fmap.containsKey(arr[i])){
                fmap.put(arr[i], fmap.get(arr[i]) + 1);
            }else{
                fmap.put(arr[i], 1);
                smap.put(arr[i], i);
            }

            if(fmap.get(arr[i]) > hf){
                hf = fmap.get(arr[i]);
                si = smap.get(arr[i]);
                ei = i;
                len = ei - si + 1;
            }else if((fmap.get(arr[i]) == hf) && (i-smap.get(arr[i]) + 1) < len){
                hf = fmap.get(arr[i]);
                si = smap.get(arr[i]);
                ei = i;
                len = ei - si + 1;
            }
        }

        System.out.println(arr[si]);
        System.out.println(si);
        System.out.println(ei);
    }

    public static void main(String[] args){
        int[] arr = {4, 1, 1, 2, 2, 1, 3, 3};
        solution(arr);
    }
}