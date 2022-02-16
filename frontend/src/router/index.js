import { createRouter, createWebHistory } from "vue-router";
import HomePage from "@/views/HomePage.vue";

const routes = [
  /* 공통 */
  // 홈페이지
  {
    path: "/",
    name: "homePage",
    component: HomePage,
  },
  // about 페이지
  {
    path: "/about",
    name: "aboutPage",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/AboutPage.vue"),
  },

  /* 회원 */
  // 회원 공통
  {
    path: "/member/:mode",
    name: "memberPage",
    component: () => import("@/views/MemberPage.vue"),
  },
  // 마이 페이지 공통
  {
    path: "/my-page/:mode",
    name: "myPage",
    component: () => import("@/views/MyPage.vue"),
  },

  /* 상품 */
  // 매장 리스트 페이지
  {
    path: "/store-list/:food",
    name: "storeListPage",
    component: () => import("@/views/StoreListPage.vue"),
  },
  // 매장 상세 페이지
  {
    path: "/store/:idx",
    name: "storeDetailPage",
    component: () => import("@/views/StoreDetailPage.vue"),
  },

  /* 주문 */
  // 주문 & 결제 페이지
  {
    path: "/order",
    name: "orderPage",
    component: () => import("@/views/OrderPage.vue"),
  },
  // 주문 현황 페이지
  {
    path: "/order-status",
    name: "orderStatusPage",
    component: () => import("@/views/OrderStatusPage.vue"),
  },
  // 주문 완료 페이지
  {
    path: "/order-complete",
    name: "orderCompletePage",
    component: () => import("@/views/OrderCompletePage.vue"),
  },
  // 장바구니 페이지
  {
    path: "/cart",
    name: "cartPage",
    component: () => import("@/views/CartPage.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
