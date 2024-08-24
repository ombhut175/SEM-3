const router = require('../routes/shortUrlRoutes');
const shortUrl = require('../models/shortUrl');
// const linkShorteners = require("link-shorteners");
// const mongoose = require("mongoose");
// const short = require('short');
// const { nanoid } = require('nanoid');
const shortid = require("shortid");

async function handleShortRoutes(req,res){
    const newShortUrl= shortid();
    const newUrl = await shortUrl.create({
        shortId:newShortUrl,
        redirectUrl: req.body.redirectUrl,
        details: [],
    });
    return res.json({shortUrl:newShortUrl});
}

async function handleRedirectToOriginalUrl(req,res){
    console.log('entered handleRedirectToOriginalUrl');
    const url = req.params.shortId;
    const urlObj = await shortUrl.findOneAndUpdate({
            shortId:url,
    },{
        $push:{
            details:{
                timestamp:Date.now(),
            }
        }
    }
    );
    res.redirect(urlObj.redirectUrl);
}

async function handleAnalytics(req,res){
    const url = req.params.shortId;
    console.log(url);
    const urlObj = await shortUrl.findOne({
        shortId:url,
    });
    console.log(urlObj);
    // res.end();
    return res.send(
        {link:urlObj._doc.redirectUrl, length: urlObj.details.length}
    );
}

module.exports = {
    handleShortRoutes,
    handleRedirectToOriginalUrl,
    handleAnalytics
}