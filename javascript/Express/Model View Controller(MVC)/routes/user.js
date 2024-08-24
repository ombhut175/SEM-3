const express = require('express');
const routers = express.Router();
const {handleGetAllUsers,
    handleGetUserById,
    updateUserById,
    deleteUserById,
    createNewUser} = require('../controllers/user');

routers.route('/')
    .get(handleGetAllUsers)
    .post(createNewUser);

routers.route('/:id')
    .get(handleGetUserById)
    .patch(updateUserById)
    .delete(deleteUserById);

module.exports = routers;