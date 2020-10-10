import java.util.HashMap;
class srcToDestination{

    public static void main(String[] args){
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Chennai", "Banglore");
        hm.put("Bombay", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");

        HashMap<String, Boolean> psp = new HashMap<>();
        for(String src: hm.keySet()){
            String dest = hm.get(src);

            psp.put(dest, false);
            if(psp.containsKey(src) == false){
                psp.put(src, true);
            }
        }

        String src = "";
        for(String pot: psp.keySet()){
            if(psp.get(pot) == true){
                src = pot;
            }
        }

        while(true){
            if(hm.containsKey(src)){
                System.out.print(src + " -> ");
                src = hm.get(src);
            }else{
                System.out.print(src + " .");
                break;
            }
        }

        System.out.println();
    }
}