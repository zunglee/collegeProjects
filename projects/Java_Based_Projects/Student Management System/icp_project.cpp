#include<iostream>
#include<conio.h>
#include<string.h>
using namespace std;
struct address
{
       string city;
       string state;
       long pin;
};
struct book_issued_info
{
       string title;
       string author;
       int year;
};
struct lib_info 
{
       string enroll;        
       int slot;
       book_issued_info issue;  
};   


struct student
{
       string enroll;        
       string name;
       float cgpi;
       address add;
       lib_info lib; 
};

void read_book_info(lib_info *l)
{
cout<<"\nEnter the slot of book isssued: ";
 cin>>l->slot;
 cout<<"\nEnter the title of book isssued: ";
 cin>>l->issue.title;
 cout<<"\nEnter the author of book isssued: ";
 cin>>l->issue.author;
 cout<<"\nEnter the year of book isssued: ";
 cin>>l->issue.year;     
}


void read_stud_info(student *a)
{
 cout<<"\nEnter the Enrollment no. of the student:";
 cin>>a->enroll;    
 cout<<"\nEnter the name of the student: "; 
 cin>>a->name;
 cout<<"\nEnter the CGPI of the student: ";
 cin>>a->cgpi;

 cout<<"\nEnter the distric of the student: ";
 cin>>a->add.city; 
 cout<<"\nEnter the state of the student: "; 
 cin>>a->add.state;
 cout<<"\nEnter the pincode: "; 
 cin>>a->add.pin;
 a->lib.enroll="";
 a->lib.slot=0;
 a->lib.issue.title="";
 a->lib.issue.author=""; 
 a->lib.issue.year=0;
 }


int create_database(student a[],int n)
{

for(int i=0;i<n;i++)
{
        cout<<"\n\nENTER THE DETAILS OF STUDENT NO. "<<i+1;
        read_stud_info(&a[i]);
}
return n;
}




int isissued(student *a,book_issued_info s)
{
     if(a->lib.issue.title==s.title)
     if(a->lib.issue.author==s.author)
     if(a->lib.issue.year==s.year)
     return 1;
     return 0;
}


void check_book_issued(student a[],int n)
{
book_issued_info s;
cout<<"Enter the tiltle of book: ";
cin>>s.title;     
cout<<"Enter the author of book: ";
cin>>s.author;
cout<<"Enter the year of book: ";
cin>>s.year;

int counter=0;

for(int i=0;i<n;i++)
{
        if(isissued(&a[i],s))
                   {
                   counter++;         
                   cout<<endl<<counter<<". Enrollment No. "<<a[i].enroll<<"\nName "<<a[i].name;

                     ;
                   }         
}
cout<<"\nBook issued by total = "<<counter<<" students";
}  


void highest_mark_holder(student a[],int n)
{
float max_cgpi=a[0].cgpi;
int pos=0;
for(int i=1;i<n;i++)
        {
        if(a[i].cgpi>max_cgpi)
                              {
                              max_cgpi=a[i].cgpi;
                              pos=i;
                              }
        }
cout<<"\nHIGHEST MARK HOLDER IS\n ";
cout<<"Enrollment No."<<a[pos].enroll<<"\nName "<<a[pos].name<<"\nCGPI "<<a[pos].cgpi;
}

void sort_bycgpi(student a[],int n)
{
 student temp;
 for(int i=0;i<n;i++)
         for(int j=i;j<n-1;j++)
                 {
                 if(a[j].cgpi>a[j+1].cgpi)
                                {
                                temp=a[j];
                                a[j]=a[j+1];
                                a[j+1]=temp;
                                }              
                 }
}

 
int search_data(student a[],int n,int s_cgpi)
{
 int lb=0,hb=n-1,mid=(n-1)/2;
 
 while(lb<=hb)
 {
 if(a[mid].cgpi==s_cgpi)
 return mid;
 else if(a[mid].cgpi<s_cgpi)
      lb=mid+1;
 else
     hb=mid-1;
 mid=(lb+hb)/2;
 }
return -1;
}


