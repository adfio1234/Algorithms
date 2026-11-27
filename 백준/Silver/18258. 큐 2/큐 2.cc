#include <iostream>
#include <string>
#include <unordered_map>

#pragma region 

enum class Command
{
	Push,
	Pop,
	Size,
	Empty,
	Front,
	Back,
	Count
};

const std::unordered_map<std::string, Command> commandMap =
{
	{"push",Command::Push},
	{"pop",Command::Pop},
	{"size",Command::Size},
	{"empty",Command::Empty},
	{"front",Command::Front},
	{"back",Command::Back}
};

struct Node
{
	int data;
	Node* next = nullptr;
};

class Queue
{
public:

	Queue() :_head(nullptr), _tail(nullptr), _size(0)
	{

	}

	void push(int x)
	{
		Node* node=new Node{ x };
		_size++;
		if (_head == nullptr)
		{
			_head = node;
			_tail = node;
			return;
		}
		_tail->next = node;
		_tail = node;

	}

	int pop()
	{
		if (empty())return -1;
		Node* temp = _head;

		int res = temp->data;

		_head = _head->next;
		delete temp;
		_size--;

		if (_head == nullptr)
			_tail = nullptr;

		return res;
	}

	int size()const
	{
		return _size;
	}

	bool empty() const
	{
		return _size == 0;
	}

	int front() const
	{
		if (empty())return -1;
		return _head->data;
	}

	int back() const
	{
		if (empty())return -1;
		return _tail->data; 
	}

private:
	Node* _head;
	Node* _tail;
	int _size;
};

void HandlePush(Queue& queue)
{
	int value;
	std::cin >> value;
	queue.push(value);
}
void HandlePop(Queue& queue)
{
		std::cout << queue.pop() << "\n";
}

void HandleSize(Queue& queue)
{
	std::cout << queue.size() << "\n";
}

void HandleEmpty(Queue& queue)
{
	if (queue.empty())
		std::cout << 1 << "\n";
	else
		std::cout << 0 << "\n";
}

void HandleFront(Queue& queue)
{
		std::cout << queue.front() << "\n";
}

void HandleBack(Queue& queue)
{
		std::cout << queue.back() << "\n";
}

using Handler = void(*)(Queue&);

constexpr Handler handlers[static_cast<int>(Command::Count)] =
{
	HandlePush,
	HandlePop,
	HandleSize,
	HandleEmpty,
	HandleFront,
	HandleBack
};

#pragma endregion

int main()
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);

	Queue queue;

	int N;
	std::cin >> N;
	
	for (int i = 1; i <= N; i++)
	{
		std::string command;
		std::cin >> command;

		Command type = commandMap.at(command);
		int index = static_cast<int>(type);

		handlers[index](queue);
	}
	return 0;
}

