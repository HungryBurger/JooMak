<template>
  <header-component></header-component>
  <main
    id="main"
    :class="{
      'padding-for-sticky': currentPage !== 'storeDetailPage',
      'on-home': onHome,
    }"
  >
    <router-view />
  </main>
  <footer-component></footer-component>
</template>

<script>
import "./assets/styles/css/style.css";
import HeaderComponent from "./components/client/common/share/pages/HeaderComponent.vue";
import FooterComponent from "./components/client/common/share/pages/FooterComponent.vue";
import { mapState } from "vuex";

export default {
  components: {
    HeaderComponent,
    FooterComponent,
  },
  computed: {
    ...mapState("common", ["currentPage", "onHome"]),
  },
};
</script>

<style>
#main.padding-for-sticky {
  padding-top: 12vh;
}
#main.padding-for-sticky.on-home {
  padding-top: 0;
}
#main.on-home + #footer {
  margin-top: 100vh;
}
</style>
