import java.util.HashMap;
class wordPattern {

    public static boolean solution(String pattern, String[] str){
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                String mapwith = map.get(ch);
                if(mapwith.equals(str[i]) == false){
                    return false;
                }
            }else{
                if(used.containsKey(str[i])){
                    return false;
                }

                map.put(ch, str[i]);
                used.put(str[i], true);
            }
        }

        return true;
    }
    
    public static void main(String[] args){
        String pattern = "abab";
        String[] str = {"pep", "coding", "pep", "coding"};

        System.out.println(solution(pattern, str));
    }
}