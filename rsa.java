import java.math.BigInteger;
import java.util.*;
class rsa{
	static BigInteger p,q,n,phi,e,d;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		rsa RSA=new rsa();
		int size=128;
		
		p=BigInteger.probablePrime(size,r);
		q=BigInteger.probablePrime(size, r);
		e=BigInteger.probablePrime(size, r);
		n=p.multiply(q);
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		while(e.gcd(phi).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
		{
			e.add(BigInteger.ONE);
		}
		d=e.modInverse(phi);
		
		System.out.println("enter the txt");
		String message=sc.nextLine();
		byte[] encrypted=RSA.encryption(message.getBytes());
		byte[] decrypted= RSA.decryption(encrypted);
		System.out.println("encrypted string: "+RSA.BytestoString(encrypted));
		System.out.println("decrypted string: "+new String(decrypted));
		sc.close();
	}
	public byte[] encryption(byte message[])
	{
		return(new BigInteger(message).modPow(e, n).toByteArray());
	}
	public byte[] decryption(byte message[])
	{
		return(new BigInteger(message).modPow(d, n).toByteArray());
	}
	public String BytestoString(byte message[])
	{
		String test="";
		for(int i=0;i<message.length;i++) {
			test+=Byte.toString(message[i]);
		}
		return test;
	}
	
}
