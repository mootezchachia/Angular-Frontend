// módulos
const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const hbs = require('express-handlebars');

const environments = require('../env');

// app
const app = express();

// chamando as rotas
const userRoutes = require('../routes/user.routes');
const productRoutes = require('../routes/product.routes');

// configurando a conexao com o bando de dados
mongoose.Promise = global.Promise;
mongoose.connect(environments.database.connection, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
  useCreateIndex: true,
});

// configurando o parse
app.use(bodyParser.json({ limit: '5mb' }));
app.use(bodyParser.urlencoded({ extended: true }));

// carregando arquivos estáticos
app.use(express.static('public'));

// nomeando as rotas
app.use('/api/users', userRoutes);
app.use('/api/products', productRoutes);

app.use('/', (req, res, next) => {
  res.render('home');
}); // rota principal
app.use((req, res, next) => {
  res.json({error: "Wrong route"});
}); // tratamento para erro 404
app.use((err, req, res, next) => {
  res.send(err);
}); // tratamento para demais erros

module.exports = app;
