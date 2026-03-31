#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    long long A, B;
    cin >> n >> m >> A >> B;

    vector<long long> x(n + 1), y(n + 1);
    vector<int> west, east;

    for (int i = 1; i <= n; i++) {
        cin >> x[i] >> y[i];
        if (x[i] == 0) west.push_back(i);
        if (x[i] == A) east.push_back(i);
    }

    vector<vector<int>> g(n + 1), rg(n + 1);
    g.reserve(n + 1);
    rg.reserve(n + 1);

    for (int i = 0; i < m; i++) {
        int c, d, k;
        cin >> c >> d >> k;
        g[c].push_back(d);
        rg[d].push_back(c);
        if (k == 2) {
            g[d].push_back(c);
            rg[c].push_back(d);
        }
    }

    // 1) Multi-source DFS/BFS from all west vertices
    vector<char> reachFromWest(n + 1, 0);
    vector<int> st;
    st.reserve(n);

    for (int s : west) {
        if (!reachFromWest[s]) {
            reachFromWest[s] = 1;
            st.push_back(s);
        }
    }

    while (!st.empty()) {
        int v = st.back();
        st.pop_back();
        for (int to : g[v]) {
            if (!reachFromWest[to]) {
                reachFromWest[to] = 1;
                st.push_back(to);
            }
        }
    }

    // Reachable east vertices only, sorted by y ascending
    vector<int> eastReachable;
    eastReachable.reserve(east.size());
    for (int v : east) {
        if (reachFromWest[v]) eastReachable.push_back(v);
    }

    sort(eastReachable.begin(), eastReachable.end(),
         [&](int a, int b) { return y[a] < y[b]; });

    vector<int> eastIndex(n + 1, 0);
    for (int i = 0; i < (int)eastReachable.size(); i++) {
        eastIndex[eastReachable[i]] = i + 1; // 1-based
    }

    // 2) Reverse graph sweep for minimum reachable east index
    vector<int> minIdx(n + 1, 0), maxIdx(n + 1, 0);

    for (int s : eastReachable) {
        int idx = eastIndex[s];
        if (minIdx[s]) continue;

        minIdx[s] = idx;
        st.push_back(s);

        while (!st.empty()) {
            int v = st.back();
            st.pop_back();
            for (int to : rg[v]) {
                if (!minIdx[to]) {
                    minIdx[to] = idx;
                    st.push_back(to);
                }
            }
        }
    }

    // 3) Reverse graph sweep for maximum reachable east index
    for (int t = (int)eastReachable.size() - 1; t >= 0; t--) {
        int s = eastReachable[t];
        int idx = eastIndex[s];
        if (maxIdx[s]) continue;

        maxIdx[s] = idx;
        st.push_back(s);

        while (!st.empty()) {
            int v = st.back();
            st.pop_back();
            for (int to : rg[v]) {
                if (!maxIdx[to]) {
                    maxIdx[to] = idx;
                    st.push_back(to);
                }
            }
        }
    }

    // Output west vertices in decreasing y order
    sort(west.begin(), west.end(),
         [&](int a, int b) { return y[a] > y[b]; });

    for (int v : west) {
        if (maxIdx[v] == 0) cout << 0 << '\n';
        else cout << (maxIdx[v] - minIdx[v] + 1) << '\n';
    }

    return 0;
}