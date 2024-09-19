function solution(s) {
    var answer = '';
    let arr=s.split(' ');
    for(let i=0;i<arr.length;i++)arr[i]=parseInt(arr[i]);
    arr.sort(function (a,b){return a-b;});
    answer+=arr[0];
    answer+=" ";
    answer+=arr[arr.length-1];
    return answer;
}