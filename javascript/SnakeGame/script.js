let snake = document.getElementById('snake');
let left=0;
let top1=0;
let leftSide,rightSide,upSide,downSide;
let width=screen.availWidth;
let height=screen.availHeight;
let foodItem1 = document.getElementById('food');
let rhNumber;
let rwNumber;
// console.log(height);
// console.log(width);
setFoodItem();
function setLeft(){
    clear();
   leftSide= setInterval(moveLeft,10);
}
function setRight(){
    clear();
    rightSide= setInterval(moveRight,10);
}
function setUp(){
    clear();
    upSide=setInterval(moveUp,10);
}
function setDown(){
    clear();
    downSide=setInterval(moveDown,10);
}
function setFoodItem(){
    setInterval(foodItem,1000);
}
function clear(){
    clearInterval(leftSide);
    clearInterval(rightSide);
    clearInterval(upSide);
    clearInterval(downSide);

}

function moveLeft(){
    if(left<=0){
        left=width-80;
    }
    left-=1;
    snake.style.left=left+"px";
    
}
function moveRight(){
    if(left>=width){
        left=0;
    }
    left+=1;
    snake.style.left=left+"px";
}
function moveUp(){
    // console.log("up clicked");
    if(top1<=0){
        top1=height;
    }
    top1-=1;
    snake.style.top=top1+"px";
}
function moveDown(){
    // console.log("down clicked");
    if(top1>=height){
        top1=0;
    }
    top1+=1;
    snake.style.top=top1+"px";
}
function foodItem(){
    rhNumber = parseInt(Math.random()*height);
    console.log(rhNumber);
    rwNumber = parseInt(Math.random()*width);
    console.log(rwNumber);
    foodItem1.style.marginTop=rhNumber+"px";
    foodItem1.style.marginLeft=rwNumber+"px";

}