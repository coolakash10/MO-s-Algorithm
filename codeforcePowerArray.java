/*********************************************************************************************************************
     **
     **  Mo's Algorithm
     **  Solution for : http://codeforces.com/contest/86/problem/D
     **  Input in the form of array with offline range query
     **  Output is answer to each query
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{

    static int size;
    static int[]a;
    static Item[]item;

    static long ans[]=new long[200002];
    static int cnt[]=new int[1000002];
    static long power=0;

	//class to store query and sorting accoring left range if block number diff. else by right range
	static class Item implements Comparable<Item>
	{
        int l, r, i;
        public Item(int i, int l, int r)
		{
            this.l = l;
            this.r = r;
            this.i = i;
        }
        public int compareTo(Item k)
		{
            if(l / size != k.l / size)
				return l - k.l;
            else
				return r - k.r;				
        }

    }
    
	//add array element
    public static void add(int a)
    {
        power += (long)a * (cnt[a] + cnt[a] + 1);
        cnt[a]++;
    }
    
	//remove array element
    public static void remove(int a)
    {
        power -= (long)a * (cnt[a] + cnt[a] - 1);
        cnt[a]--;
    }
    
	//Mo's algorithm
    public static void solution(int m)
    {
        
        int cur_l=0,cur_r=-1;
        int l=0,r=-1;
        int pow=0;
        
        for(int i=0;i<m;i++)
        {
            l=item[i].l;
            r=item[i].r;

            while(cur_r<r) 
            {
                cur_r++;
                add(a[cur_r]);
            }
            while(cur_l<l) 
            {
                remove(a[cur_l]);
                cur_l++;
            }
            while(cur_l>l) 
            {
                cur_l--;
                add(a[cur_l]);
            }
            while(cur_r>r) 
            {
                remove(a[cur_r]);
                cur_r--;
            }
           
            ans[item[i].i] = power;
        }
        
    }

	//main class 
	public static void main(String[] args)throws IOException
	{
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   PrintWriter out = new PrintWriter(System.out);
	   String[]s=br.readLine().split(" ");
	   int n=Integer.parseInt(s[0]);
	   int m=Integer.parseInt(s[1]);
	   
	   size=(int)Math.sqrt(n);
	   a=new int[n];
	   s=br.readLine().split(" ");
	   for(int i=0;i<n;i++)
	   {
	       a[i]=Integer.parseInt(s[i]);
	   }
	   item=new Item[m];
	   for(int i=0;i<m;i++)
	   {
	       s=br.readLine().split(" ");
	       int l=Integer.parseInt(s[0]);
	       int r=Integer.parseInt(s[1]);
	       l--;r--;
	       item[i]=new Item(i,l,r);
	   }
	   Arrays.sort(item);
	
	   solution(m);
	   for(int i=0;i<m;i++)
	       out.println(ans[i]);
        out.close();
	}
}
