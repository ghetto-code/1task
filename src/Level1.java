public class Level1 {
    public static String Keymaker(int k) {
        int [] doors = new int[k];
        for (int i = 0; i < doors.length; i ++) {
            for (int j = i; j < doors.length; j += i+1) {
                if(doors[j] == 0){
                    doors[j] = 1;
                } else {
                    doors[j] = 0;
                }
            }
        }
        String result = "";
        for (int i = 0; i < doors.length; i++) {
            result+=doors[i];
        }

        return result;
    }
}
