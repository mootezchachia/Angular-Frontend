'use strict';

const express = require('express');
const productRoutes = express.Router();
const productControllers = require('../controller/product');

productRoutes.get('/', productControllers.getAll);
productRoutes.post('/create', productControllers.create);

module.exports = productRoutes;
