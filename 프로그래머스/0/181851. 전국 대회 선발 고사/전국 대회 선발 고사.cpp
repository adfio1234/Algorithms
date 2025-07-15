#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <iostream>
using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    //참여하는 학생을 저장하는 map객체
    map<int,int> attendRank;
    vector<int> prize;
    for(int i=0;i<rank.size();i++)
    {
        if(attendance[i]==1)attendRank.insert(make_pair(rank[i],i));
    }
    
	for (auto it : attendRank) {
		if(prize.size()>=3)break;
        prize.push_back(it.second);
    }
    return 10000*prize[0]+100*prize[1]+prize[2];
}