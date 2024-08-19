const express = require('express');
const mongoose = require('mongoose');
const fs = require('fs');
const bodyParser = require('body-parser');
const users = require('./MOCK_DATA.json');

//Schema

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
const connectionString = 'mongodb+srv://23010101033:Om110123@cluster0.tpipx.mongodb.net/';
mongoose.connect(connectionString).then(()=>{
    const app = express();
    const port = 3000;
    app.use(bodyParser.urlencoded({extended:false}));
    app.get('/users',async (req,res)=>{
        const dbUser =  await user.find().sort({id:1});
        const html = `<ul>
                        ${dbUser.map((user)=>`<li>${user.id} - ${user.first_name} - ${user.email} </li>`)
                            .join('')}
                        </ul>>`
        res.send(html);
    })
    .get('/users/:id',async (req,res)=>{
       const dbUser = await user.findOne({id: req.params.id});
       if (!dbUser) return res.send('user not found');
       res.send(dbUser);
       res.end();
    })
    //    app.patch(async (req,res)=>{
    //     const updated = await user.findByIdAndUpdate(req.params._id,{
    //         id: req.body.id,
    //         first_name: req.body.first_name,
    //         last_name:req.body.last_name,
    //         email:req.body.email,
    //         gender:req.body.gender,
    //         ip_address:req.body.ip_address,
    //     });
    //     res.send(updated);
    // });
    app.patch('/users/:id', async (req, res) => {
        try {
            const updated = await user.findOneAndUpdate(
                { id: req.params.id }, // Use custom id for finding the user
                {
                    id: req.body.id,
                    first_name: req.body.first_name,
                    last_name: req.body.last_name,
                    email: req.body.email,
                    gender: req.body.gender,
                    ip_address: req.body.ip_address,
                },
                { new: true } // Return the updated document
            );

            if (!updated) {
                console.log("User not found with ID:", req.params.id); // Log if user not found
                return res.send('User not found');
            }

            res.send(updated);
        } catch (error) {
            console.error("Error updating user:", error); // Log any errors that occur
            res.status(500).send('An error occurred');
        }
    });
    app.delete('/users/:id',async (req,res)=>{
       const deleted = await user.findOneAndDelete({id:req.params.id});
       res.send(deleted);
    });
    app.post('/users',async (req,res)=>{
       const result = await user.create({
           id: req.body.id,
           first_name: req.body.first_name,
           last_name:req.body.last_name,
           email:req.body.email,
           gender:req.body.gender,
           ip_address:req.body.ip_address,
       });
       return res.status(201).json(await user.find());
    })


    app.listen(port,()=>{
        console.log('server started at '+port);
    })
}).catch((err)=> console.log('error in mongo'+err));