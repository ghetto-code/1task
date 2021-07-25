
public class Main {
    public static void main(String[] args) {

        int[] y = new int[] {1,3,2};
        int[] x = new int[] {3,2,1};
        int[] z = new int[] {1,7,5,3,9};
        int[] n = new int[] {9,5,3,7,1};
        int[] t = new int[] {1,4,3,2,5};

        System.out.println(Level1.Football(x,x.length));
        System.out.println(Level1.Football(y,y.length));
        System.out.println(Level1.Football(z,z.length));
        System.out.println(Level1.Football(n,n.length));
        System.out.println(Level1.Football(t,t.length));

    }
}

