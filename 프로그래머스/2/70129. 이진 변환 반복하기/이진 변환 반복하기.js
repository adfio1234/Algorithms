function solution(s) {
    var answer = [];
    let zeroCount=0;
    let repeat=0;
    while(s!=='1')
        {
            for(let i=0;i<s.length;i++)
            {
                if(s[i]==='0')zeroCount++;//0의개수는 제거한 0의 개수와 동일하다.
            }
            s = s.replaceAll('0','');//replaceAll()를 사용하여 0제거
            s=s.length.toString(2);//toString(2)를 사용하여 이진수 변환
            repeat++;//변환 횟수 +
        }
    answer.push(repeat);
    answer.push(zeroCount);  
    return answer;
}