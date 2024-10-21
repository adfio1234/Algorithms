function solution(n, left, right) {
    var answer = [];
    answer=newArr(left,right,n);
    return answer;
}
function newArr(left,right,n)//1차원 배열로 만드는 함수
{
    let arr=[];//배열을 리턴하기위한 배열
    let index=0;
    for(let i=left;i<=right;i++)//left에서 right까지
        {
            index=parseInt(i/n)>i%n?parseInt(i/n):i%n;//열은 i/n이고 행은 i%n으로 표현되는데 여기서 1을 더해주고 더 큰값이 그자리에 값이다.
            arr.push(index+1);
        }
    return arr;
}

