var express = require('express');
var router = express.Router();
var Formation=require("../model/Formation");
router.get('/', function(req, res, next) {
    
    Formation.find(function(err,data){
        if(err) throw err;
        res.render("Formation.twig",{data});
    });
    
});

router.get('/add', function(req, res, next) {
    res.render("AddFormation.twig")
});

router.post('/addAction', function(req, res, next) {
    

    var formation=new Formation(req.body);
    formation.save();

    res.redirect("/formation");
    
});
router.get('/delete/:id', function(req, res, next) {
    
    var id =req.params.id;
    Formation.findOneAndRemove({_id:id},(err)=>{
        if(err) throw err;
    });
    res.redirect("/formation");
    
});

router.get('/updateFormation/:id', function(req, res, next) {
    var id =req.params.id;
    Formation.findById({_id:id},function(err,data){
        if(err) throw err;
        res.render("UpdateFormation.twig",{data});
});
});
router.post('/update/:id', function(req, res, next) {
    
    var id =req.params.id;
    Formation.findByIdAndUpdate({_id:id},req.body,(err)=>{
        if(err) throw err;
    });
    res.redirect("/formation");
    
});



module.exports = router;