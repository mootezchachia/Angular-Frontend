const environments = {
  api: {
    port: 3030,
    host: 'localhost',
  },
  database: {
    connection: process.env.connection || 'mongodb+srv://mootez1:solomonbv@cluster0.gjdg5.mongodb.net/ecommerce?retryWrites=true&w=majority',
  },
  authenticationToken: {
    secret: '232ioh3po4u23h42e23e03023ieh230he23',
  },
};

module.exports = environments;
