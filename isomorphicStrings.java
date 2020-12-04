import java.util.HashMap;
import java.util.HashSet;
class isomorphicStrings{

    public static boolean solution(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();

        for(int i=0; i<a.length(); i++){
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);
            if(map1.containsKey(ch1)){
                char mapWith = map1.get(ch1);
                if(ch2 != mapWith){
                    return false;
                }
            }else{
                if(map2.containsKey(ch2)){
                    return false;
                }
                map1.put(ch1, ch2);
                map2.put(ch2, true);
            }
        }

        return true;
    }

    public static void main(String[] args){
        String a = "pepcoding";
        String b = "sosherlok";

        System.out.println(solution(a, b));
    }
}