import java.util.HashSet;
class pairsWithEqualSum{

    public static boolean solution(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    return true;
                }else{
                    set.add(sum);
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = {2,9,3,5,8,6,4};
        System.out.println(solution(arr));
    }
}