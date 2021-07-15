
public class Main {
    public static void main(String[] args) {
        String [] matrix = new String[] {"123456", "234567", "345678", "456789"};
        int M = matrix.length;
        int N = matrix[0].length();
        int T = 2;
        Level1.MatrixTurn(matrix, M,N, T);
        for (String x : matrix) {
            System.out.println(x);
        }
    }
}

