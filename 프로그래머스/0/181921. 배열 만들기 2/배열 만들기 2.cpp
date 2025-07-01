#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool fiveTest(int a);
vector<int> solution(int l, int r) {
    vector<int> answer;
    
    //에라스토 테네스의 체를 사용하여 5의 배수가 아닌것을 제거
    int arr[1000001]={0,};
    for(int i=l;i<1000001;i++)
    {
        if(i%5!=0)continue;
        arr[i]=1;
    }
    for(int i=l;i<=r;i++)
    {
        if(arr[i]!=1)continue;
        if(fiveTest(i))answer.push_back(i);
    }
    if(answer.size()==0)answer.push_back(-1);
    return answer;
}
//모든자리수의 나머지연산이 5혹은 0이면 조건에 만족한다
bool fiveTest(int a)
{
    while(a>0)
    {
        if(a%10!=5&&a%10!=0)return false;
        a/=10;
    }
    return true;
}
