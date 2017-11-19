#include<iostream>
#include<fstream>
#include<vector>
#include<set>
#define pb push_back
using namespace std;
vector<int> v1,v2;
int main()
{
    ifstream fin;
    fin.open("projinp.txt");
    ofstream fout;
    fout.open("projout.txt");
    set<int> s;
    set<int>::iterator it;
    int a,b,k=0;
    while(fin)
    {
              fin>>a>>b;
              fout<<a<<" "<<b<<endl;
              v1.pb(a);
              v2.pb(b);
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
    
