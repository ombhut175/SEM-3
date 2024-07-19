const http = require('http');
const fs = require('fs');

let server = http.createServer((req,res) => {

    fs.readFile('new.html',(err,data) => {
        res.end(data);
    });
} );

server.listen(4200, () => {
    console.log('server running.');
});