#include<iostream>
#include<map>
using namespace std;
int main()
{
    map<int,int> m;
    map<int,int>::iterator it;
    m[1]=5;
    m[2]=3;
     it=--m.end();
     it--;
    while(1)
    {
           
            if(it==m.begin())
            {
               cout<<it->first<<endl;
               break;
            }
            cout<<it->first<<endl;
            it--;  
                                      
    }
    //cout<<m.size()<<endl;
    
    system("pause");
}
    
