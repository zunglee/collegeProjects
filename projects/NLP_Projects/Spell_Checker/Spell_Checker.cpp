#include<iostream>
#include<map>
#include<vector>
#include <fstream>
#include<map>
#include<string.h>
#include<stdio.h>
#include<ctype.h>
using namespace std;
const char delim[]    = ".,:;`/\"+-_(){}[]<>*&^%$#@!?~/|\\=1234567890 \t\n";
const char alphabet[] = "abcdefghijklmnopqrstuvwxyz";

map<string, int> mp;
map<string, int>::iterator it;

//converting words to lower case
static char *strtolower(char *word)
{
        char *s;

        for (s = word; *s; s++)
                *s = tolower(*s);

        return word;
}

static char *substr(char *str, int offset, int limit)
{
        char *new_str;
        int str_size = strlen(str);

        if ((limit > str_size) || ((offset + limit) > str_size) ||
            (str_size < 1) || (limit == 0))
                return NULL;

        new_str = (char *)malloc(limit+1 * sizeof(char));
        if (!new_str)
                return NULL;

        strncpy(new_str, str+offset, limit);
        *(new_str + limit) = '\0';

        return new_str;
}

static char *concat(char *str1, char *str2)
{
        if (!str1) {
                str1 = (char *)malloc(sizeof(char));
                *str1 = '\0';
        }

        if (!str2) {
                str2 = (char *)malloc(sizeof(char));
                *str2 = '\0';
        }

        str1 = (char *)realloc(str1, strlen(str1) + strlen(str2) + 1);
        return strcat(str1, str2);
}

void take_input()
{
    string line;

    ifstream data("words.txt");
    //ofstream dict("words.txt");
    char ws[1000],*w,*word;

mp.clear();
int cnt=0;
        while ( data.good() )
        {
            getline (data,line);

            //cout<<line<<endl;

            cnt++;
            strncpy(ws, line.c_str(),sizeof(ws));
            ws[sizeof(ws) - 1] = 0;
            word=ws;
            word = strtok (word,delim);
            while(word!=NULL)
            {
                word = strtolower(strdup(word));
                if(mp.find(word)==mp.end())
                {mp[word]=1;}//cout<<word<<endl;}
                else
                mp[word]++;

                word = strtok(NULL, delim);
            }
        }
        cout<<mp.size()<<endl;
        //for(it=mp.begin();it!=mp.end();it++ )
        //dict<<(*it).first<<" ";
}

int length(char* word)
{
    int len=strlen(word);
    return (len+len-1+len*sizeof(alphabet)+(len+1)*sizeof(alphabet));
}

static int deletion(char **array,char *word, int start_idx)
{
        int i, word_len = strlen(word);

        for (i = 0; i < word_len; i++)
                array[i + start_idx] = concat(substr(word, 0, i), substr(word, i+1, word_len-(i+1)));

        return i;
}

static int transposition(char **array,char *word,  int start_idx)
{
        int i, word_len = strlen(word);

        for (i = 0; i < word_len-1; i++)
                array[i + start_idx] = concat(concat(substr(word, 0, i),
                                                     substr(word, i+1, 1)),
                                              concat(substr(word, i, 1),
                                                     substr(word, i+2, word_len-(i+2))));

        return i;
}

static int alteration(char **array,char *word,  int start_idx)
{
        int i, j, k, word_len = strlen(word);
        char c[2] = { 0, 0 };

        for (i = 0, k = 0; i < word_len; i++)
                for (j = 0; j < sizeof(alphabet); j++, k++) {
                        c[0] = alphabet[j];
                        array[start_idx + k] = concat(concat(substr(word, 0, i), (char *) &c),
                                                      substr(word, i+1, word_len - (i+1)));
                }

        return k;
}

static int insertion(char **array,char *word,  int start_idx)
{
        int i, j, k, word_len = strlen(word);
        char c[2] = { 0, 0 };

        for (i = 0, k = 0; i <= word_len; i++)
                for (j = 0; j < sizeof(alphabet); j++, k++) {
                        c[0] = alphabet[j];
                        array[start_idx + k] = concat(concat(substr(word, 0, i), (char *) &c),
                                                      substr(word, i, word_len - i));
                }

        return k;
}

static char **edits(char* word)
{
    int index;
    char **array = (char **)malloc(length(word) * sizeof(char *));

    if (!array)
    return NULL;

    index  = deletion(array,word, 0);
    index += transposition(array,word, index);
    index += alteration(array,word,  index);
    insertion(array,word,  index);
    return array;
}

static string maxi(char **array,int rows)
{
        string max_word = "";
        int i, max_size = 0,cnt=0;


        for (i = 0; i < rows; i++) {
                it = mp.find(array[i]);
                if ((it!=mp.end())&&( (*it).second>max_size)) {
                        max_size = (*it).second;
                        max_word = (*it).first;
                        cout<<max_word<<" "<<max_size<<endl;
                        cnt++;
                }
        }
        cout<<cnt<<endl;
        return max_word;
}

static int array_exist(char **array, int rows, char *word)
{
        int i;

        for (i = 0; i < rows; i++)
                if (!strcmp(array[i], word))
                        return 1;

        return 0;
}

static char **known_edits2(char **array, int rows, int *e2_rows)
{
        int i, j, res_size, e1_rows;
        char **res = NULL, **e1;

        for (i = 0, res_size = 0; i < rows; i++) {
                e1      = edits(array[i]);
                e1_rows = length(array[i]);

                for (j = 0; j < e1_rows; j++)
                        if ((mp.find(e1[j])!=mp.end()) && !array_exist(res, res_size, e1[j])) {
                                res             = (char **)realloc(res, sizeof(char *) * (res_size + 1));
                                res[res_size++] = e1[j];
                        }
        }

        *e2_rows = res_size;

        return res;
}

string corrected_word(char* word)
{
    if(mp.find(word)!=mp.end())
    return word;
    else
    {
        char **e1;
        int rows = length(word);
        if (rows) {
                e1 = edits(word);

                string e1_word = maxi(e1, rows);

                if (e1_word!="") {
                        return e1_word;
                }
        }

        int e2_rows;
        string res_word="";
        char **e2 = known_edits2(e1, rows, &e2_rows);
        if (e2_rows) {
                string e2_word = maxi(e2, e2_rows);
                if (e2_word!="")
                        res_word = e2_word;
        }

        return res_word;
    }


}
int main()
{
    take_input();
    char ch[1000];
    while(1){
    cout<<"Enter String for Spell checking"<<endl;
    cin>>ch;

    string st=corrected_word(ch);
    cout<<st<<endl;
    }
    return 0;
}
