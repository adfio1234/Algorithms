#include <iostream>

using namespace std;
int main()
{
    int T=0;
    cin>>T;

    for (int j=0;j<T;j++){
        int difficult[2]={0,0};

        int N=0;
        cin>>N;

        int height[N];
        for(int i=0;i<N;i++)
        {
            cin>>height[i];
        }
        for(int i=0;i<N-1;i++)
        {
            if(height[i]<height[i+1])
            {
                int step=height[i+1]-height[i];
                difficult[0]=max(difficult[0],step);
            }
            else if(height[i]>height[i+1])
            {
                int step=height[i]-height[i+1];
                difficult[1]=max(difficult[1],step);
            }
        }
        cout<<"#"<<j+1<<" "<<difficult[0]<<" "<<difficult[1]<<endl;
    }
}