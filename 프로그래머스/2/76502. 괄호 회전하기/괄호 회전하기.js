function solution(s) {
    var answer = 0;
    for(let i=0;i<s.length;i++)
        {
            if(rotate(s.slice(i+1)+s.slice(0,i+1)))answer++;//한칸씩 회전하는 함수
            
        }
    return answer;
}

function rotate(s){
    let stack=[];//stack구조 사용을 위한 배열 사용
    let tmp='';//tmp를 사용하여 괄호 매칭
    for(let i=0;i<s.length;i++)
        {
            if(stack.length===0)stack.push(s[i]);//stack이 비어있으면 쌓는다.(닫는 괄호만 들어올떄 예외처리용)
            else if(s[i]==='('||s[i]==='['||s[i]==='{')//여는 괄호가 들어오면 쌓는다.
                {
                    stack.push(s[i]);
                }
            else//닫는괄호가 들어올떄
                {
                    if(tmp!==s[i])return false;
                    else stack.pop()//괄호가 성공적으로 닫혔으므로 열린괄호 제거
                }
            if(stack[stack.length-1]==='(')tmp=')';
            if(stack[stack.length-1]==='{')tmp='}';
            if(stack[stack.length-1]==='[')tmp=']';
            
        }
    if(stack.length!==0)return false;//stack에 남아있으면 false리턴
    return true;
}