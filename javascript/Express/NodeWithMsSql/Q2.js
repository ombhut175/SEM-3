const express = require('express');
const sql = require('mssql/msnodesqlv8');
// const cors = require('cors');

const app = express();

// app.use(cors());

app.get('/',(req,res)=>{


});

app.listen(3000,()=>{
    console.log('server is listening at 3000');
})