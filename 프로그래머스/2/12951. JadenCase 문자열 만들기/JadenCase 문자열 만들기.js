function solution(s) {
    var answer = '';
    s=s.toLowerCase();
    answer=s.split('');
    answer[0]=answer[0].toUpperCase();
    for(let i=0;i<answer.length;i++)
    {   
        if(answer[i]===' ')
        {
            for(let j=i;j<answer.length;j++)
                {
                    if(answer[j]!==' ')
                        {
                            i=j;
                            break;
                        }
                }
            answer[i]=answer[i].toUpperCase();
        }
        
    }
    answer=answer.join('');
    return answer;
}