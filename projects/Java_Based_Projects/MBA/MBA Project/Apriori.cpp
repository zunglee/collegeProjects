#include<iostream>
#include<conio.h>
using namespace std;
int arrt[10][5],arrd[10][6],x,conf=2,n=5;
void calculate(int arr[9][5],int arri[],int p,int row)
{
  int i,j,k,l=0,m;
  for(i=0;i<9;i++)
  {
    k=0;
    for(j=0;j<n;j++)
    {
      if(arr[i][j]==1 && arri[j]==1)
      k++;
    }
    //cout<<k<<"\n";
    if(k==p)
    l++;
  }
  //system("pause");
 /* cout<<l<<"\n";
  cout<<x<<"\n";
  for(j=0;j<n;j++)     
  cout<<arri[j]<<" ";*/
  
  if(l>=conf)
  {
   for(m=0;m<n;m++)
   arrd[x][m]=arri[m];
   arrd[x][5]=l;
   x++;
  }
  
 /* cout<<x<<"\n";
  for(j=0;j<n;j++)     
  cout<<arri[j]<<" ";*/
  //system("pause");
 /* for(i=0;i<x;i++)
  {
    for(j=0;j<n+1;j++)              
    cout<<arrd[i][j]<<" ";
    cout<<"\n";
  }
  system("pause");*/
}
    
int main()
{
  int arr[9][5]={1,1,1,0,0,
                 0,1,1,0,1,
                 0,1,1,0,0,
                 1,1,0,1,0,
                 1,0,1,0,0,
                 0,1,1,0,0,
                 1,0,1,0,0,
                 1,1,1,0,1,
                 1,1,1,0,0};
  x=0;
  int i,j,k,l,m,p,row;
  //n=5;
  row=n;
  p=1;
  int arri[n];
  for(i=0;i<n;i++)
  {
    for(j=0;j<n;j++)
    {
      arrt[i][j]=0;
      if(i==j)
      arrt[i][j]=1;
      arrd[i][j]=arrt[i][j];
    }
  }
  for(i=0;i<n;i++)
  {
    for(j=0;j<n;j++)
    {
      cout<<arrt[i][j]<<" ";
    }
    cout<<"\n";
  }
  cout<<"\n";
  for(i=0;i<n;i++)
  {
    for(j=0;j<n;j++)
    {
      cout<<arrd[i][j]<<" ";
    }
    cout<<"\n";
  }
  cout<<"\n";
  
  x=5;
  row=x;
  p=2;
  int f=n-1,z;
 while(f>0 && row>0)
 {
  for(i=0;i<row;i++)
  {
    for(j=0;j<n;j++)
    {
      cout<<arrt[i][j]<<" ";
    }
    cout<<"\n";
  }
  cout<<"\n";
  x=0;
  for(i=0;i<row;i++)
  {
    for(j=0;j<n;j++)
      arri[j]=arrt[i][j];
   /* for(int z=0;z<n;z++)
        cout<<arri[z]<<" "; */
        
        //system("pause");
        
       // cout<<"\n";
    for(k=n-1;k>=0;k--)
    {
      if(arrt[i][k]==1)
      {
         //cout<<k<<"\n";
        l=k;
        break;
      }
    }
    //cout<<l;
    for(k=i+1;k<row;k++)
    for(m=l+1;m<n;m++)
    {
      if(arrt[k][m]==1)
      {
        arri[m]=1;
      /* for(int z=0;z<n;z++)
        cout<<arri[z]<<" ";  */
        int t=0;
        for(int z=0;z<x;z++)
        {
         t=0;
         for(j=0;j<n;j++)
         {
         if(arrd[z][j]!=arri[j])
         break;
         else
         t++;
         }
         if(t==n)
         break;
       }
        if(t!=n)
        {
        //for(z=0;z<n;z++)
        //cout<<arri[z]<<" "; 
        //system("pause");
        //cout<<"\n";
        //system("pause");
        //cout<<"\n";
        calculate(arr,arri,p,row);
 /* for(z=0;z<x;z++)
  {
    for(j=0;j<6;j++)
    {
      cout<<arrd[z][j]<<" ";
    }
    cout<<"\n";
  }*/
        }
       /* for(int z=0;z<n;z++)
        cout<<arri[z]<<" ";
        cout<<"\n";*/
        arri[m]=0;
      }
    }
  }
  cout<<"\n";
  
  for(z=0;z<x;z++)
  {
    for(j=0;j<6;j++)
    {
      cout<<arrd[z][j]<<" ";
    }
    cout<<"\n";
  }
  cout<<"\n";
  //cout<<x;
  row=x;
  
  for(z=0;z<row;z++)
  for(j=0;j<n;j++)
  arrt[z][j]=arrd[z][j];
  cout<<"\niteration "<<p<<" complete\n";
  system("pause");
  cout<<"\n";
  p++;
  f--;
}
  getch();
  return 0;
}
