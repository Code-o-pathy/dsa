#include <iostream>
#include <vector>
using namespace std;
void addEdge(vector<int> adj[], int i, int j)
{
    adj[i].push_back(j);
    adj[j].push_back(i);
}
void printGraph(vector<int> adj[], int v)
{
    for (int i = 0; i < v; i++)
    {
            cout<<i;
        for(int x:adj[i]){
            cout<<x;
        }
        cout << endl;
    }
}
int main()
{
    int v = 4;
    vector<int> adj[v];
    addEdge(adj, 0, 1);
    addEdge(adj, 0, 2);
    addEdge(adj, 1, 2);
    addEdge(adj, 1, 3);
    printGraph(adj,v);
    return 0;
}