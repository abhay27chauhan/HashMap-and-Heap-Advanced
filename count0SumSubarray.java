import java.util.HashMap;
class count0SumSubarray{

    static int count = 0;
    public static void solution(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int i = -1;
        hm.put(sum, 1);

        while(i<arr.length-1){
            i++;
            sum += arr[i];

            if(hm.containsKey(sum)){
                count += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            }else{
                hm.put(sum, 1);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        solution(arr);
        System.out.println(count);
    }
}