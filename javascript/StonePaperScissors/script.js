let paper = document.getElementById('paper');
let rock = document.getElementById('rock');
let scissors = document.getElementById('scissor');
let play = document.getElementById('play');
let youScoreHtml = document.getElementById('youScoreHtml');
let compScoreHtml = document.getElementById('compScoreHtml');
let youScore=0;
let compScore=0;
let compN=Math.floor(Math.random()*3);
let userN;
let checkPlay;
let count = 0;
gameScore = (n)=> {
    if (checkPlay) {
        userN = n;
        let compSelected;
        let userSelected;
        if (compN == 0) {
            compSelected = 'Computer selected paper';
        } else if (compN == 1) {
            compSelected = 'Computer selected stone';
        } else if (compN == 2) {
            compSelected = 'Computer selected scissor';
        }
        if (userN == 0) {
            userSelected = 'You Selected paper';
        } else if (userN == 1) {
            userSelected = 'You selected stone';
        } else if (userN == 2) {
            userSelected = 'You selected Scisscor';
        }
        if (userN == compN) {
            Swal.fire({
                title: 'Tie',
                html: "<p style='color: rgb(255,174,0); font-weight: 800'>" + compSelected + "</p><p style='color: rgba(255,174,0); font-weight: 800'>" + userSelected + "</p>",
            });
            youScore++;
            compScore++;
            youScoreHtml.innerText = youScore;
            compScoreHtml.innerText = compScore;
        } else if (userN == 0 && compN == 1 || userN == 1 && compN == 2 || userN == 2 && compN == 0) {
            Swal.fire({
                title: 'You Won',
                html: "<p style='color: rgb(8,255,0); font-weight: 800'>" + compSelected + "</p><p style='color: rgba(8,255,0); font-weight: 800'>" + userSelected + "</p>"
            });
            youScore++;
            youScoreHtml.innerText = youScore;

        } else if (userN == 0 && compN == 2 || userN == 1 && compN == 0 || userN == 2 && compN == 1) {
            Swal.fire({
                icon: "error",
                title: "You Lost",
                html: "<p style='color: rgba(255,0,0,0.93); font-weight: 800'>" + compSelected + "</p><p style='color: rgba(255,0,0,0.93); font-weight: 800'>" + userSelected + "</p>"
            });
            compScore++;
            compScoreHtml.innerText = compScore;
        }
        compN = Math.floor(Math.random() * 3);
        if (compScore >= 10) {
            resetTheGame('You Lost The Game')
        } else if (youScore >= 10) {
            resetTheGame('You Won The Game')
        }
    }else{
        Swal.fire({
            icon: "error",
            title: "Click Play",
            html: "<p style='color: rgba(255,0,0,0.93); font-weight: 800'>" + "Please Click Play Button" + "</p>",
        });
    }
}

resetTheGame=(result)=>{
    Swal.fire({
        title: result,
        showDenyButton: true,
        confirmButtonText: "Start New Game",
        denyButtonText: "Cancel"
    }).then((result) => {
        if (result.isConfirmed) {
            youScore = 0;
            compScore = 0;
            youScoreHtml.innerText = youScore;
            compScoreHtml.innerText = compScore;
            play.innerText='Start';
            count=0;
        }
    });
}

startEvent=()=>{
    if(count==0){
        count=1;
        startTheGame();
    }else if(count==1){
        resetTheGame();
    }
};

startTheGame=()=>{
    checkPlay=true;
    if(checkPlay){
    play.innerText='Restart the Game';
    count=1;
    }
    else{
        play.innerText='Start';
    }
}
play.addEventListener('click',()=>{startEvent()});
paper.addEventListener('click',()=>gameScore(0));
rock.addEventListener('click',()=>gameScore(1));
scissors.addEventListener('click',()=>gameScore(2));