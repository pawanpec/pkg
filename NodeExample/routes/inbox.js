var express = require('express');
var router = express.Router();
var ObjectID = require('mongoskin').ObjectID;
var hash = require('hash-code');
var utils = require('./utils.js'); 
var sys = require('sys');
var base64_decode = require('base64').decode;

/*
 * GET Notification.
 */
router.get('/getNotification', function(req, res) {
	var currentWeekDb = req.currentWeekDb;
	console.log("loading notification from  "+currentWeekDb);
    var notification = currentWeekDb.collection("notification_0");
    notification.find().limit(1).toArray(function (err, items) {
        res.json(items);
    });
});

/*
 * markMessagesAsRead.
 */
router.get('/markMessagesAsRead/:id/:elid', function(req, res) {
    var lastWeekDB = req.lastWeekDB;
    var currentWeekDb = req.currentWeekDb;
    var _id=new ObjectID(req.params.id);
    console.log("_id "+_id);
   // var elid="c2Fuamlid2lkZ2V0Mjc5MzY6MDowOm51bGw=";
    var elid=req.params.elid;
    console.log("elid "+elid);
    var tokenValueBase64=base64_decode(elid);
    var tokens=tokenValueBase64.split(":");
    var lid=tokens[0];
    console.log("lid "+lid);
    var h=hash.hashCode(lid);
    var collectionName=utils.getCollectionName(h);
    console.log("collectionName "+collectionName);
    var lastWeekNotification = lastWeekDB.collection(collectionName);
    lastWeekNotification.update({"_id": _id}, {$set: {"rf": "y"}},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    var currentWeekDbNotification = currentWeekDb.collection(collectionName);
    currentWeekDbNotification.update({"_id": _id}, {$set: {"rf": "y"}},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    res.json("1");
});
/*
 * markMessagesAsImportant.
 */
router.get('/markMessagesAsImportant/:id/:elid', function(req, res) {
    var lastWeekDB = req.lastWeekDB;
    var currentWeekDb = req.currentWeekDb;
    var _id=new ObjectID(req.params.id);
    console.log("_id "+_id);
   // var elid="c2Fuamlid2lkZ2V0Mjc5MzY6MDowOm51bGw=";
    var elid=req.params.elid;
    console.log("elid "+elid);
    var tokenValueBase64=base64_decode(elid);
    var tokens=tokenValueBase64.split(":");
    var lid=tokens[0];
    console.log("lid "+lid);
    var h=hash.hashCode(lid);
    var collectionName=utils.getCollectionName(h);
    console.log("collectionName "+collectionName);
    var lastWeekNotification = lastWeekDB.collection(collectionName);
    lastWeekNotification.update({"_id": _id}, {$set: {"imp": "y"}},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    var currentWeekDbNotification = currentWeekDb.collection(collectionName);
    currentWeekDbNotification.update({"_id": _id}, {$set: {"imp": "y"}},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    res.json("1");
});

/*
 * deleteNotification.
 */
router.get('/deleteNotification/:id/:elid', function(req, res) {
    var lastWeekDB = req.lastWeekDB;
    var currentWeekDb = req.currentWeekDb;
    var _id=new ObjectID(req.params.id);
    console.log("_id "+_id);
   // var elid="c2Fuamlid2lkZ2V0Mjc5MzY6MDowOm51bGw=";
    var elid=req.params.elid;
    console.log("elid "+elid);
    var tokenValueBase64=base64_decode(elid);
    var tokens=tokenValueBase64.split(":");
    var lid=tokens[0];
    console.log("lid "+lid);
    var h=hash.hashCode(lid);
    var collectionName=utils.getCollectionName(h);
    console.log("collectionName "+collectionName);
    var lastWeekNotification = lastWeekDB.collection(collectionName);
    lastWeekNotification.remove({"_id": _id},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    var currentWeekDbNotification = currentWeekDb.collection(collectionName);
    currentWeekDbNotification.remove({"_id": _id},function (err, items) {
    	 if (err) throw err;
         console.log(items);		    
    });
    res.json("1");
});

module.exports = router;
