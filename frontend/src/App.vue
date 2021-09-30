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
import { mapActions, mapState } from "vuex";
import { SET_CURRENT_PAGE } from "@/store/modules/common.js";

export default {
  components: {
    HeaderComponent,
    FooterComponent,
  },
  computed: {
    ...mapState("common", ["currentPage", "onHome"]),
  },
  methods: {
    ...mapActions("common", [`${SET_CURRENT_PAGE}`]),
    getCurrentPageByRoute() {
      let currentPage = "";
      if (this.$route.name === "memberPage") {
        switch (this.$route.params.mode) {
          case "login":
            currentPage = "loginPage";
            break;
          case "memberEntry":
            currentPage = "memberEntryPage";
            break;
        }
      } else if (this.$route.name === "myPage") {
        switch (this.$route.params.mode) {
          case "myInfo":
            currentPage = "myInfoPage";
            break;
          case "addressConfig":
            currentPage = "addressConfigPage";
            break;
          case "joomakDiary":
            currentPage = "joomakDiaryPage";
            break;
        }
      } else {
        currentPage = this.$route.name;
      }

      return currentPage;
    },
    setCurrentPageByRoute() {
      const currentPage = this.getCurrentPageByRoute();
      this.SET_CURRENT_PAGE(currentPage);
      console.log("load : " + this.currentPage);
    },
  },
  created() {
    // 로드/리로드 이벤트 리스너 추가 : currentPage 설정
    window.addEventListener("load", this.setCurrentPageByRoute);
  },
  beforeDestroy() {
    // 로드/리로드 이벤트 리스너 해제 : currentPage 설정
    window.removeEventListener("load", this.setCurrentPageByRoute);
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
