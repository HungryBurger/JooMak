import { createRouter, createWebHistory } from "vue-router";
import HomePage from "../components/client/common/home/pages/HomePage.vue";

const routes = [
  // 홈페이지
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },

  // 회원 관련
  {
    path: "/member/:mode",
    name: "Member",
    component: () => import("../views/Member.vue"),
  },

  // 매장리스트
  {
    path: "/store-list/:food",
    name: "StoreListPage",
    component: () =>
      import("../components/client/product/store/pages/StoreListPage.vue"),
  },

  // 매장 상세
  {
    path: "/store/:idx",
    name: "StoreDetailPage",
    component: () =>
      import("../components/client/product/store/pages/StoreDetailPage.vue"),
  },

  // about 페이지
  {
    path: "/about",
    name: "AboutPage",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../components/client/common/aboutProject/pages/AboutPage.vue"
      ),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
