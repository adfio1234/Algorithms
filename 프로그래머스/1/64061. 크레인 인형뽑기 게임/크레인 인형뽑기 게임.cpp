#include <string>
#include <vector>
#include<iostream>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    vector<int> stack;
    vector<vector<int>> data;
    vector<int> column;
    
    //앞에 0을 지우며 각 열마다 stack처럼 활용하기위한 처리
    for(int i=0;i<board.size();i++)
    {
        for(int j=0;j<board[i].size();j++)
        {
            if(board[j][i]!=0)
            {
                column.push_back(board[j][i]);
            }
            
        }
        data.push_back(column);
        column.clear();
    }
    
    //
    for(int i=0;i<moves.size();i++)
    {
        int col=moves[i]-1;//인덱스 보정
        
        if(data[col].empty())continue;//해당 열에 아무것도 없으면 아무일도 일어나지 않는다.
        
       
        if(stack.empty())//바구니가 비어있으면 비교를 못한다.
        {
            stack.push_back(data[col][0]);//바구니에 인형을 담는다
        }
        else
        {
            if(stack.back()==data[col][0])//바구니의 마지막인형과 뽑은인형이 같은지 비교
            {
                answer+=2;//인형 2개가 사라진다
                stack.pop_back();//바구니의 마지막값 삭제
            }
            else
            {
                stack.push_back(data[col][0]);//바구니에 인형을 담는다
            }
        }
         data[col].erase(data[col].begin());//뽑은 인형을 제거
    }
    
    return answer;
}
// 00000
// 00103
// 02501
// 42442
// 35131
//1 5 3 5 1 2 1 4