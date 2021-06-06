public class Level1___ {
    public static int [] MadMax(int N, int [] Tele) {
        int[] z = new int[Tele.length];
        for (int i = 0; i < Tele.length; i ++) {
            for(int j = 0; j < Tele.length - 1; j ++){
                if (Tele[j] > Tele[j + 1]){
                    int x = Tele[j];
                    Tele[j] = Tele[j + 1];
                    Tele[j + 1] = x;
                }
            }

        }
        for (int i = N/2+1; i < Tele.length; i ++) {
            for(int j = N/2; j < Tele.length - 1; j ++){
                if (Tele[j] < Tele[j + 1]){
                    int x = Tele[j];
                    Tele[j] = Tele[j + 1];
                    Tele[j + 1] = x;
                }
            }
        }

        return Tele;
    }

}
