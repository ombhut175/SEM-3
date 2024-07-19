const http = require('http');

const server = http.createServer((req,res)=>{
    res.end('hello world from first server tata bye');
});

server.listen(3000);

