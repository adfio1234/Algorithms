#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>

using namespace std;

vector<string> solution(vector<string> strArr) {
    for(int i=0;i<strArr.size();i++)
    {
        if(i%2==1)
        {
            boost::to_upper(strArr[i]);
        }
        else
        {
            boost::to_lower(strArr[i]);
        }
    }
    return strArr;
}