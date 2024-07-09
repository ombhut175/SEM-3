let snake = document.getElementById('snake');
let left=0;
let top1=0;
let leftSide,rightSide,upSide,downSide;
let width=screen.availWidth;
let height=screen.availHeight;
console.log(height);
document.body.style.width=(width-50)+"px";
document.body.style.height=(height-50)+"px";
let foodItem1 = document.getElementById('food');
console.log("available height = "+screen.availHeight);
console.log("available width = "+screen.availWidth);
let countScore=0;
let bomb = document.getElementById('bomb');
let score = document.getElementById('score');
score.innerHTML+=countScore;
let stopBtn = document.getElementById('stopBtn');
let buttonsArea=document.getElementById('buttons').getBoundingClientRect();
let speed=10;
let speedChange=countScore;
let bombSpeed=1400;
// setFoodItem();
setBombItem();
randomBomb();
foodItem();
function setLeft(){
    clear();
   leftSide= setInterval(moveLeft,speed);
}
function setRight(){
    clear();
    rightSide= setInterval(moveRight,speed);
}
function setUp(){
    clear();
    upSide=setInterval(moveUp,speed);
}
function setDown(){
    clear();
    downSide=setInterval(moveDown,speed);
}
function setFoodItem(){
    setInterval(foodItem,1000);
}
function setBombItem(){
    setInterval(randomBomb,bombSpeed);
}
function clear(){
    clearInterval(leftSide);
    clearInterval(rightSide);
    clearInterval(upSide);
    clearInterval(downSide);

}
function stop(){
    clear();
    countScore=0;
    console.log(countScore);
    score.innerHTML="Score: "+countScore;
    alert('restart game');
}
function moveLeft(){
    if(left<=0){
        left=width-80;
    }
    left-=1;
    snake.style.left=left+"px";
    snake.style.transform="rotateY(180deg)";
    // console.log("left = "+left);
    collisionCheck();
}
function moveRight(){
    if(left>=width){
        left=0;
    }
    left+=1;
    snake.style.left=left+"px";
    snake.style.transform="rotateY(0deg)";
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
    snake.style.transform="rotate(270deg)";
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
    snake.style.transform="rotate(90deg)";
    collisionCheck();
    // console.log("top = "+top1);
}
function foodItem(){
    const gameWidth = screen.availWidth-100;
    const gameHeight = screen.availHeight-50;
    const foodSize = 20; 
    const randomFoodX = Math.floor(Math.random() * (gameWidth - foodSize));
    const randomFoodY = Math.floor(Math.random() * (gameHeight - foodSize));
    
    console.log("Random food position called");
    console.log("X:", randomFoodX, "Y:", randomFoodY);
    
    foodItem1.style.left = randomFoodX + "px";
    foodItem1.style.top = randomFoodY + "px";
}
function randomBomb(){
    const gameWidth = screen.availWidth-100;
    const gameHeight = screen.availHeight-50;
    const bombSize = 60;
    const randomBombX = Math.floor(Math.random() * (gameWidth - bombSize));
    const randomBombY = Math.floor(Math.random() * (gameHeight - bombSize));
    


    
    bomb.style.left = randomBombX + "px";
    bomb.style.top = randomBombY + "px";
}
function moveObject(e){
    if(e.key=="ArrowUp"){
        setUp();
    }else if(e.key=="ArrowDown"){
        setDown();
    }
    else if(e.key=="ArrowLeft"){
        setLeft();
    }
    else if(e.key=="ArrowRight"){
        setRight();
    }
}
function collisionCheck(){
    let snakeRect=snake.getBoundingClientRect();
    let foodRect=foodItem1.getBoundingClientRect();
    let bombRect=bomb.getBoundingClientRect();

    // console.log("snak="+snakeRect.left)
    if (
        snakeRect.left < foodRect.right &&
        snakeRect.right > foodRect.left &&
        snakeRect.top < foodRect.bottom &&
        snakeRect.bottom > foodRect.top
    ) {
        countScore++;
        speedChange++;
        if(speedChange>10){
            speed=8;
            bombSpeed=1200;
        }
        else if(speedChange>20){
            speed=6;
            bombSpeed=1000;
        }
        else if(speedChange>30){
            speed=4;
            bombSpeed=800;
        }
        else if(speedChange>40){
            speed=2;
            bombSpeed=600;
        }
        else if(speedChange>50){
            speed=1;
            bombSpeed=500;
        }
        else if(speedChange>60){
            speed=0.5;
            bombSpeed=400;
        }
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
        if(countScore<0){
            alert("restart the game");
            countScore=0;
        }
        score.innerHTML = `Score: ${countScore}`;
        randomBomb(); // Relocate the food item
    }
    
}

