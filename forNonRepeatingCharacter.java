// find the index of first non-repeating character
import java.util.HashMap;
class forNonRepeatingCharacter{

    public static int solution(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String str = "pepcoding";
        System.out.println(solution(str));
    }
}