function solution(k, tangerine) {
    var answer = 0;
    let tangerineCount=[0];
    let maxArray=[];
    let count=0;
    for(let i=0;i<tangerine.length;i++)
        {
            if(!tangerineCount[tangerine[i]])tangerineCount[tangerine[i]]=0;
            tangerineCount[tangerine[i]]++;
        }
    maxArray=tangerineCount;
    maxArray=[...new Set(maxArray)];//중복제거
    maxArray.sort((a,b)=>b-a);//내림차순 정렬
    for(let i=0;i<maxArray.length;i++)
    {
        for(let j=0;j<tangerineCount.length;j++)
        {
            if(maxArray[i]===tangerineCount[j])
            {
                count+=maxArray[i];
                answer++;
                if(count>=k)return answer;
            }
        }
    }
}