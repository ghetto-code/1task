
public class Main {
    public static void main(String[] args) {
        String villageMap = "axxb6===4xaf5===eee5";
        System.out.println(Level1.white_walkers(villageMap));

        String villageMap2 = "5==ooooooo=5=5";
        System.out.println(Level1.white_walkers(villageMap2));

        String villageMap3 = "abc=7==hdjs=3gg1=======5";
        System.out.println(Level1.white_walkers(villageMap3));

        String villageMap4 = "aaS=8";
        System.out.println(Level1.white_walkers(villageMap4));

        String villageMap5 = "9===1===9===1===9";
        System.out.println(Level1.white_walkers(villageMap5));
        String villageMap6 = "";
        System.out.println(Level1.white_walkers(villageMap6));
    }
}

