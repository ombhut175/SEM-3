const express = require('express');
const mongoose = require('mongoose');
const MokeData = require('./MokeData');
const bodyParser = require('body-parser');
const fs = require('fs');
require('dotenv').config();
const connectionString = 'mongodb+srv://'+process.env.UserName+':'+process.env.Password+'@cluster0.tpipx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';

mongoose.connect(connectionString).then(()=>{
    const app = express();
    app.use(bodyParser.urlencoded({extended:false}));
    app.use('/users',(req,res,next)=>{
       fs.appendFile('log.txt',`\nthis is todays date ${Date.now()} this is the method name ${req.method} this is my ip ${req.ip}:`,(err,data)=>{
           next();
       });
    });


    app.get('/users',async (req,res)=>{
           try{
        const users = await MokeData.find();
              res.setHeader('X-MyName','OmBhut');
               console.log(req.headers);
           res.status(203).json(users);
           res.end();
           }catch {
        console.log(Error);
    }
    });
    app.listen(3000,()=>{
        console.log('server is listening at 3000');
    })
});