#include <bits/stdc++.h>
using namespace std;

int dy[]={0,0,1,-1}, dx[]={1,-1,0,0};  
queue<pair<int,int>> sw, water;
int r, c, adj[1504][1504], cnt, visited[1504][1504], visited_water[1504][1504];
vector <pair<int,int>> swan;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);
	string s;
	cin >> r >> c;
	
	// 맵 입력 
	for(int i=1; i<=r; i++){
		cin >> s;
		
		for(int j=0; j< s.size();j++){
			if (s[j] =='L') {
				swan.push_back({i,j+1});
				water.push({i,j+1});	
			}
			else if(s[j] == '.') water.push({i,j+1});
			else adj[i][j+1] =1 ;
		}
	}
	
	
	// 백조를 이동 시킨다
	// 두 백조가 만나면 종료
	// 아니면 얼음을 녹인다 
	
	while(1){
		queue<pair<int,int>> tmp_sw, tmp_water;
		  
		// 백조를 이동
		if(cnt==0){
			visited[swan[0].first][swan[0].second] = 1;
			sw.push({swan[0].first,swan[0].second});
		}
		
		while(sw.size()){
			pair<int,int> pi = sw.front();
			sw.pop();
			
			int y = pi.first;
			int x = pi.second;
			
			for(int w=0;w<4;w++){
				int ny = y + dy[w];
				int nx = x + dx[w];
				
				if(ny<1||nx<1||ny>r||nx>c) continue;
				if(visited[ny][nx] ==1) continue;
				visited[ny][nx] = 1;
				
				if(adj[ny][nx] == 1) tmp_sw.push({ny,nx});
				else if(adj[ny][nx] == 0) sw.push({ny,nx});
			}
		}
		
		// 정답 체크 
		if(visited[swan[1].first][swan[1].second] == 1){
			cout << cnt;
			break;
		} 
		cnt++;
		sw=tmp_sw;
		
		
		
		// 얼음을 녹임
		while(water.size()){
			pair<int,int> pi = water.front();
			water.pop();
			
			
			int y = pi.first;
			int x = pi.second;
			
			for(int w=0;w<4;w++){
				int ny = y + dy[w];
				int nx = x + dx[w];
				
				if(ny<1||nx<1||ny>r||nx>c) continue;
				if(visited_water[ny][nx] ==1) continue;
				
				visited_water[ny][nx] = 1;
				if(adj[ny][nx]==1) {
					tmp_water.push({ny,nx});
					adj[ny][nx]=0;	
				}
			}
		}
		
		water=tmp_water;
	}
}