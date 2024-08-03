//this is a javascript code of a simple snake game

let snake = document.getElementById('snake');
let snakeImg=document.getElementById('snake-img');
// let rect = snakeImg.getBoundingClientRect();
// let snakeWidth = rect.width;
// let snakeHeight = rect.height; //use if required
console.log("snakeWidth "+snakeWidth);
console.log("snakeHeight "+snakeHeight);
let left=0;
let top1=0;
let leftSide,rightSide,upSide,downSide;
let width=screen.availWidth;
let height=screen.availHeight;
if(height>800 &&height<900){ //adjusting height for smaller devices
    height=600;
} 
document.body.style.width=(width-50)+"px"; //adjusting body width
document.body.style.height=(height-100)+"px"; //adjusting body height
let foodItem1 = document.getElementById('food'); //food item
let countScore=0;
let bomb = document.getElementById('bomb'); // bomb
let score = document.getElementById('score'); //score
score.innerHTML+=countScore;
let stopBtn = document.getElementById('stopBtn'); //restart button
let buttonsArea=document.getElementById('buttons').getBoundingClientRect(); //button area
let speed=10; //initial speed
let speedChange=countScore; //changing speed 
let bombSpeed=1400;
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
    if(top1>=height-40){
        top1=0;
    }
    // else if(top1==height-100){
        
    // }
    console.log(top1);
    top1+=1;
    snake.style.top=top1+"px";
    snake.style.transform="rotate(90deg)";
    collisionCheck();
    // console.log("top = "+top1);
}
function foodItem(){
    gameWidth = screen.availWidth-100;
    gameHeight = screen.availHeight-90;
    if(screen.availHeight<1000){
        gameHeight=screen.availHeight-170;
    }
    const foodSize = 20;
    const randomFoodX = Math.floor(Math.random() * (gameWidth - foodSize));
    const randomFoodY = Math.floor(Math.random() * (gameHeight - foodSize));
    
    console.log("Random food position called");
    console.log("X:", randomFoodX, "Y:", randomFoodY);
    
    foodItem1.style.left = randomFoodX + "px";
    foodItem1.style.top = randomFoodY + "px";
}
function randomBomb(){
    gameWidth = screen.availWidth-100;
    gameHeight = screen.availHeight-90;
    if(screen.availHeight<1000){
        gameHeight=screen.availHeight-170;
    }
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
            snakeImg.style.height='60px';
            snakeImg.style.width='85px';
        }
        else if(speedChange>20){
            speed=6;
            bombSpeed=1000;
            snakeImg.style.height='65px';
            snakeImg.style.width='90px';
        }
        else if(speedChange>30){
            speed=4;
            bombSpeed=800;
            snakeImg.style.height='70px';
            snakeImg.style.width='95px';
        }
        else if(speedChange>40){
            speed=2;
            bombSpeed=600;
            snakeImg.style.height='80px';
            snakeImg.style.width='105px';
        }
        else if(speedChange>50){
            speed=1;
            bombSpeed=500;
            snakeImg.style.height='90px';
            snakeImg.style.width='115px';
        }
        else if(speedChange>60){
            speed=0.5;
            bombSpeed=400;
            snakeImg.style.height='95px';
            snakeImg.style.width='125px';
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
// Touch controls
let touchStartX, touchStartY;
let touchThreshold = 30; // Minimum distance to trigger a direction change

document.body.addEventListener("touchstart", (e) => {
  touchStartX = e.touches[0].clientX;
  touchStartY = e.touches[0].clientY;
});

document.body.addEventListener("touchend", (e) => {
  if (!touchStartX || !touchStartY) return;

  let touchEndX = e.changedTouches[0].clientX;
  let touchEndY = e.changedTouches[0].clientY;

  let dx = touchEndX - touchStartX;
  let dy = touchEndY - touchStartY;

  if (Math.abs(dx) > touchThreshold || Math.abs(dy) > touchThreshold) {
    if (Math.abs(dx) > Math.abs(dy)) {
      if (dx > 0) {
        setRight();
      } else {
        setLeft();
      }
    } else {
      if (dy > 0) {
        setDown();
      } else {
        setUp();
      }
    }
  }

  // Reset touch start coordinates
  touchStartX = null;
  touchStartY = null;
});

// Prevent default touchmove behavior to avoid scrolling
document.body.addEventListener("touchmove", (e) => {
  e.preventDefault();
}, { passive: false });