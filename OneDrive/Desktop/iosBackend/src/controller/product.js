'use strict';

const Produto = require('../repositories/product');

// create product
exports.create = async (req, res, next) => {
  try {
    Produto.verifyProduct(req.nome).then(produtoExiste => {
      if (!produtoExiste) {
        Produto.create(req.body)
          .then(response => {
            return res.send('Produt created successfully!');
          });
      } else {
        return res.send('This product already exists!');
      }
    });
  } catch (err) {
    next(err);
  }
};

// buscando produtos
exports.getAll = async (req, res, next) => {
  try {
    const products = await Produto.getAll();
    return res.json(products);
  } catch (err) {
    next(err);
  }
};
