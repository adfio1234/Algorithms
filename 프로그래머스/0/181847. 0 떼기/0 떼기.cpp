#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    if(n_str[0]=='0')
    {
        while(n_str[0]=='0')
        {
            n_str=n_str.substr(1);
        }
    }
    return n_str;
}