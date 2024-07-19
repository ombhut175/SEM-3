const fs = require('fs');

// fs.exists('E:\\SEM-3\\javascript\\LAB\\LAB_17\\Q1.js',(exists)=>{
//     console.log(exists?'exits':'not exists');
// });

// fs.stat('forFs.js',(err,details)=>{
//     console.log(err);
//     console.log(details);
// });

fs.readFile('darshan.txt',(err,data)=>{
    console.log(data.buffer);
});

// fs.open('darshan.txt',(err,fd)=>{
//     console.log(fd);
// });
// let checkObj = 'hi hello for node';
// fs.writeFileSync('darshan.txt',checkObj,(err)=>{
//     console.log(err);
// });

// fs.appendFile('darshan.txt',' appended text',(err)=>{
//     console.log(err);
// });

// fs.unlink('darshan.txt',(err)=>{
//     console.log(err);
// });

// fs.open('F:\\SEM-3\\javascript\\LAB\\LAB_17\\darshan.txt','w+',(err,fd)=>{
//     console.log("error = "+err);
//     console.log(fd);
// })

// fs.close(fd,(err)=>{
//     console.log(err);
// });
// const filePath = 'F:\\SEM-3\\javascript\\LAB\\LAB_17\\darshan.txt';
// fs.open(filePath, 'w+', (err, fd) => {
//   if (err) {
//     console.error('Error opening the file:', err.message);
//     return;
//   }
//   console.log('File opened successfully, file descriptor:', fd);

//   // Don't forget to close the file when you're done!
// //   fs.close(fd, (err) => {
// //     if (err) {
// //       console.error('Error closing the file:', err.message);
// //     } else {
// //       console.log('File closed successfully');
// //     }
// //   });
// });


