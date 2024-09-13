function solution(id_list, report, k) {
    var answer = [];  
    var users={};//누적 신고 횟수
    let tmp="";
    for(let i=0;i<id_list.length;i++)answer.push(0);
    for(let i=0;i<id_list.length;i++)users[id_list[i]]=0;
    const setReport=[...new Set(report)];//중복은 1회로 처리한다.
    for(let i=0;i<setReport.length;i++)
        {
            const [id,report] = setReport[i].split(" ");
            users[report]++;
        }
    for(let i=0;i<setReport.length;i++)
        {
            const [id,report] = setReport[i].split(" ");
            if(users[report]>=k)
            {
                answer[id_list.indexOf(id)]++;
            }
        }
    
    return answer;
}