const express = require('express');

const app = express();


app.get('/',(req,res)=>{
    res.setHeader('Content-Type','text/html');
    res.write('<a href="/home"><input type="button" value="Home"></a>');
    res.write('<a href="/about"><input type="button" value="About Me"></a>');
    res.end('<a href="/contact"><input type="button" value="Contact Me"></a>');
    // res.send('<input type="button" value="Home">');

});
app.get('/home',(req,res)=>{
    res.setHeader('Content-Type','text/html');
    res.write('<h1>Home Page</h1>');
    res.write('<a href="/about"><input type="button" value="About Me"></a>');
    res.end('<a href="/contact"><input type="button" value="Contact Me"></a>');
});
app.get('/about',(req,res)=>{
    res.setHeader('Content-Type','text/html');
    res.write('<h1>About me Page</h1>');
    res.end('<a href="/contact"><input type="button" value="Contact Me"></a>');
})
app.get('/contact',(req,res)=>{
    res.setHeader('Content-Type','text/html');
    res.write('<h1>Contact me</h1>');
    res.end('<a href="/"><input type="button" value="Back to Menu"></a>');
})
app.listen(3000,()=>{
    console.log('server started at 3000');
});