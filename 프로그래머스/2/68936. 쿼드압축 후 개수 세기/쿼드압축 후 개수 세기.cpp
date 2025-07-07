#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> answer={0,0};

void quadTree(vector<vector<int>> &arr,int xLeft,int yLeft,int xRight,int yRight);

vector<int> solution(vector<vector<int>> arr) {
    quadTree(arr,0,0,arr[0].size()-1,arr.size()-1);
    return answer;
}

//재귀를통한 4분면탐색
void quadTree(vector<vector<int>> &arr,int xLeft,int yLeft,int xRight,int yRight)
{
    int half=(xRight-xLeft+1)/2;
    
    //왼쪽위의 수를골라서 식별자로 둠으로써 식별자와 다른 수가나오면 압축이 안된다는것을 알 수 있다.
    int identify=arr[xLeft][yLeft];
    bool isSame=true;
    
    
    for(int i=xLeft;i<=xRight;i++)
    {
        for(int j=yLeft;j<=yRight;j++)
        {
            if(identify!=arr[i][j])//식별자와 다른경우 좁혀서 다시 탐색한다.
            {
                isSame=false;
                break;
            }
        }
        if(isSame==0)break;
    }
    if(isSame)
    {
        answer[identify]++;
        return;
    }
    
    quadTree(arr,xLeft+half,yLeft,xRight,yLeft+half-1);//1사분면
    quadTree(arr,xLeft,yLeft,xLeft+half-1,yLeft+half-1);//2사분면
    quadTree(arr,xLeft,yLeft+half,xLeft+half-1,yRight);//3사분면
    quadTree(arr,xLeft+half,yLeft+half,xRight,yRight);//4사분면
    
} 
//크기를 줄여나가면서 
//0혹은 1 이면 바로 count를올리고 그범위는 탐색안하게한다.