const express = require('express');

const mongoose = require('mongoose');

const users = require('./users');



require('dotenv').config();

const connectionString='mongodb+srv://'+process.env.uName+':'+process.env.Pass+'@cluster0.tpipx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
// const crud = async()=>{
//     try{
//         await mongoose.connect(connectionString);
        
//     }catch(e){
//         console.log(e);
//     }
// }
// crud();

(async () => {
    try {
        const response = await mongoose.connect(connectionString);
        console.log('Database connected successfully:', response);
    } catch (error) {
        console.error('Error connecting to the database:', error);
    }
})();
