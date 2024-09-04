function solution(today, terms, privacies) {
    var answer = [];
    let dic={};
    let date=today.split('.');
    let day;
    let alpha;
    for(let i=0;i<date.length;i++)date[i]=parseInt(date[i]); 
    for(let i=0;i<terms.length;i++) dic[terms[i][0]]=parseInt(terms[i].slice(2,terms[i].length));
    console.log(date);
    for(let i=0;i<privacies.length;i++)
    {
        alpha=privacies[i][11];
        day=privacies[i].slice(0,privacies[i].length-2).split('.');
        for(let j=0;j<day.length;j++)day[j]=parseInt(day[j]);
        day[1]+=dic[alpha];
        if(day[1]>12)
            {
                day[0]+=parseInt(day[1]/12);
                day[1]%=12;
                if(day[1]===0)
                {
                    day[0]-=1;
                    day[1]=12;
                }      
            }
        console.log(day);
        if(date[0]>day[0])answer.push(i+1);
        else if(date[0]===day[0]&&date[1]>day[1])answer.push(i+1);
        else if(date[0]===day[0]&&date[1]===day[1]&&date[2]>=day[2])answer.push(i+1);
    }
    return answer;
}