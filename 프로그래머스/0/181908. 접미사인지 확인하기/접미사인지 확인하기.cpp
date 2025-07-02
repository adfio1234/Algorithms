#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string my_string, string is_suffix) {
    if(is_suffix.length()>my_string.length())return 0;
    if(my_string.substr(my_string.length()-is_suffix.length())==is_suffix)return 1;
    return 0;
}