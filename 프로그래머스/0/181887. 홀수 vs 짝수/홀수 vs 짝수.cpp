#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int sum[2]={0,0};
    for(int i=0;i<num_list.size();i++)
    {
        if(i%2==0)sum[0]+=num_list[i];
        else sum[1]+=num_list[i];
    }
    return sum[0]>sum[1]?sum[0]:sum[1];
}