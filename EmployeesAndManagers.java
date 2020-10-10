import java.util.HashMap;
import java.util.HashSet;
class EmployeesAndManagers{

    public static int getSize(String man, HashMap<String, HashSet<String>> tree, HashMap<String, Integer> esz){
        if(!tree.containsKey(man)){
            esz.put(man, 0);
            return 1;
        }
        int sz = 0;

        for(String emp: tree.get(man)){
            int cz = getSize(emp, tree, esz);
            sz += cz;
        }

        esz.put(man, sz);
        sz += 1;
        return sz;
    }

    public static void solution(HashMap<String, String> map){
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";

        for(String emp: map.keySet()){
            String man = map.get(emp);

            if(emp == man){
                ceo = emp;
            }else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);
                }else{
                    HashSet<String> emps =new HashSet<>();
                    emps.add(emp);
                    tree.put(man, emps);
                }
            }
        }

        HashMap<String, Integer> size = new HashMap<>(); 
        getSize(ceo, tree, size);

        for(String man: size.keySet()){
            System.out.println(man + " -> " + size.get(man));
        }
    }

    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "C");
        map.put("B", "C");
        map.put("C", "F");
        map.put("D", "E");
        map.put("E", "F");
        map.put("F", "F");

        solution(map);
    }
}