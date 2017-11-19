#include<iostream>
#include<fstream>
#include<vector>
#include<set>
#define pb push_back
using namespace std;
vector<int> v1,v2;
int arr[30],s;
void binary(int a)
{
     if(a==0)
     {
             s=1;
             arr[0]=0;
             
     }
     else
     {
         s=0;
         while(a)
         {
             arr[s++]=a%2;
             a=a/2;
         }
         for(int i=0;i<s/2;i++)
             arr[i]=arr[i]+arr[s-1-i]-(arr[s-1-i]=arr[i]);
     }
}
string str;
int p;
int get_int()
{
    int temp=0;
    while(p<str.length() &&str[p]!=' ' && str[p]!='\0')
    {
          temp=temp*10+(int)(str[p]-'0');
          p++;      
    }
    p++;
    return temp;
}
string get_str()
{
       string s="";
       while(p<str.length() && str[p]!='\0' && str[p]!=' ')
       {
            s+=str[p];
            p++;              
       }
       return s;
}
int main()
{
    ifstream fin;
    ofstream fout;
    char file_name[50];
    string temp1,temp2;
    
    
    cout<<"Enter file name : ";
    cin>>file_name;
    fin.open(file_name);
    
    
    temp1=file_name;
    temp1="binary_"+temp1;
    for(int i=0;i<temp1.length();i++)
            file_name[i]=temp1[i];
            
            
    fout.open(file_name);
    int a,b;
    if(file_name[7]=='o')
    {
                         fin>>a;
                         binary(a);
                         for(int i=0;i<s;i++)
                                  fout<<arr[i];
                         fout<<"\n";
    }
    while(fin)
    {
              getline(fin,str);
              if(str.length()>0)
              {
                     p=0; 
                     binary(get_int());
                     for(int i=0;i<s;i++)
                             fout<<arr[i];
                     fout<<" ";
                     binary(get_int());
                     for(int i=0;i<s;i++)
                             fout<<arr[i];
                     fout<<" ";
                     fout<<get_str()<<endl;
                     
              }
    }
    fin.close();
    fout.close();
    system("pause");
    return 0;
}
    
