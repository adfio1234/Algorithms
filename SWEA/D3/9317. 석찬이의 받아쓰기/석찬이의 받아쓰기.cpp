#include<iostream>
using namespace std;
int main()
{
    int T;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        int N;
        cin >> N;
        string str1,str2;
        cin>>str1;
        cin>>str2;
        int ans=0;
        for(int j=0;j<str1.length();j++)
        {
            if( str1[j]==str2[j])ans++;
        }
        cout<<"#"<<i+1<<" "<<ans<<"\n";
    }
}