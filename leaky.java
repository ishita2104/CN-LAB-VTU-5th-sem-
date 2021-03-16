import java.util.*;
class leaky{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int size,rate,n;
		int a[]=new int[20];
		int sent,rec,rem=0;
		System.out.println("Enter the Bucket size");
		size=sc.nextInt();
		System.out.println("Enter the rate");
		rate=sc.nextInt();
		System.out.println("Enter the no of packets");
		n=sc.nextInt();
		System.out.println("Enter the packets");
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("CLOCK		PACKETS		ACCEPT		SENT		REMAINING");
		for(int i=1;i<=n;i++)
		{
			if(a[i]!=0)
			{
				if(a[i]+rem>size)
				{
					rec=-1;
				}
				else
				{
					rec=a[i];
					rem+=a[i];
				}
			}
			else
			{
				rec=0;
			}
			
			if(rem!=0)
			{
				if(rem>rate)
				{
					sent=rate;
					rem=rem-rate;
				}
				else
				{
					sent=rem;
					rem=0;
				}
			}
			else
			{
				sent=0;
			}
			
			if(rec==-1)
			{
				System.out.println(i+"\t"+a[i]+"\t"+"DROPPED"+"\t"+sent+"\t"+rem);
			}
			else
			{
				System.out.println(i+"\t"+a[i]+"\t"+rec+"\t"+sent+"\t"+rem);
			}
		}
		sc.close();
	}
}
