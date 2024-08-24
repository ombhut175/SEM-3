const user = require('../models/users');

async function handleGetAllUsers(req,res){
    const dbUser =  await user.find().sort({id:1});
    const html = `<ul>
                        ${dbUser.map((user)=>`<li>${user.id} - ${user.first_name} - ${user.email} </li>`)
        .join('')}
                        </ul>`
    res.send(html);
}

async function handleGetUserById(req,res) {
    const dbUser = await user.findOne({id: req.params.id});
    if (!dbUser) return res.send('user not found');
    res.send(dbUser);
    res.end();
}

async function updateUserById(req,res){
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
}

async function deleteUserById(req,res){
    const deleted = await user.findOneAndDelete({id:req.params.id});
    res.send(deleted);
}

async function createNewUser(req,res){
    const result = await user.create({
        id: req.body.id,
        first_name: req.body.first_name,
        last_name:req.body.last_name,
        email:req.body.email,
        gender:req.body.gender,
        ip_address:req.body.ip_address,
    });
    return res.status(201).json(await user.find());
}

module.exports = {
    handleGetAllUsers,
    handleGetUserById,
    updateUserById,
    deleteUserById,
    createNewUser
}