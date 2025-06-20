function solution(numbers, hand) {
    var answer = '';
    let left=10,right=12;//왼손과 오른손의 현재위치를 저장할변수
    for(let i=0;i<numbers.length;i++)
        {
            if(numbers[i]===1||numbers[i]===4||numbers[i]===7)
                {
                    answer+='L';
                    left=numbers[i];
                }
            else if(numbers[i]===3||numbers[i]===6||numbers[i]===9)
                {
                    answer+='R';
                    right=numbers[i];
                }
            else
            {
                let leftDistance=distance(numbers[i],left);
                let rightDistance=distance(numbers[i],right);
                if(leftDistance===rightDistance)
                    {
                        if(hand==='right')answer+='R';
                        else answer+='L';
                    }
                
                else if(leftDistance<rightDistance) answer+='L';
                else answer+='R';
                
                if(answer[answer.length-1]==='R')right=numbers[i];
                else left=numbers[i];
                
            }
        }
    return answer;
}

function distance(target,cur)//타겟까지의 거리를 구하는 함수.
{
    if(target===0)target=11;
    if(cur===0)cur=11;
    let move=parseInt(Math.abs(target-cur)/3)+Math.abs(target-cur)%3;
    return move;
}
//손가락은 상하좌우 거리는1로
//가운데열누를떄는 더 가까운 손가락
//거리가같다면 왼손인지 오른손잡이인지
// 123
// 456
// 789
// *0#
//0을 11로 취급