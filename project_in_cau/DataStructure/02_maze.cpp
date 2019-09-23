/*  실습 2
   다음은 미로에서 path 를 찾는 프로그램이다.

   a) 현재 이 프로그램은 미로에서 나가는 path 를 출력하고 있다.

   b) 이 프로그램을 변경해서 함수 path 의 동작을 추적하고 출력하도록 하여라.
	  즉, path 함수가 미로를 나가는 길의 후보 path 를 모두 출력하여라.
*/

#include <iostream>
using namespace std;

#define MAX_STACK_SIZE 100

struct element {
	short int row;
	short int col;
	short int dir;
};
element stack[MAX_STACK_SIZE];
int top = -1;

void push(element item)
{
	if (top >= MAX_STACK_SIZE - 1)
	{
		cout << "Stack is Full" << endl;
		exit(EXIT_FAILURE);
	}
	stack[++top] = item;
}

element pop()
{
	if (top == -1)
	{
		cout << "Stack is Empty" << endl;
		exit(EXIT_FAILURE);
	}
	return stack[top--];
}

struct offsets {
	int vert;
	int horiz;
};
offsets mov[8] = { { -1, 0 },{ -1, 1 },{ 0, 1 },{ 1, 1 },{ 1, 0 },{ 1, -1 },{ 0, -1 },{ -1, -1 } };

short int maze[11][8] = {
1, 1, 1, 1, 1, 1, 1, 1,
1, 0, 0, 0, 0, 0, 0, 1,
1, 0, 1, 1, 1, 1, 0, 1,
1, 0, 0, 0, 0, 1, 1, 1,
1, 1, 1, 1, 0, 1, 1, 1,
1, 1, 0, 0, 0, 0, 0, 1,
1, 1, 0, 1, 1, 1, 0, 1,
1, 1, 0, 0, 0, 1, 1, 1,
1, 0, 1, 1, 1, 1, 1, 1,
1, 1, 0, 0, 0, 0, 0, 1,
1, 1, 1, 1, 1, 1, 1, 1 };
short int mark[11][8] = { 0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0, 0 };

int EXIT_ROW = 9;
int EXIT_COL = 6;

void path()
{
	int i, row, col, nextRow, nextCol, dir;
	bool found = false;

	element position;

	mark[1][1] = 1;
	position.row = 1; position.col = 1; position.dir = 1;
	push(position);

	// row  현재 행
	// col  현재 열
	// dir  진행할 방향

	while (top > -1 && !found) {
		position = pop(); // path 를 한 번 거슬러 올라옴
		row = position.row; col = position.col;
		dir = position.dir;
		dir++; // 지난 번에 갔던 방향말고 다른 방향을 시도


		bool t = false;


		while (dir < 8 && !found) {
			nextRow = row + mov[dir].vert;
			nextCol = col + mov[dir].horiz;

			// [nextRow][nextCol] 이 갈 수 있는 방향이라면
			//     1)  현재위치 [row][col] 를 저장
			//     2)  다음 위치로 이동  row=nextRow, col=nextCol
			// 갈 수 없는 방향이라면
			//     3)  다음 방향으로 진행
			if (!maze[nextRow][nextCol] && !mark[nextRow][nextCol]) {
				// 1)
				mark[nextRow][nextCol] = 1;
				position.row = row; position.col = col; position.dir = dir;
				push(position);
				t = true;
				// 2)
				row = nextRow; col = nextCol; dir = 0;
				if (row == EXIT_ROW && col == EXIT_COL) {
					found = true;
					position.row = row; position.col = col; position.dir = dir;
					push(position);


				}

			}
			else dir++;  //3




		}

		if ((t == true) && (found == false)) {

			for (i = 0; i < top; i++) {
				cout << "(" << stack[i].row << "    " << stack[i].col << "), ";
			}
			cout << "(" << position.row << "    " << position.col << "), ";
			cout << "(" << row << "    " << col << "), ";
			cout << " dead end " << endl;

		}



	}

	if (found) {
		cout << " The Path is \n";
		cout << " row    col\n";
		for (i = 0; i < top; i++)
			cout << "(" << stack[i].row << "    " << stack[i].col << "), ";
	}
	else cout << "The maze does not have a path " << endl;
}


int main()
{
	cout << " MAZE PROBLEM " << endl;

	for (int i = 0; i < 11; i++) {
		for (int j = 0; j < 8; j++)
			cout << maze[i][j] << " ";
		cout << endl;
	}

	path();
	system("pause");
}