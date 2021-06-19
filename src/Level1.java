public class Level1 {
    public static int[] UFO(int N, int[] data, boolean octal) {
        int system;
        if (octal) {
            system = 8;
        } else {
            system = 16;
        }
        int[] decimal = new int[N-1];
        int idx = 0;
        for (int x : data) {
            String currentInt = String.valueOf(x);
            char[] currentIntArrChars = currentInt.toCharArray();
            int result = 0;
            int pow = currentIntArrChars.length - 1;
            for (int i = 0; i < currentIntArrChars.length; i++) {
                String z = String.valueOf(currentIntArrChars[i]);
                int c = Integer.parseInt(z);

                result += c * Math.pow(system, pow);
                pow--;
            }
            decimal[idx] = result;
            idx++;
        }
        return decimal;
    }
}