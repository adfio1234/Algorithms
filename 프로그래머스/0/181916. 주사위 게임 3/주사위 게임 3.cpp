#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include<cmath>
using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0;
    vector<int> arr;
    vector<int> uniqueArr=arr;
    
    arr.push_back(a);
    arr.push_back(b);
    arr.push_back(c);
    arr.push_back(d);
    
    uniqueArr.push_back(a);
    uniqueArr.push_back(b);
    uniqueArr.push_back(c);
    uniqueArr.push_back(d);
    
    sort(arr.begin(),arr.end());
    sort(uniqueArr.begin(),uniqueArr.end());
    uniqueArr.resize(unique(uniqueArr.begin(), uniqueArr.end()) - uniqueArr.begin());//중복을제거
    
    if(arr[0]==arr[3])return a*1111;//4개다 같을경우
    else if((arr[0]*100+arr[1]*10+arr[2])%111==0||(arr[1]*100+arr[2]*10+arr[3])%111==0)//3개 같을떄
    {
        if((arr[0]*100+arr[1]*10+arr[2])%111==0)return pow(10*arr[0]+arr[3],2);
        else return pow(10*arr[1]+arr[0],2);
    }
    else if(arr[0]==arr[1]&&arr[2]==arr[3])return (arr[0]+arr[2])*abs(arr[0]-arr[2]);//2 2 같을경우
    else if(uniqueArr.size()==3)
    {
        int sum=1;
        int count=0;
        for(int i=0;i<uniqueArr.size();i++)
        {
            for(int j=0;j<arr.size();j++)
            {
                if(uniqueArr[i]==arr[j])count++;
            }
            if(count==1)sum*=uniqueArr[i];
            count=0;
        }
        return sum;
    }
    else return arr[0];
}

//4개: 1111*p
//3개: (10*P+q)^2
//2개: (p+q)*|p-q|
//2,1,1개 q*r
//다다르면 가장작은 숫자의 점수