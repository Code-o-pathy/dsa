#include <iostream>
#include <stack>
#include <vector>
using namespace std;

struct Node
{
    int data;
    Node *next;
    Node(int x)
    {
        data = x;
        next = NULL;
    }
};

struct linkedStack
{
    Node *head;
    int sz;
    linkedStack()
    {
        head == NULL;
        sz = 0;
    }

    int size()
    {
        return sz;
    }

    int peek()
    {
        if (head == NULL)
        {
            return INT32_MAX;
        }

        return head->data;
    }

    void push(int x)
    {

        Node *temp = new Node(x);
        temp->next = head;
        head = temp;
        sz++;
    }

    int pop()
    {
        if (head == NULL)
        {
            return INT32_MAX;
        }
        int res = head->data;
        sz--;
        Node *temp = head;
        head = head->next;
        delete (temp);
        return res;
    }
    bool empty()
    {
        return (sz == 0);
    }
};
struct MyStack
{
    int *arr;
    int cap;
    int top;
    MyStack(int c)
    {
        cap = c;
        arr = new int[cap];
        top = -1;
    }
    void push(int x)
    {
        if (top == cap - 1)
        {
            cout << "overflow";
        }
        else
        {
            top++;
            arr[top] = x;
        }
    }
    int pop()
    {
        if (top == -1)
        {
            cout << "underflow";
            return -1;
        }
        else
        {

            int res = arr[top];
            top--;
            return res;
        }
    }
    int peek()
    {
        if (top == -1)
        {
            cout << "underflow";
            return -1;
        }
        else
        {
            return arr[top];
        }
    }
    int size()
    {
        return (top + 1);
    }
    bool isEmpty()
    {
        return (top == -1);
    }
};
struct myVectorStack
// for dynamic stack size
{
    vector<int> v;
    void push(int x)
    {
        v.push_back(x);
    }
    int pop()
    {

        int res = v.back();
        v.pop_back();
        return res;
    }
    int peek()
    {

        return v.back();
    }
    int size()
    {
        return (v.size());
    }
    bool isEmpty()
    {
        return (v.empty());
    }
};

int main()
{
    // MyStack s(2);
    // cout << s.size() << endl; //0
    // cout << s.isEmpty() << endl; //1 true
    // s.push(12);
    // // s.push(14);
    // cout << s.peek() << endl; //14
    // cout << s.size() << endl;//2
    // cout << s.isEmpty()<<endl;//0 false
    // s.pop();
    // cout << s.size() << endl;
    // cout << s.isEmpty()<<endl;
    // cout<<s.peek();
    // s.push(12);
    // s.pop();
    // s.peek();

    // myVectorStack c;
    // cout << c.isEmpty();

    // linkedStack s;
    // cout << s.empty() << endl;
    // s.push(12);
    // s.push(13);
    // s.push(14);
    // // int res=s.pop();
    // // cout<<res<<endl;
    // cout << s.empty() << endl;
    // cout << s.size() << endl;

    //stack STL
    //all push pop size top empty emplace are O(1)
    
    stack<int> s;
    s.push(23);
    s.push(22);
    s.push(24);
    s.emplace(78);

    cout<<s.top()<<endl;
    cout<<s.size();


    return 0;
}
