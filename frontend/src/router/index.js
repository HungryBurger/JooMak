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
    component: () => import( "@/views/AboutPage.vue"),
  },

  /* 회원 */
  {
    path: "/member",
    name: "memberPage",
    component: () => import("@/views/MemberPage.vue"),
    redirect: "/member/login",
    children: [
      {
        path: "login",
        name: "memberLogin",
        component: () => import("@/components/client/member/pages/LoginPage.vue")
      },
      {
        path: "entry",
        name: "memberEntry",
        component: () => import("@/components/client/member/pages/MemberEntryPage.vue")
      },
      {
        path: "entry-complete",
        name: "memberEntryComplete",
        component: () => import("@/components/client/member/pages/MemberEntryCompletePage.vue")
      },
    ]
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

  /* Admin */
  // Admin 페이지
  {
    path: "/admin",
    name: "adminPage",
    component: () => import("@/views/AdminPage.vue"),
    redirect: "/admin/home",
    children: [
      {
        path: "home",
        name: "adminHome",
        component: () => import("@/components/admin/common/AdminHome.vue")
      },
      {
        path: "member",
        component: () => import("@/components/admin/member/LayoutMemberAdmin.vue"),
        children: [
          {
            path: "memberAdmin",
            name: "memberAdmin",
            component: () => import("@/components/admin/member/MemberAdmin.vue")
          }
        ]
      },
      {
        path: "product",
        component: () => import("@/components/admin/product/LayoutProductAdmin.vue"),
        children: [
          {
            path: "storeAdmin",
            name: "storeAdmin",
            component: () => import("@/components/admin/product/StoreAdmin.vue")
          },
          {
            path: "prodAdmin",
            name: "prodAdmin",
            component: () => import("@/components/admin/product/ProdAdmin.vue")
          }
        ]
      }
    ]
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
