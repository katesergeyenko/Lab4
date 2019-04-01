import java.math.BigInteger;
import java.util.Scanner;

public class Lab4 {
    public static BigInteger generatePhi(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    }

    public static BigInteger generateD(BigInteger p, BigInteger q, BigInteger e) {
        BigInteger phi = generatePhi(p, q);
        return GCD.findGCD(e, phi).x;
    }

    public static BigInteger encrypt(BigInteger x, BigInteger e, BigInteger n) {
        return x.modPow(e, n);
    }

    public static BigInteger decrypt(BigInteger y, BigInteger d, BigInteger n) {
        return y.modPow(d, n);
    }

    public static void main(String[] args) {
            /*
            BigInteger p = new BigInteger("578569278720973");
            BigInteger q = new BigInteger("976534805568533");
            BigInteger e = new BigInteger("235108486320061234453015373083");
            BigInteger x1 = new BigInteger("402700874043636335474593885222");
            BigInteger y2 = new BigInteger("416593343738152120120255791792");
            BigInteger n = p.multiply(q);

            System.out.println("n = " + n);
            BigInteger d = generateD(p, q, e);
            System.out.println("d = " + d);
            BigInteger y1 = encrypt(x1, e, n);
            System.out.println("y1 = " + y1);
            BigInteger x = decrypt(y1, d, n);
            System.out.println("x = " + x);

            BigInteger x2 = decrypt(y2, d, n);
            System.out.println("x2 = " + x2);
            BigInteger y = encrypt(x2, e, n);
            System.out.println("y = " + y);
            */

        BigInteger p;
        BigInteger q;
        BigInteger e;
        BigInteger d;
        BigInteger n;
        BigInteger x;
        BigInteger y;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Input p: ");
        p = scanner.nextBigInteger();
        System.out.println("Input q: ");
        q = scanner.nextBigInteger();
        System.out.println("Input e: ");
        e = scanner.nextBigInteger();
        n = p.multiply(q);
        d = generateD(p, q, e);

        System.out.println("(E)ncrypt\n(D)ecrypt\nPress x to exit\n");
        char command = ' ';

        while (command != 'x') {
            command = scanner.next().toLowerCase().charAt(0);
            if (command == 'e') {
                System.out.println("Input x: ");
                x = scanner.nextBigInteger();
                y = encrypt(x, e, n);
                System.out.println(y);
            } else if (command == 'd') {
                System.out.println("Input y: ");
                y = scanner.nextBigInteger();
                x = decrypt(y, d, n);
                System.out.println(x);
            }
        }
    }
}
