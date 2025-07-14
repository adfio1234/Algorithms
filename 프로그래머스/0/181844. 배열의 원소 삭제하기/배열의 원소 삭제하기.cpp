#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    vector<int> answer;
    int hash[1001]={0,};
    for(int i=0;i<delete_list.size();i++)hash[delete_list[i]]=1;
    for(int i=0;i<arr.size();i++)
    {
        if(hash[arr[i]]==1)continue;
        answer.push_back(arr[i]);
    }
    return answer;
}