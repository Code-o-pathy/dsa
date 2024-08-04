#include <iostream>
#include <queue>
using namespace std;
int main(){

    queue<int> q;
    q.push(19);
    q.push(20);
    q.push(21);
    cout<<q.size()<<endl;
    q.pop();
    cout<<q.size()<<endl;
    cout<<q.front()<<endl;
    cout<<q.back()<<endl;
    cout<< q.empty()<<endl;
    cout<< q.size()<<endl;

}