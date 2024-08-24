// import mongoose from "mongoose";

const mongoose = require('mongoose');
const userSchema = new mongoose.Schema({
    id:{
        type:Number,
        required: true,
    },
    first_name:{
        type:String,
        required: true,
    },
    last_name:{
        type:String,
    },
    email:{
        type:String,
        required: true,
        unique: true,
    },
    gender:{
        type:String,
    },
    ip_address:{
        type: String,
    }
},{timestamps:true});

const user = mongoose.model('User',userSchema);

module.exports = user;