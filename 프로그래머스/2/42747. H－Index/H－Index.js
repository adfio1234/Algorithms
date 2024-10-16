function solution(citations) {
    let max=-1//최댓값을 찾아야하므로 -1로 초기화 해둔다.
    for(let i=0;i<citations.length;i++)//논문 하나하나씩 함수에 넣기위한 for문
        {
            max=max>quotation(citations[i],citations)?max:quotation(citations[i],citations);//최댓값을 구하기위한 삼항연산자.
        }
    if(max<0)max=0;
    return max;
}
function quotation(index,arr)
{
    let count=0;//index에 해당하는 숫자보다 크거나 같은 값을 저장하기위한 변수
    for(let i=0;i<arr.length;i++)
        {
            if(index<=arr[i])count++;
        }
    if(count<=index)//h번이상 인용된 논문이 h편 이상일 조건을 맟추기위한 if문
    {
        return count;
    }
    else{
        return -1;
    }
}