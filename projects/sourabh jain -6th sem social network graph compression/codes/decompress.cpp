#include<iostream>
#include<fstream>
using namespace std;
bool arr[100000];
struct node
{
       int pointer;
       int vertex;
       string st;
}seq[100000];
int s=0,k;
string str;
int p;
int get_int()
{
    int temp=0;
    while(p<str.length() && str[p]!=' ' && str[p]!='\0')
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
    fin.open("output.txt");
    ofstream fout;
    fout.open("decompress_output.txt");
    fin>>k;
    while(fin)
    {
              getline(fin,str);
              if(str.length()>0)
              {
                      p=0;          
                      seq[s].pointer=get_int();
                      seq[s].vertex=get_int();   
                      seq[s].st=get_str();  
                      
                      s++;   
              } 
            
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
                           if(j-p>=0 && seq[j-p].st.length()>=t)
                           {
                                  if(seq[j-p].st[t-1]=='1')
                                          fout<<seq[j].vertex<<" "<<seq[j-p].vertex<<endl;                 
                           }
                           else 
                                break;
                           t+=2;
                      }
                      t=1;
                      for(int p=1;p<=k;p++)
                      {
                           if(j+p<s && seq[j].st.length()>=t)
                           {
                                  if(seq[j].st[t-1]=='1')
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
    system("pause");
    return 0;
}
    
