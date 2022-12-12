var mongoose =require('mongoose');

var Schema =mongoose.Schema;


var formation= new Schema({
    Title:String,
    Description:String,
    StartAt:Date,
    EndAt:Date,
    CreatedAt:{
        type:String,
        default:new Date().toISOString().slice(0, 10)
    },
    Phone:Number,
    UpdatedAt:{
        type:String,
        default:new Date().toISOString().slice(0, 10)
    }
},{ timestamps : true });

module.exports=mongoose.model('formation',formation);