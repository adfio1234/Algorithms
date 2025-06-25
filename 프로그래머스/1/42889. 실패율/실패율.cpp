#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(int a,int b);
bool comparePair(pair<int,double> a,pair<int,double>b);

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int,double>> failureRate;//스테이지와 실패율을 동시에 넣기위한 pair
    int fail=0;
    
    sort(stages.begin(),stages.end(),compare);//오름차순으로 정렬

    for(int i=1;i<=N;i++)
    {
        for(int j=stages.size()-1;j>=0;j--)
        {
            if(i>=stages[j])fail++;//실패율계산
        }
        if(stages.size()==0)failureRate.push_back(make_pair(i,0));
        else failureRate.push_back(make_pair(i,(double)fail/stages.size()));
        
        for(int j=0;j<fail;j++)stages.pop_back();
        fail=0;
    }
    sort(failureRate.begin(),failureRate.end(),comparePair);
    for(int i=0;i<failureRate.size();i++)cout<<failureRate[i].first<<"  "<<failureRate[i].second<<'\n';
    for(int i=0;i<failureRate.size();i++)answer.push_back(failureRate[i].first);
    return answer;
}
bool compare(int a,int b)
{
    return a>b;
}
bool comparePair(pair<int,double> a,pair<int,double>b)
{
    if(a.second==b.second) return a.first<b.first;
    return a.second>b.second;
}
