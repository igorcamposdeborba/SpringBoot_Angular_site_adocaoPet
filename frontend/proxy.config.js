const proxy = [
    {
      context: '/api',
      target: 'http://localhost:8080',
      secure: false,
      changeOrigin: true,
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;