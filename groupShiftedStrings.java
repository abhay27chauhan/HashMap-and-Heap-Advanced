import java.util.HashMap;
import java.util.ArrayList;
class groupShiftedStrings{

    public static String getStringCode(String s){
        String ans = "";
        for(int i=1; i<s.length(); i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            int diff = curr-prev;
            if(diff < 0){
                diff += 26;
            }

            ans += diff + "#";
        }

        ans += ".";
        return ans;
    }

    public static ArrayList<ArrayList<String>> solution(String[] str){
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s: str){
            String stringCode = getStringCode(s);

            if(map.containsKey(stringCode)){
                ArrayList<String> list = map.get(stringCode);
                list.add(s);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(stringCode, list);
            }
        }
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for(ArrayList<String> list: map.values()){
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args){
        String[] str = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};

        System.out.println(solution(str));
    }
}