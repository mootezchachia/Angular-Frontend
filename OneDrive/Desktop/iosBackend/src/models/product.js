'use strict';

const mongoose = require('mongoose');
const schema = mongoose.Schema;

const produto_model = new schema(
  {
    nome: {
      type: String,
      required: true,
      trim: true,
      index: true,
    },
    description: {
      type: String,
      required: true,
    },
    price: {
      type: Number,
      required: true,
    },

  },
  { versionKey: false }
);



module.exports = mongoose.model('Produto', produto_model);
