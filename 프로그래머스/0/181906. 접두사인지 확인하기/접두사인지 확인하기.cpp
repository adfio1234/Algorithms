#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_prefix) {
    if(my_string.length()<is_prefix.length())return 0;
    if(my_string.substr(0,is_prefix.length())==is_prefix)return 1;
    return 0;
}