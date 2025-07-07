#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<vector<int>> vectorization(string s);
vector<int> solution(string s) {
    vector<int> answer;
    int arr[100001]={0,};//해쉬를 위한 배열
    vector<vector<int>> input=vectorization(s);
    
    //vector를 사이즈별로 정렬
    sort(input.begin(), input.end(), [](const vector<int>& a, const vector<int>& b) {
        return a.size() < b.size();
    });
    
    for(int i=0;i<input.size();i++)
    {
        for(int j=0;j<input[i].size();j++)
        {
            if(arr[input[i][j]]==0)
            {
                arr[input[i][j]]++;
                answer.push_back(input[i][j]);
            }
        }
    }
    return answer;
}
vector<vector<int>> vectorization(string s)//string입력을 이차원 vector로 바꿔준다.
{
    vector<vector<int>> v1;
    vector<int> v2;
    string num="";
    for(int i=0;i<s.length()-1;i++)
    {
        if(s[i]>=48&&s[i]<=57)//s가 0-9사이일떄
        {
            num+=s[i];
        }
        else if(num.length()!=0)
        {
            v2.push_back(stoi(num));
            num.clear();
        }
        if(s[i]=='}')
        {
            v1.push_back(v2);
            v2.clear();
        }
    }
    return v1;
}