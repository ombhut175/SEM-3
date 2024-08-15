const express = require('express');
const mongoose = require('mongoose');
const Faculty = require('./Faculty');
const bodyParse = require('body-parser')
const connectionString = 'mongodb+srv://23010101033:Om110123@cluster0.tpipx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';

mongoose.connect(connectionString).then(()=>{
    const app = express();
    app.use(bodyParse.urlencoded({extended:false}));
    
    app.get('/faculties',async(req,res)=>{
        faculty = await Faculty.find();
        res.send(faculty);
    });
    app.get('/faculties/:index',async (req,res)=>{
        faculty = await Faculty.findOne({FacultyId:req.params.index});
        res.send(faculty);
    });
    app.post('/faculties',async(req,res)=>{
        const faculty = new Faculty({
            FacultyId: req.body.FacultyId,
            Name: req.body.Name,
            City: req.body.City
        })
        await faculty.save();
        res.send(await Faculty.find());
    });
    app.delete('/faculties/:index',async  (req,res)=>{
        try{
        faculty = await Faculty.findOne({FacultyId:req.params.index});
        await faculty.delete();
        res.send(await Faculty.find());
        }catch (error){
            res.status(404);
            res.send({error: "Faculty doesnt exist"})
        }

    });
    app.listen(3000,()=>{
        console.log('server is listening at 3000');
    })
})
