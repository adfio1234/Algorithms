#include<iostream>
#include<unordered_map>

int main()
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);

	int N;
	std::unordered_map<int,int> M;
	int X;
	int answer = 0;
	int left = 0;

	std::cin >> N;

	for (int i = 0; i < N; i++)
	{
		int tmp;
		std::cin >> tmp;
		M.insert({ tmp,0 });
	}
	std::cin >> X;

	for (auto it=M.begin();it!=M.end();it++)
	{
		int target = X - it->first;
		if (M.find(target) != M.end()&&target!=it->first)answer++;
	}
	std::cout<<answer / 2;
}
