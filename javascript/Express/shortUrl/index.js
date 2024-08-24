const express = require('express');
const {connectToMongo} = require('./connection');
const shortUrl = require('./models/shortUrl');
const router = require('./routes/shortUrlRoutes');
const { bodyParse } = require('./middleWares/index');
require('dotenv').config();

 connectToMongo('mongodb+srv://'+process.env.UNAME+':'+process.env.PASS+'@cluster0.tpipx.mongodb.net/').then(()=>{
     const app=express();
     app.use(bodyParse());
    app.use('/shortUrl',router);
     app.listen(process.env.PORT,()=>console.log(`Server Started at ${process.env.PORT}`));
 }).catch(error=>console.log(error));




