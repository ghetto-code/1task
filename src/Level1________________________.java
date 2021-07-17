public class Level1________________________ {
    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {
        char[][] mtx = new char[M][N];
        for (int i = 0; i < Matrix.length; i ++) {
            for (int j = 0; j < Matrix[i].length(); j ++) {
                mtx[i][j] = Matrix[i].charAt(j);
            }
        }
        int xLen = mtx[0].length;
        int yLen = mtx.length;

        // узнаем количество шагов до центра
        int stepToCenter = Math.min(xLen, yLen) / 2;

        for (int times = 0; times < T; times ++) {
            for (int j = 0; j < stepToCenter; j ++) {
                char rightTopCorner = mtx[j][xLen - j - 1];
                char rightBottomCorner = mtx[yLen - j - 1][xLen - j - 1];
                char leftBottomCorner = mtx[yLen - j - 1][j];

                //top
                for (int x = xLen - j - 1; x > j; x--) {
                    mtx[j][x] = mtx[j][x - 1];
                }

                //right
                for (int y = yLen - j - 1; y > j ; y--) {
                    mtx[y][xLen - j - 1] = mtx[y - 1][xLen - j - 1];
                    if (y - 1 == j) {
                        mtx[j + 1][xLen - j - 1] = rightTopCorner;
                    }
                }

                //bottom
                for (int x = j; x < xLen - j - 1; x ++) {
                    mtx[yLen - j - 1][x] = mtx[yLen - j - 1][x + 1];
                    if (x + 1 == xLen - j - 1) {
                        mtx[yLen - j - 1][xLen - j - 2] = rightBottomCorner;
                    }
                }

                //left
                for (int y = j; y < yLen - j - 1; y ++) {
                    mtx[y][j] = mtx[y + 1][j];
                    if (y + 1 == yLen - j - 1) {
                        mtx[yLen - j - 2][j] = leftBottomCorner;
                    }
                }
            }
        }
        for (int i = 0; i < mtx.length; i ++) {
            Matrix[i] = String.valueOf(mtx[i]);
        }
    }
}
