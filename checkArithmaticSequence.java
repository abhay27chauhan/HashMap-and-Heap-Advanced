import java.util.HashSet;
class checkArithmaticSequence{

    public static boolean solution(int[] arr){
        if(arr.length <= 1){
            return true;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int val: arr){
            max = Math.max(max, val);
            min = Math.min(min, val);
            set.add(val);
        }

        int d = (max-min)/(arr.length-1);
        for(int i=0; i<arr.length; i++){
            int l = min + i*d;
            if(set.contains(l) == false){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = {17,9,5,29,1,25,13,37,21,33};
        System.out.println(solution(arr));
    }
}