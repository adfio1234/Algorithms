#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    string word="";
    for(int i=0;i<my_string.length();i++)
    {
        if(my_string[i]==' ')
        {
            if(word.length()!=0)
            {
                answer.emplace_back(word);
                word="";
            }
        }
        else word+=my_string[i];
        
    }
    if(word.length()!=0)
    {
        answer.emplace_back(word);
    }
    return answer;
}