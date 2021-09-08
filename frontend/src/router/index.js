import { createRouter, createWebHistory } from "vue-router";
import HomePage from "@/views/HomePage.vue";

const routes = [
  /* 공통 */
  // 홈페이지
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },

  // about 페이지
  {
    path: "/about",
    name: "AboutPage",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/AboutPage.vue"),
  },

  /* 회원 */
  {
    path: "/member/:mode",
    name: "Member",
    component: () => import("@/views/Member.vue"),
  },

  /* 상품 */
  // 매장 리스트 페이지
  {
    path: "/store-list/:food",
    name: "StoreListPage",
    component: () => import("@/views/StoreListPage.vue"),
  },

  // 매장 상세 페이지
  {
    path: "/store/:idx",
    name: "StoreDetailPage",
    component: () =>
      import("../components/client/product/store/pages/StoreDetailPage.vue"),
  },

  /* 주문 */
  // 주문 현황 페이지
  {
    path: "/order-status",
    name: "OrderStatusPage",
    component: () =>
      import("../components/client/order/pages/OrderStatusPage.vue"),
  },
  // 장바구니 페이지
  {
    path: "/cart",
    name: "CartPage",
    component: () => import("../components/client/order/pages/CartPage.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
