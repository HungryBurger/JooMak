<template>
  <header-component></header-component>
  <router-view />
  <footer-component></footer-component>
</template>

<script>
import "./assets/style.css";
import HeaderComponent from "./components/client/common/share/pages/HeaderComponent.vue";
import FooterComponent from "./components/client/common/share/pages/FooterComponent.vue";

export default {
  components: {
    HeaderComponent,
    FooterComponent,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
