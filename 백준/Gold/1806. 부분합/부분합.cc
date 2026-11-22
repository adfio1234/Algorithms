#include<iostream>
#include<queue>

int main()
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);

	int N, S;
	int arr[100000];

	std::cin >> N >> S;

	for (int i = 0; i < N; i++)
	{
		int tmp;
		std::cin >> tmp;
		arr[i] = tmp;
	}

	int left = 0;
	int right = 1;

	int sum = arr[0];
	int minLen = 100'001;

	while(true)
	{
		if (sum >= S)
		{
			minLen = minLen < right-left ? minLen : right-left;
			sum -= arr[left];
			left += 1;
		}
		else
		{
			if (right == N)break;
			sum += arr[right];
			right++;
		}
	}
	if (minLen == 100'001)
	{
		std::cout << 0;
		return 0;
	}
	std::cout << minLen;
}
