import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
public class SumFct {
	public static BigInteger perimeter(BigInteger n) {
        List<BigInteger> list = new ArrayList<>();

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        list.add(a);
        list.add(b);


        for(int i=0;i<n.intValue()-1;i++){
            BigInteger temp = a.add(b);
            a=b;
            b=temp;

            list.add(b);
        }

        BigInteger sum = list.stream().reduce(BigInteger.ZERO, BigInteger::add);

        return sum.multiply(BigInteger.valueOf(4));



		// your code

    
    }
    
    public static void main(String[] args) {

        BigInteger value= SumFct.perimeter(BigInteger.valueOf(30));
        System.out.println(value);
       // BigInteger.valueOf(80), SumFct.perimeter(BigInteger.valueOf(5))


    }
}