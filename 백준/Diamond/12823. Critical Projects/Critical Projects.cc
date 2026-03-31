#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> g(N + 1), rg(N + 1);
    vector<int> indeg(N + 1, 0);

    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        rg[v].push_back(u);
        indeg[v]++;
    }

    // 위상정렬
    queue<int> q;
    for (int i = 1; i <= N; i++) {
        if (indeg[i] == 0) q.push(i);
    }

    vector<int> topo;
    topo.reserve(N);

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        topo.push_back(cur);

        for (int nxt : g[cur]) {
            if (--indeg[nxt] == 0) q.push(nxt);
        }
    }

    // pos[v] = 위상정렬에서 v의 위치 (1-based)
    // rev[i] = 위상정렬 i번째 정점 번호
    vector<int> pos(N + 1), rev(N + 1);
    for (int i = 0; i < N; i++) {
        pos[topo[i]] = i + 1;
        rev[i + 1] = topo[i];
    }

    vector<int> L(N + 1, 0), R(N + 1, N + 1);

    // L[v] 계산
    for (int v = 1; v <= N; v++) {
        for (int pre : rg[v]) {
            L[v] = max(L[v], pos[pre]);
        }
    }

    // R[v] 계산
    for (int v = 1; v <= N; v++) {
        for (int nxt : g[v]) {
            R[v] = min(R[v], pos[nxt]);
        }
    }

    // diff 배열로 "critical 불가능한 위치" 마킹
    vector<int> diff(N + 3, 0);

    auto add_range = [&](int l, int r) {
        if (l > r) return;
        diff[l]++;
        diff[r + 1]--;
    };

    for (int v = 1; v <= N; v++) {
        int p = pos[v];

        // [L[v]+1, p-1]
        add_range(L[v] + 1, p - 1);

        // [p+1, R[v]-1]
        add_range(p + 1, R[v] - 1);
    }

    vector<int> ans;
    int cur = 0;
    for (int i = 1; i <= N; i++) {
        cur += diff[i];
        if (cur == 0) {
            ans.push_back(rev[i]);
        }
    }

    sort(ans.begin(), ans.end());

    cout << ans.size() << '\n';
    if (!ans.empty()) {
        for (int i = 0; i < (int)ans.size(); i++) {
            if (i) cout << ' ';
            cout << ans[i];
        }
        cout << '\n';
    }

    return 0;
}