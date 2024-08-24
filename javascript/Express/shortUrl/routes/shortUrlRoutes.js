const express = require('express');
const router = express.Router();
const {
    handleShortRoutes,
    handleRedirectToOriginalUrl,
    handleAnalytics,
} = require('../controllers/shortUrlControlls');
router.post('/',handleShortRoutes);
router.get('/:shortId',handleRedirectToOriginalUrl);
router.get('/analytics/:shortId',handleAnalytics);

module.exports = router;