import java.math.BigInteger;

public class GCD {
    BigInteger d;
    BigInteger x;
    BigInteger y;

    public GCD() {

    }

    public GCD(BigInteger d, BigInteger x, BigInteger y) {
        this.d = d;
        this.x = x;
        this.y = y;
    }

    public static GCD findGCD(BigInteger a, BigInteger b)
    {
        GCD gcd = new GCD(a, BigInteger.ONE, BigInteger.ZERO);

        if (b == BigInteger.ZERO) {
            return gcd;
        }

        GCD gcd2 = findGCD(b, a.mod(b));
        gcd = new GCD();

        gcd.d = gcd2.d;
        gcd.x = gcd2.y;
        gcd.y = gcd2.x.subtract(a.divide(b).multiply(gcd2.y));

        return gcd;
    }
}
