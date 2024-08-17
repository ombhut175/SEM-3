const mongoose = require("mongoose");

const schema = mongoose.Schema({
    id:Number,
    first_name:String,
    last_name:String,
    email:String,
    gender:String,
    ip_address:String
});

module.exports = mongoose.model('MokeData',schema);
