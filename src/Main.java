
public class Main {
    public static void main(String[] args) {
    int [] message = new int[]{1234,1777};
    int [] x = Level1.UFO(message.length, message, false);
    for(int z : x){
        System.out.println(z);
    }

    }
}

