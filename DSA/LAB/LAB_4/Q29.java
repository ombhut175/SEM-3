import java.util.*;
class Codechef
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0)
		{
			int n = sc.nextInt();
			int count = 0;
			int a[] = new int[n];
			int b[] = new int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
				b[i] = a[i];
			}
			int temp = 0;
			for(int i=0;i<n;i++)
			{
				if(a[i] == b[i])
				{
					for(int j=0;j<n;j++)
					{
						if(i != j)
						{
							if(a[i]!=b[j] && b[i] != a[j])
							{
								temp = b[i];
								b[i] = b[j];
								b[j] = temp; 
							}
						}
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				if(a[i] != b[i])
					count++;
			}
			System.out.println(count);
			for(int i=0;i<n;i++)
			{
				System.out.print(b[i]+" ");
			}
			System.out.println();
		}
	}
}