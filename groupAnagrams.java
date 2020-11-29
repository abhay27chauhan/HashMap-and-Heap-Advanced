import java.util.HashMap;
import java.util.ArrayList;
class groupAnagrams{

    public static ArrayList<ArrayList<String>> solution(String[] str){
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

        for(String s: str){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }

            if(bmap.containsKey(map)){
                ArrayList<String> list = bmap.get(map);
                list.add(s);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                bmap.put(map, list);
            }
        }

        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for(ArrayList<String> list: bmap.values()){
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args){
        String[] str = {"pepcoding", "codingpep", "pepper", "rapper", "repepp"};

        ArrayList<ArrayList<String>> lists = solution(str);
        System.out.println(lists);
    }
}