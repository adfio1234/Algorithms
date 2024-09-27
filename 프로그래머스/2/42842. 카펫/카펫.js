function solution(brown, yellow) {
    var answer = [];
    let divisor=[];
    let yellowWidth;
    let yellowHeight;
    for(let i=1;i<=Math.sqrt(yellow);i++)
        {
            if(yellow%i===0)divisor.push(i);
        }
   
    for(let i=0;i<divisor.length;i++)
        {
            yellowHeight=divisor[i];//노란부분의 높이
            yellowWidth=(yellow/divisor[i])+2;//노란부분의 가로+2
            //yelloHeigh2개와 yellowWidth2개를 더하면 brown의 개수가나옴
            
            if(yellowHeight*2+yellowWidth*2===brown)
                {
                    answer=[yellowWidth,yellowHeight+2];
                    break;
                }
        }
    return answer;
}