import java.util.HashSet;
import java.util.ArrayList;
class TaskCompletion{

    public static void solution(int[] arr, int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        int count = 0;
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(set.contains(i) == false){
                if(count%2 == 0){
                    p1.add(i);
                }else{
                    p2.add(i);
                }
                count++;
            }
        }

        System.out.println(p1);
        System.out.println(p2);
    }

    public static void main(String[] args){
        int tt = 15; // total tasks to 5 students;
        int tc5s = 6; // tasks completed by 3 students;
        int[] arr = {2, 5, 6, 7, 9, 4}; // tasks completed by 3 students;

        // find what tasks completed by which of the 2 students, if they complete alternative tasks;

        solution(arr, tt);
    }
}