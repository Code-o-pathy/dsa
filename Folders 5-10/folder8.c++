//     //learning stl
// folder 7 vid 1
#include <iostream>
#include <vector>
#include <deque>
#include <list>
#include <queue>
#include <set>
#include <algorithm>
#include <array>
using namespace std;
// struct Point
// {
//     int x, y;
// };
// bool myCmp(Point p1, Point p2)
// {
//     return (p1.y > p2.y);
// }
int main()
{
    // Point arr[]={{2,5},{3,4},{1,3}};
    // sort(arr,arr+3,myCmp);
    // for(auto i:arr){
    //     cout<<i.x<<" "<< i.y<<endl;
    // }
    //     vector<int> v;

    //     v.push_back(4);
    //     v.push_back(2);
    //     v.push_back(3);
    //     cout<<"capacity"<<v.back() <<endl;
    //  vector<int> Now(v);
    // //   for(int i:Now){
    // //     cout<<i<<" "<<endl;
    // //  }
    //     cout<< v.at(2)<<"i "<<endl;
    //    v.clear();

    //  for(int i:v){
    //     cout<<i<<" "<<endl;
    //  }
    // deque<int> c(5,100);//initialize with size 5 and alll elements as 100 // works in deque  list and vector
    // deque<int> a;
    // deque<int> b(a);//cant copy like this in deque unlike list and vector
    // b.push_back(2);
    // a.push_front(3);
    // a.push_front(4);
    // a.push_front(5);
    //     cout << b.size() << endl;
    // for (int i : b)
    // {
    //     cout << i << endl;
    // }
    // // a.erase();
    // cout << "popinh" << endl;
    // // a.erase(a.begin());
    // for (int i : c)
    // {
    //     cout << i << endl;
    // }
    // a.size();
    // a.max_size();
    // cout << a.max_size();

    // queue<int> f;

    // //push,pop,front,size,empty
    // priority_queue<int> z;
    // z.push(3);
    // z.push(4);
    // priority_queue<int, vector<int>, greater<int>> x;
    // x.push(3);
    // x.push(4);
    // x.push(5);
    // cout<<x.top()<<endl;
    // x.pop();//pops first element

    // cout<<x.top();
    // set<int> a;
    // a.insert(3);
    // a.insert(34);
    // a.insert(4);
    // a.insert(6);
    // for (int i : a)
    // {
    //     cout << i << endl; // prints in ordered form
    // }
    // cout << "erasing" << endl;

    // // set , count to find and find to get the iteration of it in the set
    // set<int>::iterator it = a.begin();
    // it++;
    // it++;
    // a.erase(it);

    //     for (int i : a)
    // {
    //     cout << i << endl; // prints in ordered form
    // }
    // int arr[]={12,32,5,6,654,23};
    // sort(arr,arr+6);
    // for(int i:arr){
    //     cout<<i<<endl;
    // }
    // sort(arr,arr+6,greater<int>());
    // for(int i:arr){
    //     cout<<i<<endl;
    // }

    // vector<int> v={23,34,2,4,33};
    // sort(v.begin(),v.end());
    // for(int i:v){
    //     cout<<i<<endl;
    // }

    // v8 concepts start here

    // u can create multi dimensional array with many different methods, by the one below or by pointer orr vecctor

    // int arr[][3] = {{2, 3}, {4, 5}, {6, 7}};
    // int n = 3;
    // int m = 2;
    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         cout << arr[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    // pointer method

    // this methods adv and dis
    // adv u can create the arrays of variable length like u can place i instad of n in->         arr[i]=new int[n]; and then u have array of 1 space at i=1 ; and so on
    // dis- since this arrays are pointed to, this means that they are not at same place in memory and thas why it can haave cache misses;
    // the double pointer works like a variable arr points to array of arrays, where everyone i of array holds an array too;

    int m = 4;
    int n = 2;
    // int **arr;//int *arr[] for array of pointers method
    // arr=new int*[m];
    // for(int i=0;i<m;i++){
    //     arr[i]=new int[n];
    // }
    // for(int i=0;i<m;i++){
    //     for(int j=0;j<n;j++){
    //         arr[i][j]=10+i;
    //         cout<<arr[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

    // array of pointers
    // working-same like previous only diff is that the there is an actual array in contiguous location in memory and just the second dim of arrays is pointer;
    // changes in code;above

    // array of vectors;
    // vector<int> arr[m];
    // for (int i = 0; i < m; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         arr[i].push_back(10+i);

    //     }
    // }

    // for (int i = 0; i < m; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         cout << arr[i][j] << " ";
    //     }
    // }

    // //vector of vectors
    //     vector<vector<int>> arr;
    // for (int i = 0; i < m; i++)
    // {
    //     vector<int> v;

    //     for (int j = 0; j < n; j++)
    //     {
    //        v.push_back(10+i);

    //     }
    //     arr.push_back(v);
    // }

    // for (int i = 0; i < arr.size(); i++)
    // {
    //     for (int j = 0; j < arr[i].size(); j++)
    //     {
    //         cout << arr[i][j] << " ";
    //     }
    // }



}