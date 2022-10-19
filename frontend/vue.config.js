const path = require("path");

module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        "@": path.join(__dirname, "src/"),
      },
    },
  },
  // devServer: {
  //   proxy: "http://52.78.232.198:8080",
  // },
};
