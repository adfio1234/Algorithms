#include <string>
#include <vector>
#include<iostream>
using namespace std;
int upDown(string name);
int solution(string name) {
    int answer = 0;
    answer+=upDown(name);
    
    //좌우 이동방식 횟수 구하기
    //가장가까운 A가아닌것을 구하면된다.
    int leastDistance=name.length()-1;
    for(int i=0;i<name.length();i++)
    {
        int next=i+1;
        while(next<name.length()&&name[next]=='A')
        {
            next++;
        }
    
        int turnLeft=i*2+name.length()-next;
        int turnRight=(name.length()-next)*2+i;
        leastDistance=min(leastDistance,min(turnLeft,turnRight));
    }
    cout<<leastDistance;
    return answer+leastDistance;
}
int upDown(string name)
{
    int aToMove=0;
    int zToMove=0;
    int sum=0;
    for(int i=0;i<name.length();i++)
    {
        aToMove=name[i]-65;
        zToMove=90-name[i]+1;
        sum+=aToMove<zToMove?aToMove:zToMove;
    }
    return sum;
}
