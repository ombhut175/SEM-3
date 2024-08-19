const express = require('express');
const mongoose = require('mongoose');
const Faculty = require('./Faculty');
const bodyParse = require('body-parser')
const connectionString = 'mongodb+srv://23010101033:Om110123@cluster0.tpipx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
// const connectionString = 'mongodb+srv://:<password>@cluster0.tpipx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';

mongoose.connect(connectionString).then(()=>{
    const app = express();
    app.use(bodyParse.urlencoded({extended:false}));
    
    app.get('/faculties',async(req,res)=>{
        faculty = await Faculty.find();
        res.send(faculty);
    });
    app.get('/faculties/:index',async (req,res)=>{
        faculty = await Faculty.findOne({FacultyId:req.params.index});
        if (!faculty) return res.status(404).json({msg:'id not exist'});
        res.send(faculty);
    });
    app.post('/faculties',async(req,res)=>{
        if (!req.body.FacultyId || !req.body.Name || !req.body.City) {
            return res.status(400).json({msg:'all fields required'});
        }
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
        faculty = await Faculty.findOne({FacultyId:parseInt(req.params.index)});
        await faculty.deleteOne();
        res.send(await Faculty.find());
        }catch (error){
            res.status(404);
            res.send({error: "Faculty doesnt exist"})
        }

    });
    // app.delete('/faculties/:index', async (req, res) => {
    //     try {
    //         const faculty = await Faculty.findOne({ FacultyId: parseInt(req.params.index) });
    //         if (!faculty) {
    //             return res.status(404).send({ error: "Faculty doesn't exist" });
    //         }
    //         await faculty.deleteOne(); // Corrected the delete method
    //         res.send(await Faculty.find());
    //     } catch (error) {
    //         res.status(500).send({ error: "An error occurred while deleting the faculty" });
    //     }
    // });
    app.listen(3000,()=>{
        console.log('server is listening at 3000');
    })
})