void search_reqcgpi(student a[],int n)
{
int s_cgpi=0;
cout<<"\nEnter the CGPI: ";
cin>>s_cgpi;
int pos=search_data(a,n,s_cgpi);             
if(pos==-1)
cout<<"\nNo student found with required cgpi";
else
cout<<"\nEnrollment No. "<<a[pos].enroll<<"\nName "<<a[pos].name;                    
}


void add_lesscgpi(student a[],int n)
{
int i=0;
float s_cgpi;
cout<<"\nEnter the CGPI: ";
cin>>s_cgpi;
cout<<"\nDETAILS OF STUDENTS HAVING CGPI LESSS THAN GIVEN CGPI:-";
while(i<n)
{
if(s_cgpi>=a[i].cgpi)
                {
                cout<<"\nEnrollment No. "<<a[i].enroll<<"\nName "<<a[i].name;                    
                cout<<"\nAddress:\n"<<a[i].add.city<<endl<<a[i].add.state<<endl<<a[i].add.pin;
                }
else break;
i++;
}
}

void issue_book(student a[],int n)
{
int flag=0;
string s_enroll;
cout<<"\nEnter the enrollment no.: ";
cin>>s_enroll;

for(int i=0;i<n;i++)
{
        if(a[i].enroll==s_enroll)
                                 {
                                 if(a[i].lib.enroll!="")
                                 cout<<"\n\nSORRY HAS ALREADY ISSUED A BOOK...RETURN THE PREVIOUS ONE TO ISSUE AGAIN!!!";
                                 else
                                 {
                                     a[i].lib.enroll=s_enroll;
                                     read_book_info(&a[i].lib);
                                 }
                                 flag=1;
                                 break;
                                 }
}     
if(flag==0)
cout<<"\n\nSORRY STUDENT NOT FOUND...!!!";
}

void return_book(student a[],int n)
{
 int flag=0;
 string s_enroll;
 cout<<"\nEnter the enrollment no.: ";
 cin>>s_enroll;

 for(int i=0;i<n;i++)
 {
        if(a[i].enroll==s_enroll) 
                                  {
                                  a[i].lib.enroll="";
                                  a[i].lib.slot=0;
                                  a[i].lib.issue.title="";
                                  a[i].lib.issue.author=""; 
                                  a[i].lib.issue.year=0;
                                  flag=1;
                                  break;
                                  }
 }
 if(flag==0)
 cout<<"\n\nSORRY STUDENT NOT FOUND...!!!";

}


int main()
{
    int choice=0;
    int n=0;
    cout<<"\nEnter the no. of students: ";
    cin>>n;
    student a[n];     
    create_database(a,n);  


    cout<<a[0].enroll;
    sort_bycgpi(a,n);
 
while(1)
{    
    cout<<"\n\n\nPLEASE ENTER YOUR CHOICE:-";
    cout<<"\n\1. Check how many students have issued the book.";
    cout<<"\n2. Find the highest mark holder.";
    cout<<"\n3. Search strudent with required cgpi.";
    cout<<"\n4. Fetch address of students having less than given CGPI.";
    cout<<"\n5. Issue a book.";
    cout<<"\n6. Return a book.";
    cout<<"\n7. Exit.\n";
    cin>>choice;
    
    switch(choice)
    {
                 
                 case 1:check_book_issued(a,n);
                        break;                        
                      
                 case 2:highest_mark_holder(a,n);
                        break;
                        
                 case 3:search_reqcgpi(a,n);
                         break;                      
                
                 case 4:add_lesscgpi(a,n);
                        break;      
                 
                 case 5:issue_book(a,n);
                        break;       
                 
                 case 6:return_book(a,n);   
                        break;
                        
                 case 7:return 1;
                 default:cout<<"\n\nWRONG CHOICE ENTER......!!!! ";       
                         
    }               
}      
    getch();
    return 0;
}

