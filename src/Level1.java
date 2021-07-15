public class Level1 {
    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {
        char[][] mtx = new char[M][N];
        for (int i = 0; i < Matrix.length; i ++) {
            for (int j = 0; j < Matrix[i].length(); j ++) {
                mtx[i][j] = Matrix[i].charAt(j);
            }
        }

        for (int time = 0; time < T; time ++) {
            for (int i = 0; i < mtx.length; i++) {
                char swap = mtx[i][0];
                for (int j = 0; j < mtx[i].length - 1; j++) {
                    mtx[i][j] = mtx[i][j + 1];
                }
                mtx[i][mtx[i].length - 1] = swap;
            }
        }

        for (int i = 0; i < mtx.length; i ++) {
            String x = "";
            for (int j = 0; j < mtx[i].length; j ++) {
                x += String.valueOf(mtx[i][j]);
            }
            Matrix[i] = x;
        }
    }
}
