const path = require('path');
let ans = path.normalize('/foo/bar//baz/asdf/quux/..');
let join = path.join(ans,'/hi/hello');
let resolve = path.resolve();
let relative = path.relative('E:\\SEM-3\\javascript\\LAB\\LAB_17','E:\\SEM-3\\javascript\\LAB\\LAB_7');
let dirName = path.dirname('E:\\SEM-3\\javascript\\LAB\\LAB_17');
let baseName = path.basename('E:\\SEM-3\\javascript\\LAB\\LAB_17');
let extName = path.extname('E:\\SEM-3\\javascript\\LAB\\LAB_17\\Q1.js');
let obj={
    root: '/ignored',
    dir: '/home/user/dir',
    base: 'file.txt',
};  
let format = path.parse('E:\\SEM-3\\javascript\\LAB\\LAB_17\\Q1.js');
let posix=path.posix;
let nameSpaced = path.toNamespacedPath('E:\\SEM-3\\javascript\\LAB\\LAB_17\\Q1.js');
console.log("entered = "+path);
console.log(nameSpaced);