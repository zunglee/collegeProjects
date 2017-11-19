#include<iostream>
#include<fstream>
#include<vector>
#include<set>
#define pb push_back
using namespace std;
vector<int> v1,v2;
string str;
int p;
int get_int()
{
    int temp=0;
    while(p<str.length() && str[p]!=' ')
    {
          temp=temp*10+(int)(str[p]-'0');
          p++;      
    }
    p++;
    return temp;
}
int main()
{
    ifstream fin;
    fin.open("undirected_input.txt");
    ofstream fout;
    fout.open("input.txt");
    set<int> s;
    set<int>::iterator it;
    int a,b,k=0;
    while(fin)
    {
              getline(fin,str);
              if(str.length()>0)
              {
                          p=0;      
                          a=get_int();
                          b=get_int();
                          if(v1.size()==0 || (v1.size()>0 && a!=v1[v1.size()-1] || b!=v2[v2.size()-1]))
                          {
                             fout<<a<<" "<<b<<endl;
                             v1.pb(a);
                             v2.pb(b);
                          }
              }
    }
    for(int i=0;i<8000;i++)
    {
            int j=rand()%16631;
            if(s.end()==find(s.begin(),s.end(),j))
            {
                   s.insert(j);
                   fout<<v2[j]<<" "<<v1[j]<<endl;                               
            }
    }
    
    fin.close();
    fout.close();
    return 0;
}
    
