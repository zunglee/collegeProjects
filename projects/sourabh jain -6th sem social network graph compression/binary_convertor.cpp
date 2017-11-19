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
     s=0;
     while(a)
     {
             arr[s++]=a%2;
             a=a/2;
     }
     for(int i=0;i<s/2;i++)
             arr[i]=arr[i]+arr[s-1-i]-(arr[s-1-i]=arr[i]);
     
}
int main()
{
    ifstream fin;
    fin.open("output2.txt");
    ofstream fout;
    fout.open("binary_output2.txt");
    int a,b;
    string str;
    while(fin)
    {
              fin>>a>>b>>str;
              binary(a);
              for(int i=0;i<s;i++)
                      fout<<arr[i];
              fout<<" ";
              binary(b);
              for(int i=0;i<s;i++)
                      fout<<arr[i];
              fout<<" ";
              fout<<str;
              fout<<"\n";
    }
    fin.close();
    fout.close();
    return 0;
}
    
