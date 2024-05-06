package algorithm;

import java.math.BigInteger;

public class LargeBinary {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("9620680364645634331845386726262609206982068206820281340810801411111793759");
        String s = num.toString(2);
        System.out.println(s);
        for (int i = 2; i <= 999; i++) {
            String str1 = num.mod(new BigInteger(Integer.toString(i))).toString();
            String str2 = "" + mod(s, i);
            if (!str1.equals(str2)) {
                System.out.println(i + ":t" + str1 + "t" + str2);
            }
        }
    }

    private static int mod(String num, int k) {
        final long maxValModK = (1L << 62) % k;
        int times = 0;
        int pos = num.length() - 1;
        int res = 0;
        while (pos >= 0) {
            long factor = 1;
            long x = 0;
            while (pos >= 0 && factor != 1L << 62) {
                if (num.charAt(pos--) == '1') {
                    x |= factor;
                }
                factor <<= 1;
            }
            x %= k;
            for (int i = 0; i < times; i++) {
                x = (x * maxValModK) % k;
            }
            res += x;
            res %= k;
            times++;
        }
        return res;
    }
}
