#include<iostream>
#include<fstream>
#include<map>
#include<string>
using namespace std;
map<string, int> mp;
const char delim[]    = ".,:;`/\"+-_(){}[]<>*&^%$#@!?~/|\\=1234567890 \t\n";
int sport[6][8],info[5][8],test[1][8];
double sprob[8],iprob[8],tprob[8];
static char *strtolower(char *word)
{
        char *s;

        for (s = word; *s; s++)
                *s = tolower(*s);

        return word;
}

void func(int arr[][8],string st2, int n)
{
    string line="";
    for(int i=0;i<n;i++)
    {
        string st="d";
        char c=i+49;
        string ch(1,c);
        st+=(ch);
        st+=st2;
        //cout<<st<<endl;


        char ws[1000],*word,wss[1000],*wo;

        strncpy(wss, st.c_str(),sizeof(wss));
        wss[sizeof(wss) - 1] = 0;
        wo=wss;
        ifstream file(wo);

        if (file.is_open())
        {
            while(file.good())
            {
                getline (file,line);

                strncpy(ws, line.c_str(),sizeof(ws));
                ws[sizeof(ws) - 1] = 0;
                word=ws;
                //cout<<line<<endl;

                word = strtok (word,delim);

                while(word!=NULL)
                {
                    word = strtolower(strdup(word));

                    if(mp.find(word)!=mp.end())
                    {arr[i][mp[word]]=1;}//cout<<word<<endl;}
                    else
                    {arr[i][mp[word]]=0;}

                    word = strtok(NULL, delim);
                }
            //cout<<endl;
            }

        }
        else
        {cout<<st2<<endl;cout<<"error";}
    }

}

void probability(int arr[][8],int n, double prob[])
{
    for(int j=0;j<8;j++)
    {
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i][j]==1)
            cnt++;
        }
        prob[j]=(cnt*1.0)/n;
    }
}
int main()
{
    mp["goal"]=0;
    mp["tutor"]=1;
    mp["variance"]=2;
    mp["speed"]=3;
    mp["drink"]=4;
    mp["defence"]=5;
    mp["performance"]=6;
    mp["field"]=7;

    func(sport,"_sport.txt",6);

    func(info,"_info.txt",5);

    double ps=(6.0)/11;
    probability(sport,6,sprob);

    double pi=(5.0)/11;
    probability(info,5,iprob);

    //for(int i=0;i<8;i++)
    //cout<<sprob[i]<<" "<<iprob[i]<<endl;
    string str;
    cout<<"Enter the name(1/2/3...) of the file to Categorize"<<endl;
    cin>>str;

    string st="_test";
    st+=str;st+=".txt";

    func(test,st,1);
    double val1=ps,val2=pi;
    for(int i=0;i<8;i++)
    {

        if(test[0][i]==1)
        {val1=val1*sprob[i];val2=val2*iprob[i];}
        else
        {val1=val1*(1-sprob[i]);val2=val2*(1-iprob[i]);}
    }

    if(val1>val2)
    cout<<"Sports"<<endl;
    else
    cout<<"Informatics"<<endl;

return 0;
}
