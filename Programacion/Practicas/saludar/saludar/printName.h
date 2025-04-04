#pragma once
#include <iostream>

using namespace std;

class printName
{
	string name;
public:
	void set_name(const string& name) {
		this->name = name;
	}

	void print_name() {
		cout << this->name << ", pim pam pum toma saludito papi! ;P" << endl;
	}
};
