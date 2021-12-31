import { createApp } from "vue";
import App from "./App.vue";
import store from "@/store";
import router from "@/router";

// library
import axios from "axios";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

const app = createApp(App);

// 전역 library 추가
app.config.globalProperties.$axios = axios;

app.use(store);
app.use(router);

app.mount("#app");
