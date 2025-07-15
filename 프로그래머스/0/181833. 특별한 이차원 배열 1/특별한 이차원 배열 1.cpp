#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    vector<int> row;
    for(int i=0;i<n;i++)row.push_back(0);
    
    for(int i=0;i<n;i++)
    {
        row[i]=1;
        answer.push_back(row);
        row[i]=0;
    }
    return answer;
}