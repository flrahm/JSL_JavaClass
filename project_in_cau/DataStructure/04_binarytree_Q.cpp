#include <iostream>
using namespace std;

struct node {
	char data;
	node *left;
	node *right;
};
typedef node* treePtr;
typedef char tree;

void inorder(treePtr ptr)
{
	if (ptr) {
		inorder(ptr->left);
		cout << ptr->data;
		inorder(ptr->right);
	}
}

void preorder(treePtr ptr)
{
	if (ptr) {
		cout << ptr->data;
		preorder(ptr->left);
		preorder(ptr->right);
	}
}

void postorder(treePtr ptr)
{
	// Q2. postorder traversal
	if (ptr) {
		preorder(ptr->left);
		preorder(ptr->right);
		cout << ptr->data;

	}

}

// Q3. push
// push "node" to stack "st". stacks's top is "t"
void push(int& t, treePtr* st, treePtr node)
{
	st[++t] = node;
}

// Q3. pop
// pop and return node from stack "st". stack's top is "t"
treePtr pop(int& t, treePtr* st)
{
	return st[t--];
}

void iter_inorder(treePtr node)
{
	// Q3. Iterative version inorder traversal 
	int t = -1;
	treePtr stack[100];

	while (1) {
		while (node) {
			push(t, stack,node);
			node = node->left;
		}
		node = pop(t, stack);
		if (!node) break;
		cout << node->data;
		node = node->right;

	}

	
}


treePtr copy(treePtr original)
{
	// Q4. Tree Copy 
	treePtr temp;

	temp = original;
	return temp;
	

}

int equal(treePtr first, treePtr second)
{
	return((!first && !second) || (first && second && (first->data == second->data)
		&& equal(first->left, second->left) &&
		equal(first->right, second->right)));
}

void make_tree(char c, treePtr l, treePtr r, treePtr& tr)
{
	treePtr temp;
	temp = new node;

	temp->data = c;
	temp->left = l;
	temp->right = r;

	tr = temp;
}

int main()
{
	/*
	Figure 5.16 산술식을 표현한 이진 트리는 다음과 같다.
	*/

	treePtr l, r, tr, tr2;
	tr = NULL; tr2 = NULL;

	make_tree('A', NULL, NULL, l);
	make_tree('B', NULL, NULL, r);
	make_tree('/', l, r, l);
	make_tree('C', NULL, NULL, r);
	make_tree('*', l, r, l);
	make_tree('D', NULL, NULL, r);
	make_tree('*', l, r, l);
	make_tree('E', NULL, NULL, r);
	make_tree('+', l, r, tr);

	inorder(tr); cout << endl;
	preorder(tr); cout << endl;
	postorder(tr); cout << endl;
//	iter_inorder(tr); cout << endl;

	l = copy(tr);
	inorder(l); cout << endl;
	cout << equal(l, tr) << endl;

	// Q1. 리스트로 트리 생성하여 tr2 로 함
	// inorder traversal 로 출력하면 다음과 같이 되는 수식의 tree 를 생성하라
	// a + b * c + 7
	treePtr ll, rr;
	make_tree('a', NULL, NULL, ll);
	make_tree('b', NULL, NULL, rr);
	make_tree('+', l, r, ll);
	make_tree('c', NULL, NULL, rr);
	make_tree('*', l, r, ll);
	make_tree('7', NULL, NULL, rr);
	make_tree('+', l, r, tr2);


	cout << equal(tr, tr2) << endl;
	l = copy(tr2);
	cout << equal(tr, l) << endl;
	
	inorder(l); cout << endl;

	system("pause");
	return 0;
}