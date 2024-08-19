const sql = require('mssql/msnodesqlv8');
// const {request} = require("express");

const config = {
    server: 'DESKTOP-P64AB1M',
    database: 'CSE_3A_218',
    driver: 'msnodesqlv8',
    options:{
        trustedConnection:true,
        instanceName: 'SQLEXPRESS'
    }
};

sql.connect(config,(err)=>{
    if (err) console.log(err);
    else{
           let request = sql.Request();
           request.query('select * from borrow',(err,records)=>{
               if (err) {
                   console.log(err)
               }
               else{
                   console.log(records);
               }
           });
    }
})