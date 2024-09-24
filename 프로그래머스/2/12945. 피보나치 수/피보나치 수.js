function solution(n) {
    var answer = 0;
    let fibonacci=[0,1,1];
    for(let i=2;i<n;i++)
        {
            fibonacci[0]=fibonacci[1];
            fibonacci[1]=fibonacci[2];
            fibonacci[2]=(fibonacci[0]+fibonacci[1])%1234567;
        }
    answer=fibonacci[2];
    return answer;
}