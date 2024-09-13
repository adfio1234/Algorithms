function solution(park, routes) {
    let cur=[];//Y X
    for(let i=0;i<park.length;i++)
        {
            for(let j=0;j<park[i].length;j++)
                {
                    if(park[i][j]==='S')
                        {
                            cur.push(i);
                            cur.push(j);
                        }
                }
        }
    let distance;
    for(let i=0;i<routes.length;i++)
        {
            distance=parseInt(routes[i][2]);
            switch(routes[i][0])
                {
                    case 'E':
                        {
                            if(park[0].length-1>=cur[1]+distance)
                            {
                                
                                cur[1]+=distance;
                                for(let j=cur[1]-distance;j<=cur[1];j++)
                                {
                                    
                                    if(park[cur[0]][j]==='X')
                                        {
                                            cur[1]-=distance;
                                            break;
                                        }
                                }
                                
                            }
                            
                            break;
                        }
                    case 'W':
                        {
                            if(0<=cur[1]-distance)
                            {
                                cur[1]-=distance;
                                for(let j=cur[1]+distance;j>=cur[1];j--)
                                {
                                    if(park[cur[0]][j]==='X')
                                        {
                                            cur[1]+=distance;
                                            
                                            break;
                                        }
                                }   
                            }
                            
                            break;
                        }
                    case 'S':
                        {
                            if(park.length-1>=cur[0]+distance)
                            {
                                cur[0]+=distance;
                                for(let j=cur[0]-distance;j<=cur[0];j++)
                                    {
                                       if(park[j][cur[1]]==='X')
                                          {
                                             cur[0]-=distance;
                                             break;
                                          }
                                     }
                            }
                            break;
                        }
                    case 'N':
                        {
                            if(0<=cur[0]-distance)
                            {
                                cur[0]-=distance;
                                for(let j=cur[0]+distance;j>=cur[0];j--)
                                {
                                    if(park[j][cur[1]]==='X')
                                        {
                                            cur[0]+=distance;
                                            break;
                                        }
                                }   
                            }
                            
                            break;
                        }    
                }
        }
    return cur;
}