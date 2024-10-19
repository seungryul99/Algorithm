#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
map <ll,int> mp;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);
	
	int n,m;
	ll x;
	cin >> n;
	
	for(int i=0;i<n;i++){
		cin >> x;
		mp[x]=1;
	}	
	
	cin >> m;
	for(int i=0;i<m;i++){
		cin >> x;
		cout << mp[x] << "\n";
	}
}