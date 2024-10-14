//단순하게 생각해서 모든 경우의 수를 더해서 중복을 제거하자.
function solution(elements) {
    var answer = elements;//길이가 1인 연속 부분 수열을 구함
    for(let i=2;i<=elements.length;i++)//길이가 n인 연속부분 수열을 함수로 넘겨주는 역활.
        {
            //console.log(elements);
            answer=answer.concat(add(i,elements.concat(elements)));//원형이므로 elements배열에 elements배열을 더해서 함수에 보낸다
        }
    answer=[...new Set(answer)];//중복절 제거
    return answer.length;
}
function add(n,elements)//연속되는 수열을 더하는 함수.
{
    let stack=[]//n만큼 배열을 자를 임시 배열 stack 으로 사용 예정
    let result=[]//결과값들을 저장할 배열
    let tmp;//임시값을 저장할 변수
    let tmpSum=0;//임시합을 저장할 변수
    for(let i=0;i<=elements.length/2+n-2;i++)
    {
        
        stack[stack.length]=elements[i];//stack형에 쌓기
        tmpSum+=elements[i];//tmpSum에 값저장
        if(stack.length===n)//stack으로 쌓인 개수가 n이랑 같아진다면.
        {
            result[result.length]=tmpSum;//tmpSum에 저장된값 result에 저장
            tmpSum-=stack[0];//stack에 첫번째값을 tmpSum에서 뺀다.
            stack.shift();//stack배열에 맨앞에 값을 날린다.
        }
    }
    return result;
}
