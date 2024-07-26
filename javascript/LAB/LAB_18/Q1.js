const http = require('http');

const server = http.createServer((req,res)=>{
    console.log(req.url);
    res.setHeader('Content-Type','text/html');
    if(req.url=='/home'){
        res.write("<h1>home</h1>")
    }
    else{

        res.end('hello world');
    }
});

server.listen(4000,()=>{
        console.log("server started at 4100");
})