function solution(arr) {
    for(let i=0;i<arr.length;i++)
        {
            for(let j=i+1;j<arr.length;j++)
                {
                    if(arr[j]%arr[i]===0)
                        {
                            arr.splice(i,1);
                            break;
                        }
                }
        }
    return getMultiLcm(arr);
}
function getLcm(num1,num2){
    let multipleNum1Num2=num1*num2;
    while(num2>0)
        {
            let tmp=num1%num2;
            num1=num2;
            num2=tmp;
        }
    return multipleNum1Num2/num1; 
}
function getMultiLcm(arr)
{
    let tmp=arr[0];
    for(let i=1;i<arr.length;i++)
        {
            tmp=getLcm(tmp,arr[i]);
        }
    return tmp
}