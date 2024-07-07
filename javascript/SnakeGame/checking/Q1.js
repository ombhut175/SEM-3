let snake = document.getElementById('snake');
let left = 0;
let top1 = 0;
let leftSide, rightSide, upSide, downSide;
let width = window.innerWidth;
let height = window.innerHeight;
let foodItem1 = document.getElementById('food');
let countScore = 0;
let score = document.getElementById('score');
score.innerHTML = `Score: ${countScore}`;
let stopBtn = document.getElementById('stopBtn');
let buttonsArea = document.getElementById('buttons').getBoundingClientRect();

// Initialize game elements
setRandomFoodPosition();

function setLeft() {
    clear();
    leftSide = setInterval(moveLeft, 0.1);
}

function setRight() {
    clear();
    rightSide = setInterval(moveRight, 0.1);
}

function setUp() {
    clear();
    upSide = setInterval(moveUp, 0.1);
}

function setDown() {
    clear();
    downSide = setInterval(moveDown, 0.1);
}

function clear() {
    clearInterval(leftSide);
    clearInterval(rightSide);
    clearInterval(upSide);
    clearInterval(downSide);
}

function stop() {
    clear();
}

function moveLeft() {
    left -= 1;
    if (left + snake.offsetWidth < 0) {
        left = width;
    }
    snake.style.left = left + "px";
    snake.style.transform = 'rotateY(180deg)'
    collisionCheck();
}

function moveRight() {
    left += 1;
    if (left > width) {
        left = -snake.offsetWidth;
    }
    snake.style.left = left + "px";
    snake.style.transform = 'rotate(0deg)'
    collisionCheck();
}

function moveUp() {
    top1 -= 1;
    if (top1 + snake.offsetHeight < 0) {
        top1 = height;
    }
    snake.style.top = top1 + "px";
    snake.style.transform = 'rotate(270deg)'
    collisionCheck();
}

function moveDown() {
    top1 += 1;
    if (top1 > height) {
        top1 = -snake.offsetHeight;
    }
    snake.style.top = top1 + "px";
    snake.style.transform = 'rotate(90deg)'
    collisionCheck();
}

// function setRandomFoodPosition() {
//     let foodX, foodY;
//     const margin = 10; // Margin from the edge of the screen

//     // Randomly choose which edge to place the food
//     const edge = Math.floor(Math.random() * 4);

//     switch(edge) {
//         case 0: // Top edge
//             foodX = Math.floor(Math.random() * (width - foodItem1.offsetWidth));
//             foodY = margin;
//             break;
//         case 1: // Right edge
//             foodX = width - foodItem1.offsetWidth - margin;
//             foodY = Math.floor(Math.random() * (height - foodItem1.offsetHeight));
//             break;
//         case 2: // Bottom edge
//             foodX = Math.floor(Math.random() * (width - foodItem1.offsetWidth));
//             foodY = height - foodItem1.offsetHeight - margin;
//             break;
//         case 3: // Left edge
//             foodX = margin;
//             foodY = Math.floor(Math.random() * (height - foodItem1.offsetHeight));
//             break;
//     }

//     // Ensure food doesn't overlap with buttons
//     if (
//         foodY >= buttonsArea.top - foodItem1.offsetHeight &&
//         foodY <= buttonsArea.bottom &&
//         foodX >= buttonsArea.left - foodItem1.offsetWidth &&
//         foodX <= buttonsArea.right
//     ) {
//         setRandomFoodPosition(); // Try again if there's overlap
//         return;
//     }

//     foodItem1.style.left = foodX + "px";
//     foodItem1.style.top = foodY + "px";
// }


function setRandomFoodPosition() {
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



function collisionCheck() {
    let snakeRect = snake.getBoundingClientRect();
    let foodRect = foodItem1.getBoundingClientRect();
    
    if (
        snakeRect.left < foodRect.right &&
        snakeRect.right > foodRect.left &&
        snakeRect.top < foodRect.bottom &&
        snakeRect.bottom > foodRect.top
    ) {
        countScore++;
        score.innerHTML = `Score: ${countScore}`;
        setRandomFoodPosition();
    }
}

window.addEventListener('resize', function() {
    width = window.innerWidth;
    height = window.innerHeight;
    buttonsArea = document.getElementById('buttons').getBoundingClientRect();
});

// Add keyboard event listener
document.addEventListener('keydown', function(event) {
    switch(event.key) {
        case 'ArrowLeft':
        case 'a':
        case 'A':
            setLeft();
            break;
        case 'ArrowRight':
        case 'd':
        case 'D':
            setRight();
            break;
        case 'ArrowUp':
        case 'w':
        case 'W':
            setUp();
            break;
        case 'ArrowDown':
        case 's':
        case 'S':
            setDown();
            break;
        case ' ':
            stop();
            break;
    }
});