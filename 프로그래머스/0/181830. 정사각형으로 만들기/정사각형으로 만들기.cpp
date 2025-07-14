#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int row=arr.size();//행
    int col=arr[0].size();//열
    
    if(row==col)return arr;
    if(row>col)//행이더크면 뒤에 0을추가해야함
    {
        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<row-col;j++)arr[i].push_back(0);
        }
    }
    else if(col>row)//열이더크면 vector를 삽입해야함
    {
        vector <int> tmp;
        for(int i=0;i<arr[0].size();i++)tmp.push_back(0);
        for(int i=0;i<col-row;i++)arr.push_back(tmp);
            
    }
    
    return arr;
}