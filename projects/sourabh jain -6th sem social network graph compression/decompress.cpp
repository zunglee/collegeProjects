#include<iostream>
#include<fstream>
using namespace std;
bool arr[100000];
struct node
{
       int pointer;
       int vertex;
       string s;
}seq[100000];
int s=0,k;
int main()
{
    ifstream fin;
    fin.open("output2.txt");
    ofstream fout;
    fout.open("decompress_big.txt");
    fin>>k;
    while(fin)
    {
             fin>>seq[s].pointer>>seq[s].vertex>>seq[s].s; 
             s++;
    }
    for(int i=0;i<s;i++)
    {
            if(!arr[i])
            {
                int ct=0,j=i,t;       
                while(ct==0)  
                {     
                      t=2;
                      for(int p=1;p<=k;p++)
                      {
                           if(j-p>=0 && seq[j-p].s.length()>=t)
                           {
                                  if(seq[j-p].s[t-1]=='1')
                                          fout<<seq[j].vertex<<" "<<seq[j-p].vertex<<endl;                 
                           }
                           else 
                                break;
                           t+=2;
                      }
                      t=1;
                      for(int p=1;p<=k;p++)
                      {
                           if(j+p<s && seq[j].s.length()>=t)
                           {
                                  if(seq[j].s[t-1]=='1')
                                          fout<<seq[j].vertex<<" "<<seq[j+p].vertex<<endl;                 
                           }
                           else 
                                break;
                           t+=2;
                      }
                      arr[j]=true;
                      if(seq[j].pointer<=j)
                         ct++;
                      j=seq[j].pointer;
                        
                }         
            }
    }
    return 0;
}
    
