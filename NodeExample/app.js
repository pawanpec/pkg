var express = require('express');
var path = require('path');
var favicon = require('static-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
// Database
var mongo = require('mongoskin');
var mongoDbUrl="mongodb://10.150.200.54:27017";
var masterDB = mongo.db(mongoDbUrl+"/master", {native_parser:true});
var lastWeekDB="";
var currentWeekDb="";
var presentDbs = masterDB.collection("presentDbs");
presentDbs.findOne("",function (err, item) {
	var dbs=item['pdbs'].split(",");
	var lastWeekDBURL=mongoDbUrl+"/"+dbs[0];
	var currentWeekDbURL=mongoDbUrl+"/"+dbs[1];
	console.log("lastWeekDBURL "+lastWeekDBURL);
	console.log("currentWeekDbURL "+currentWeekDbURL);
	lastWeekDB=mongo.db(lastWeekDBURL, {native_parser:true});
	currentWeekDb=mongo.db(mongoDbUrl+"/"+dbs[1], {native_parser:true});
});
var routes = require('./routes/index');
var inbox = require('./routes/inbox');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(favicon());
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
// Make our db accessible to our router
app.use(function(req,res,next){
    req.lastWeekDB = lastWeekDB;
    req.currentWeekDb = currentWeekDb;
    next();
});
app.use('/', routes);
app.use('/naf/inbox', inbox);

/// catch 404 and forward to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

/// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next) {
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
        message: err.message,
        error: {}
    });
});


module.exports = app;
