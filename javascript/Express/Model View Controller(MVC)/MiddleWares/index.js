const fs = require('fs');

function logReqRes(filename) {
    return (req, res, next) => {
        fs.appendFile(filename, `\nthis is today's date ${Date.now()} this is the method name ${req.method} this is my ip ${req.ip}:`, (err, data) => {
            next();
        });
    }
}
const bodyParser = require('body-parser');
function bodyParse(){
    return bodyParser.urlencoded({extended:false});
}

module.exports = {
    logReqRes,
    bodyParse,
};