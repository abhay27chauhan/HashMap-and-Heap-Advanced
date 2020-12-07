import java.util.HashMap;
class PairsWithGivenSumInTwoSortedMatrices{

    public static void solution( int[][] a,  int[][] b, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                map.put(a[i][j], map.getOrDefault(a[i][j], 0) +1);
            }
        }

        int count = 0;
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[0].length; j++){
                if(map.containsKey(k-b[i][j])){
                    count += map.get(k-b[i][j]);
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args){
        int[][] a = {{1, 5, 6},
                     {8, 10, 11},
                     {15, 16, 18}
                    };
        int[][] b = {{2, 4, 7},
                     {9, 10, 12},
                     {13, 16, 20}
                    };

        int k = 21;

        solution(a, b, k);
    }
}