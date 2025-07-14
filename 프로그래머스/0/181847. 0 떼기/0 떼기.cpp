#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    // if(n_str[0]=='0')
    // {
    //     while(n_str[0]=='0')
    //     {
    //         n_str=n_str.substr(1);
    //     }
    // }
    return to_string(stoi(n_str));
}

//string을 stoi로변환후 to_string으로 변환하면 더 쉽게풀수있다.