const fs = require('fs');

const readStream = fs.createReadStream('largefile.txt');

readStream.on('data', (chunk) => {
  console.log(`Received ${chunk.length} bytes of data.`);
  // Process the chunk of data
});

readStream.on('end', () => {
  console.log('No more data.');
});

readStream.on('error', (err) => {
  console.error('Error reading the file:', err);
});
