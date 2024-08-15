const mongoose = require('mongoose');

const schema = mongoose.Schema({
    FacultyId: Number,
    Name: String,
    City: String 
});

module.exports = mongoose.model('Faculty',schema);