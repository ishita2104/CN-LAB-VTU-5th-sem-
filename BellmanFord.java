import java.util.Scanner;
//import java.io.*;
class BellmaFord{
	public static void main(String args[]) {
		int n,max_value=999;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no of vertises:");
		n=s.nextInt();
		int d[]=new int[n+1];
		int a[][]=new int[n+1][n+1];
		System.out.println("Enter the adjacency matrix");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				a[i][j]=s.nextInt();
				if(i==j)
				{
					a[i][j]=0;
					continue;
				}
				if(a[i][j]==0)
				{
					a[i][j]=max_value;
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			d[i]=max_value;
		}
		System.out.println("Enter the source: ");
		int source=s.nextInt();
		d[source]=0;
		
		for(int k=1;k<=n-1;k++)
		{
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					if(a[i][j]!=max_value)
					{
						if(d[i]+a[i][j]<d[j])
						{
							d[j]=a[i][j]+d[i];
						}
					}
				}
			}
		}
		int flag=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(a[i][j]!=max_value)
				{
					if(d[i]+a[i][j]<d[j])
					{
						System.out.println("negative edge");
						flag=1;
						break;
					}
				}
			}
			if(flag==1)
			{
				break;
			}
		}
		if(flag==0)
		{
			for(int i=1;i<=n;i++)
			{
				System.out.println(source +"->"+i+"="+d[i]);
			}
		}
		s.close();
	}
}
