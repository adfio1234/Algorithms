function solution(players, callings) {
    var answer = [];
    var prize={};
    let tmp="";
    for(let i=0;i<players.length;i++)
        {
            prize[players[i]]=i;
        }
    for(let i=0;i<callings.length;i++)
        {
            prize[callings[i]]--;//순위
            prize[players[prize[callings[i]]]]++;//이전사람
            tmp=players[prize[callings[i]]];
            players[prize[callings[i]]]=players[prize[callings[i]]+1];
            players[prize[callings[i]]+1]=tmp;
        }
    return players;
}