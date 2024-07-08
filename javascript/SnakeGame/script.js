let snake = document.getElementById('snake');
let left=0;
let top1=0;
let leftSide,rightSide,upSide,downSide;
let width=1400;
let height=650  ;
let foodItem1 = document.getElementById('food');
console.log("available height = "+screen.availHeight);
console.log("available width = "+screen.availWidth);
let countScore=0;
let bomb = document.getElementById('bomb');
let score = document.getElementById('score');
score.innerHTML+=countScore;
let stopBtn = document.getElementById('stopBtn');
let buttonsArea=document.getElementById('buttons').getBoundingClientRect();
// setFoodItem();
// setBombItem();
randomBomb();
foodItem();
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
function setBombItem(){
    setInterval(randomBomb,1000);
}
function clear(){
    clearInterval(leftSide);
    clearInterval(rightSide);
    clearInterval(upSide);
    clearInterval(downSide);

}
function stop(){
    clear();
}
function moveLeft(){
    if(left<=0){
        left=width-80;
    }
    left-=1;
    snake.style.left=left+"px";
    // console.log("left = "+left);
    collisionCheck();
}
function moveRight(){
    if(left>=width){
        left=0;
    }
    left+=1;
    snake.style.left=left+"px";

    collisionCheck();
    // console.log("left = "+left);
}
function moveUp(){
    // console.log("up clicked");
    if(top1<=0){
        top1=height;
    }
    top1-=1;
    snake.style.top=top1+"px";
    // console.log("top = "+top1);
    collisionCheck();

}
function moveDown(){
    // console.log("down clicked");
    if(top1>=height){
        top1=0;
    }
    top1+=1;
    snake.style.top=top1+"px";
    collisionCheck();
    // console.log("top = "+top1);
}
function foodItem(){
    const gameWidth = 1400;
    const gameHeight = 650;
    const foodSize = 20; 
    const randomFoodX = Math.floor(Math.random() * (gameWidth - foodSize));
    const randomFoodY = Math.floor(Math.random() * (gameHeight - foodSize));
    
    console.log("Random food position called");
    console.log("X:", randomFoodX, "Y:", randomFoodY);
    
    foodItem1.style.left = randomFoodX + "px";
    foodItem1.style.top = randomFoodY + "px";
}
function randomBomb(){
    const gameWidth = 1400;
    const gameHeight = 650;
    const bombSize = 60;
    const randomBombX = Math.floor(Math.random() * (gameWidth - bombSize));
    const randomBombY = Math.floor(Math.random() * (gameHeight - bombSize));
    


    
    bomb.style.left = randomBombX + "px";
    bomb.style.top = randomBombY + "px";
}
function collisionCheck(){
    let snakeRect=snake.getBoundingClientRect();
    let foodRect=foodItem1.getBoundingClientRect();
    let bombRect=bomb.getBoundingClientRect();
    if (
        snakeRect.left < foodRect.right &&
        snakeRect.right > foodRect.left &&
        snakeRect.top < foodRect.bottom &&
        snakeRect.bottom > foodRect.top
    ) {
        countScore++;
        score.innerHTML = `Score: ${countScore}`;
        foodItem(); // Relocate the food item
    }
    if (
        snakeRect.left < bombRect.right &&
        snakeRect.right > bombRect.left &&
        snakeRect.top < bombRect.bottom &&
        snakeRect.bottom > bombRect.top
    ) {
        countScore--;
        score.innerHTML = `Score: ${countScore}`;
        foodItem(); // Relocate the food item
    }


}

