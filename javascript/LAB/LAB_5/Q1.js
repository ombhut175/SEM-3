let num1;
let num2;
let step=0;
let operator;
let operator1;
let operator2;
let check1 = false;
let check2 = 0;
let result=0;
let display = document.getElementById('display');
let firstNumArr=[];
let secondNumArr=[];
let newNum=0;
let clicked = 0;
numberInput=(num)=>{
    if(step==0 || step==1){
        firstNumArr.push(num);
        num1=Number(firstNumArr.join(''));
        display.value=num1;
        step=1;
        if(clicked==0){
            clicked++;
        }
    }
    else if(step==2){
        secondNumArr.push(num);
        num2=Number(secondNumArr.join(''));
        display.value=num2;
        if(clicked>=1){
            clicked++;
        }
    }
};
//5 + 3 - 4 +
/* 
    num1 = 8
    operator1 = +
    num2 = 4
    operator2 = -

*/
//click=2
getOperator=(op)=>{
    step=2;
    if(!check1){
            operator1=operator2;
            check1=true;
            operator1=op; //+
            console.log('check 1 '+op);
            check1=true;
    }else{
        // check2=true;
        if(check2>0){
            operator1=operator2;
        }
        operator2=op; // +
        check2++;
        console.log('check 2 '+op);
    }
    display.value=op;
    if(clicked>=2){
        num1 = performOperation(operator1);
        console.log('entered '+num1);
    }
};

performOperation = (op)=>{
    switch (op) {
        case '+':
            result=num1+num2;
            break;
        case '-':
            result=num1-num2;
            break;
        case '*':
            result=num1*num2;
            break;
        case '/':
            result=num1/num2;
        default:
            break;
    }    
    secondNumArr=[];
    return result;
};

getEqualTo=()=>{
    if(clicked<=2){
        result=performOperation(operator1);
    }
    else{
        result=performOperation(operator2);
    }
    display.value=result;
    firstNumArr=[];
    secondNumArr=[];
    num1=0;
    num2=0;
    check1 = false;
    check2 = 0;
    step=0;
    clicked=0;


};

getDecimal=(op)=>{
    
};