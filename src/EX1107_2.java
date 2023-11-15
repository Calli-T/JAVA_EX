import java.util.*;

class Location {
    private double lat;
    private double lon;

    Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String toString() {
        return "(" + this.lat + ", " + this.lon + ")";
    }
}

public class EX1107_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Location> hm = new HashMap<>();

        System.out.println("Submit City, Latitude, Longitude.");

        for (int i = 0; i < 4; i++) {
            String city = scanner.nextLine();// = scanner.next();
            StringTokenizer st = new StringTokenizer(city, ", ");
            String name = st.nextToken();
            double lat = Double.parseDouble(st.nextToken().trim());
            double lon = Double.parseDouble(st.nextToken().trim());

            hm.put(name, new Location(lat, lon));
        }

        Set<String> keys = hm.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()){
            String name = it.next();
            System.out.println(name + " " + hm.get(name));
        }

        while(true){
            String name = scanner.next();
            if(name.equals("exit")) break;

            System.out.println(name + " " + hm.get(name));
        }

        scanner.close();
    }
}
