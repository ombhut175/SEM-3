const child_process = require('child_process');
const { callbackify } = require('util');

function childDemo() {
    child_process.exec("start chrome https://darshanums.in/Login.aspx", (err, stdout, stderr) => {
        if (err) {
            console.error("Error:", err);
            return;
        }
        console.log("Output:", stdout);
    });
}

callChild = ()=>{
    child_process.exec('node childProcess.js',(err,stdout,stdin)    =>{
        console.log(stdout);
    });
}
childDemo();
callChild();