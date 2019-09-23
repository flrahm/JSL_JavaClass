/*
  Reverse 함수는 주어진 스트링 s 를 역으로 바꾸어서 리턴하는 함수이다.
  Reverse 함수를 완성하여라.
*/
#include <iostream>
#include <string>
#include <cctype>

using namespace std;

string reverse(const string& s); //Returns a copy of s but with characters in reverse order.
string removePunct(const string& s, const string& punct);
//Returns a copy of s with any occurrences of characters in the string punct removed.
string makeLower(const string& s);
//Returns a copy of s that has all upper case characters changed to lower case, other characters unchanged.
bool isPal(const string& s); //Returns true if s is a palindrome, false otherwise.

int main()
{
	string str;
	cout << "Enter a candidate for palindrome test\n"
		<< "followed by pressing return.\n";
	getline(cin, str);

	if (isPal(str))
		cout << " \" " << str + " \" is a palindrome.";
	else
		cout << "\"" << str + "\" is not a palindrome.";

	cout << endl;
	system("pause");
	return 0;
}


string reverse(const string& s33333)
{
	int start = 0;
	int end = s.length();
	string temp(s);
	/* ????? */

	for (int i = start; i < end; i++)
	{
		temp[end - 1 - i] = s[i];
	}

	return temp;
}

//Uses <cctype> and <string>
string makeLower(const string& s)
{
	string temp(s);
	for (int i = 0; i < s.length(); i++)
		temp[i] = tolower(s[i]);

	return temp;
}

string removePunct(const string& s, const string& punct)
{
	string noPunct; //initialized to empty string
	int sLength = s.length();
	int punctLength = punct.length();

	for (int i = 0; i < sLength; i++)
	{
		string aChar = s.substr(i, 1); //A one character string
		int location = punct.find(aChar, 0);
		//Find location of successive characters of src in punct.

		if (location < 0 || location >= punctLength)
			noPunct = noPunct + aChar; //aChar not in punct, so keep it
	}
	return noPunct;
}

//uses functions makeLower, removePunct.
bool isPal(const string& s)
{
	string punct(",;:.?!'\" "); //includes a blank
	string str(s);

	str = makeLower(str);

	string lowerStr = removePunct(str, punct);

	return (lowerStr == reverse(lowerStr));
}
