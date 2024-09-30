function solution(n,a,b)
{
    var answer = 0;
    let tmp=[];
    a>b?(tmp.push(b),tmp.push(a)):(tmp.push(a),tmp.push(b));
    for(let i=0;i<=n/2;i++)
        {
            if(tmp[0]%2!==0)
            {
                if(tmp[0]===tmp[1]-1)
                {
                    answer=i+1;
                    break;
                }
            }
            tmp[0]=Math.ceil(tmp[0]/2);
            tmp[1]=Math.ceil(tmp[1]/2);
        }
    return answer;
}
// 12 34 56 78
// 12 34
// 12