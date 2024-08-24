const express = require('express');
const { connectMongoDb } = require("./Connection");
const {logReqRes} = require('./MiddleWares/index');
const {bodyParse} =  require('./MiddleWares/index');
const userRouter = require('./routes/user');


require('dotenv').config();
const connectionString = 'mongodb+srv://'+process.env.UNAME+':'+process.env.PASS +'@cluster0.tpipx.mongodb.net/';
connectMongoDb(connectionString).then(()=>{
    console.log('connected');
})
    const app = express();

    app.use(logReqRes('log.txt'));

    app.use(bodyParse());

    app.use('/users',userRouter);

    app.listen(process.env.PORT,()=>{
        console.log('server started at '+process.env.PORT);
    });
