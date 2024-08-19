const arr = [
    'Rajdeep',
    'Om',
    'vivek',
    'dhvani',
    'dhruvraj',
    'dhruvrajSingh'
];
let long = arr[0];

for (let i=0;i<arr.length;i++)
{
    if (arr[i].length > long.length)
    {
        long = arr[i];
    }
}
console.log(long);
