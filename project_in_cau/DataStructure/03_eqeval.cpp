/*  �ǽ� 3

������ Postfix ������ ����ϴ� ���α׷��̴�.

*/


#include <iostream>
using namespace std;

/****************************************************************************/
//  STACK
#define MAX_STACK_SIZE 5
int stack[MAX_STACK_SIZE];
int top = -1;

void push(int item)
{
	if (top >= MAX_STACK_SIZE - 1)
	{
		cout << "Stack is Full" << endl;
		exit(EXIT_FAILURE);
	}
	stack[++top] = item;
}

int pop()
{
	if (top == -1)
	{
		cout << "Stack is Empty" << endl;
		exit(EXIT_FAILURE);
	}
	return stack[top--];
}

/****************************************************************************/
// ����
enum { lparen, rparen, Plus, Minus, times, divide, mod, eos, operand };

// getToken
// input:   expr ����
//          n �ε���
// output:  symbol ������ n��° ĳ����
//          ���ϰ��� ��ȣ
//
int getToken(char* expr, int& n, char& symbol)
{
	symbol = expr[n];

	switch (symbol) {
	case '(': return lparen;
	case ')': return rparen;
	case '+': return Plus;
	case '-': return Minus;
	case '/': return divide;
	case '*': return times;
	case '%': return mod;
	case '\0': return eos;
	default: return operand;
	}
}

// evaluate postfix expression
int eval(char* expr) // 12+7*
{
	int token;
	char symbol;
	int op1, op2;
	int n = 0;
	int top = -1;
	token = getToken(expr, n, symbol);
	int temp = 0;

	while (token != eos) {
		if (token == operand) {
			push(expr[n] - '0');	// ���ڸ� ���ÿ� Ǫ��
			top++;
		}
		else {
			op1 = stack[top - 1];
			op2 = stack[top];
			cout << op1 << "   " << op2 << endl;

			switch (expr[n])
			{
			case '+':
				temp = stack[top - 1] + stack[top];
				pop();
				pop();
				push(temp);
				top--;
				break;
			case '-' :
				temp = stack[top - 1] - stack[top];
				pop();
				pop();
				push(temp);
				top--;
				break;
			case '*':
				temp = stack[top - 1] * stack[top];
				pop();
				pop();
				push(temp);
				top--;
				break;
			case '/':
				temp = stack[top - 1] / stack[top];
				pop();
				pop();
				push(temp);
				top--;
				break;


			}






			// �����ڸ� 
			// ���ÿ��� �� ���� ���Ͽ���
			// �ش� ������ �����ϰ� 
			// �� ����� ���ÿ� Ǫ��

		}
		n++;
		token = getToken(expr, n, symbol);
	}
	return pop();
}

int main()
{
	char *expr = "12+7*";

	int p = eval(expr);
	cout << endl << expr << " = ";
	cout << p << endl << endl;

	system("pause");

	return 0;
}