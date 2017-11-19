#include<iostream>
#include<fstream>
#include<vector>
#include<set>
#include<map>
#define pb push_back
int max(int a, int b)
{
    if(a>b)
           return a;
    else
           return b;
}
using namespace std;
struct node
{
      int pointer;
      int vertex;
      string s;
};

// Memory(Variables)
int info[250000][2];
set<int> s[250000];
set<int> s_rev[250000];
set<int> ver;
map<int,int> m;
vector<node> ans;
int k,edge;

// Functions
int get_random_vertex();
void push_vertex(int);
void create_map();
int get_max_vertex();
void remove_edge_all(int);
void update_map_decrease();
void update_map_increase(int);
void print_map()
{
     map<int,int>::iterator it2;
     cout<<"Map Start: \n";
     for(it2=m.begin();it2!=m.end();it2++)
           cout<<it2->first<<" "<<it2->second<<endl;
     cout<<"Map End: \n";
}

int main()
{
    memset(info,-1,sizeof(info));
    ifstream fin;
    fin.open("input.txt");
    ofstream fout;
    fout.open("output.txt");
    int a,b;
    edge=0;
    //cout<<"hi\n";
    while(fin)
    {
              fin>>a>>b;
              s[a].insert(b);
              s_rev[b].insert(a);
              if(s[a].size()==1)
                       ver.insert(a);  
              edge++;               
              
    }
    cout<<"----------MPk linearization without heuristic--------\n";
    cout<<"Enter value of K :";
    edge--;
    cin>>k;
    while(edge>=1)
    {     
          int u=get_random_vertex();
          push_vertex(u);
          create_map();
          while(edge>=1)
          {
                if(m.size()==0)
                      break;
                 else
                 {
                      int v=get_max_vertex();
                      remove_edge_all(v);
                      update_map_decrease();
                      push_vertex(v);
                      update_map_increase(v);
                  }  
                  
          }
          m.clear();
    }
    fin.close();
    fout<<k<<endl;
    for(int i=0;i<ans.size();i++)
            fout<<ans[i].pointer<<" "<<ans[i].vertex<<" "<<ans[i].s<<endl;
    fout.close();
    system("pause");
    return 0;
}
    
    
int get_random_vertex()
{
         set<int>::iterator it;           
         it=ver.begin(); 
         int p=rand()%ver.size();
         while(p--)
                    it++;        
         return *it;
                       
}

void push_vertex(int u)
{
          if(info[u][0]==-1)
          {
                info[u][0]=ans.size();
                info[u][1]=ans.size();             
          }
          else
          {
                ans[info[u][0]].pointer=ans.size();
                info[u][0]=ans.size();
          }
          node temp;
          temp.pointer=info[u][1];
          temp.vertex=u;
          temp.s="";
          ans.pb(temp);
}


void create_map()
{
     
     int i=max(0,ans.size()-k);
     while(i<ans.size())
     {
              int p=ans[i].vertex;
              set<int>::iterator it;      
              for(it=s[p].begin();it!=s[p].end();it++)
                           m[*it]++;
                             //cout<<*it<<endl;
              for(it=s_rev[p].begin();it!=s_rev[p].end();it++)
                           m[*it]++;  

              i++; 
      }
      
      
      
}

int get_max_vertex()
{
    map<int,int>::iterator it2;
    map<int,int>::iterator it3;
    int max_val=-1;
    int v;
    for(it2=m.begin();it2!=m.end();it2++)
    {             
               if(it2->second>max_val)
               {                         
                   v=it2->first;
                   max_val=it2->second;
                   it3=it2;
               }
    }
    m.erase(it3);
    return v;
}

void remove_edge_all(int v)
{
     for(int i=max(0,ans.size()-k);i<ans.size();i++)
     {
             int w=ans[i].vertex;  
             set<int>::iterator it; 
             set<int>::iterator it1;            
             it=find(s[w].begin(),s[w].end(),v);
             if(it!=s[w].end())
             {
                     s[w].erase(it); 
                     ans[i].s+="1";
                     // delete same from its reverse set
                     it1=find(s_rev[v].begin(),s_rev[v].end(),w);
                     s_rev[v].erase(it1);
                     if(s[w].size()==0)
                     {
                             it1=find(ver.begin(),ver.end(),w);
                                      ver.erase(it1);           
                     }
                     edge--;
             }
             else
                     ans[i].s+="0";
             it=find(s_rev[w].begin(),s_rev[w].end(),v);
             if(it!=s_rev[w].end())
             {
                       s_rev[w].erase(it); 
                       ans[i].s+="1";
                       it1=find(s[v].begin(),s[v].end(),w);
                       s[v].erase(it1);
                       if(s[v].size()==0)
                       {
                                it1=find(ver.begin(),ver.end(),v);
                                ver.erase(it1);           
                       }
                       edge--;
              }
              else
                      ans[i].s+="0";
      }
}

void update_map_decrease()
{
         
         set<int>::iterator it1;
         map<int,int>::iterator it2;  
         int i=ans.size()-k;
         if(i<0)
                return ;
         int u=ans[i].vertex;
         for(it1=s[u].begin();it1!=s[u].end();it1++)
                    m[*it1]--;                                
         for(it1=s_rev[u].begin();it1!=s_rev[u].end();it1++)
                 m[*it1]--;  
        // print_map();  
         it2=m.begin();       
         while(it2!=m.end())
         {
                   if(it2->second==0)
                   {
                          m.erase(it2); 
                          it2--;
                   }  
                   else
                          it2++;                                   
         }
         //print_map();                               
                      
}
void update_map_increase(int v)
{
     set<int>::iterator it;
     for(it=s[v].begin();it!=s[v].end();it++)
                  m[*it]++;                            
     for(it=s_rev[v].begin();it!=s_rev[v].end();it++)
                  m[*it]++;                            
     
}
