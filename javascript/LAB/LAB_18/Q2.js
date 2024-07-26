const http = require('http');
const fs = require('fs');
const server = http.createServer((req,res)=>{
    console.log(req.url);
    res.setHeader('Content-Type','text/html');
    if(req.url=='/contact'){
        fs.readFile('contact.html',(err,data)=>{
            res.end(data);
        });
    }
    else{
        fs.readFile('Q2.html',(err,data)=>{
            res.end(data);
        });
    }
});

server.listen(4400,()=>{
        console.log("server started at 4400");
});

