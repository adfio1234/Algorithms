#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(int a, int b) {
    if(a%2==1&&b%2==1)return a*a+b*b;
    else if(a%2==1||b%2==1)return 2*(a+b);
    else return abs(a-b);
}