import java.util.HashSet;
class MaxLengthSubarrayWithContiguousElements{

    public static int solution(int[] arr){
        int ans = 0;

        for(int i=0; i<arr.length-1; i++){
            int max = arr[i];
            int min = arr[i];

            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for(int j=i+1; j<arr.length; j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);

                if(max-min == (j-i)){
                    int len = j-i+1;
                    if(len > ans){
                        ans = len;
                    }
                }

                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr ={9,2,7,5,6,23,24,22,23,19,17,16,18,39,0};

        System.out.println(solution(arr));
    }
}