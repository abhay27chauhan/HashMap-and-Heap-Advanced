import java.util.HashMap;
class KAnagrams{

    public static boolean solution(String str, String str2, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        for(char ch: str2.toCharArray()){
           if(map.getOrDefault(ch, 0) > 0){
               map.put(ch, map.get(ch) -1);
           }
        }

        int count = 0;
        for(char ch: map.keySet()){
            count += map.get(ch);
        }

        if(count>k){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        String str= "fodr";
        String str2= "gork";
        int k = 2;

        System.out.println(solution(str, str2, k));
    }
}