<template>
  <div
    id="header"
    :class="{
      'on-home': onHome,
      'out-home': !onHome,
      sticky: currentPage !== 'storeDetailPage',
    }"
  >
    <div class="header_top">
      <div class="header_top_left">
        <router-link to="/" @click="goHome('homePage')">
          <img
            class="main-logo"
            src="@/assets/images/JoomakLogo_main.svg"
            alt="JoomakLogo"
          />
        </router-link>
      </div>
      <div class="header_top_middle">
        <address-config></address-config>
      </div>
      <div class="header_top_right">
        <router-link
          :to="`/member/${onLogin ? 'logout' : 'login'}`"
          class="header_top_right-elem"
          @click="outStoreListPage('loginPage')"
          :class="{ 'on-click-nav-li': currentPage === 'loginPage' }"
        >
          {{ onLogin ? "LogOut" : "LogIn" }}
        </router-link>
        <span>|</span>
        <router-link
          to="/order-status"
          class="header_top_right-elem"
          @click="outStoreListPage('orderStatusPage')"
          :class="{ 'on-click-nav-li': currentPage === 'orderStatusPage' }"
          >주문 현황</router-link
        >
        <span>|</span>
        <router-link
          v-if="currentAddress"
          to="/cart"
          class="header_top_right-elem"
          @click="outStoreListPage('cartPage')"
          :class="{ 'on-click-nav-li': currentPage === 'cartPage' }"
          >장바구니</router-link
        >
        <!-- fake link -->
        <a
          v-else-if="!currentAddress"
          to="/cart"
          class="header_top_right-elem"
          @click="checkAddressConfigSelection"
          :class="{ 'on-click-nav-li': currentPage === 'cartPage' }"
          >장바구니</a
        >
      </div>
    </div>
    <div class="header_bottom" v-if="currentAddress">
      <!-- v-for로 카테고리 li 반복 -->
      <router-link
        v-for="category in categories"
        :key="category.en"
        :to="`/store-list/${category.en}`"
        @click="onClickCategory(category.en, 'storeListPage')"
        :class="{ 'on-click-nav-li': currentCategory === category.en }"
      >
        {{ category.ko }}
      </router-link>
    </div>
    <!-- fake nav -->
    <div class="header_bottom" v-else-if="!currentAddress">
      <a
        v-for="category in categories"
        :key="category.en"
        :to="`/store-list/${category.en}`"
        @click.prevent="onClickCategory(category.en, 'storeListPage')"
        :class="{ 'on-click-nav-li': currentCategory === category.en }"
      >
        {{ category.ko }}
      </a>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { TOGGLE_ON_HOME, SET_CURRENT_PAGE } from "@/store/modules/common.js";
import { SET_CURRENT_CATEGORY } from "@/store/modules/product.js";
import AddressConfig from "../components/AddressConfig.vue";

export default {
  components: {
    AddressConfig,
  },
  computed: {
    ...mapState("common", ["onHome", "onLogin", "currentPage"]),
    ...mapState("member", ["currentAddress"]),
    ...mapState("product", ["categories", "currentCategory"]),
  },
  methods: {
    inHome() {
      if (!this.onHome) {
        this.$store.commit(`common/${TOGGLE_ON_HOME}`);
      }
    },
    outHome() {
      if (this.onHome) {
        this.$store.commit(`common/${TOGGLE_ON_HOME}`);
      }
    },
    setCategory(category) {
      this.$store.commit(`product/${SET_CURRENT_CATEGORY}`, category);
    },
    onClickCategory(category, pageName) {
      if (!this.currentAddress) {
        alert("먼저 주소를 설정해 주세요");
        return;
      }

      if (this.currentPage !== "storeListPage") {
        this.$store.commit(`common/${SET_CURRENT_PAGE}`, pageName);
      }
      this.outHome();
      this.setCategory(category);
    },

    initializeCategory() {
      this.$store.commit(`product/${SET_CURRENT_CATEGORY}`, "");
    },

    goHome(pageName) {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, pageName);
      this.inHome();
      this.initializeCategory();
      if (window.scrollY !== 0) {
        scrollTo(0, 0);
      }
    },
    outStoreListPage(pageName) {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, pageName);
      this.outHome();
      this.initializeCategory();
    },

    checkAddressConfigSelection() {
      if (!this.currentAddress) {
        alert("먼저 주소를 설정해 주세요");
        return;
      }
    },

    setCurrentCategoryAtLoad() {
      if (this.$route.name === "storeListPage") {
        if (!this.currentAddress) {
          alert("홈 화면에서 주소를 먼저 설정해 주세요.");
          this.$router.replace("/");
        } else {
          this.$store.commit(
            `product/${SET_CURRENT_CATEGORY}`,
            this.$route.params.food
          );
        }
      }
    },
  },
  created() {
    // 로드/리로드 이벤트 리스너 추가 : currentCategory 설정
    window.addEventListener("load", this.setCurrentCategoryAtLoad);
  },
  updated() {
    console.log("Header 업데이트됨");
  },
  beforeDestroy() {
    // 로드/리로드 이벤트 리스너 해제 : currentCategory 설정
    window.removeEventListener("load", this.setCurrentCategoryAtLoad);
  },
};
</script>

<style scoped>
#header {
  z-index: 10;
  box-sizing: border-box;
  padding-top: 2vh;
  padding-bottom: 0.5vh;
  text-decoration: none;
  width: 100%;
  height: 12vh;
  background-color: #ffc463;
  box-shadow: 0px 8px 10px rgba(0, 0, 0, 0.12);
}
#header.on-home {
  background-color: transparent;
  box-shadow: none;
}
#header.sticky {
  position: fixed;
  top: 0;
  left: 0;
}
.on-home,
.on-home a {
  color: white;
}
.out-home,
.out-home a {
  color: #9e9e9e;
}
.header_top {
  margin-left: 100px;
  margin-right: 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 5vh;
}
.header_top_left,
.header_top_middle,
.header_top_right {
  width: 33vw;
}
.main-logo {
  width: 65px;
  height: auto;
}
.header_top_right {
  display: flex;
  justify-content: flex-end;
}
.header_top_right > span {
  color: #b1b1b1;
}
a.header_top_right-elem {
  color: #999999;
  margin-left: 2.5vh;
  margin-right: 2.5vh;
}
a.header_top_right-elem:hover {
  color: white;
  font-weight: bold;
}
.header_top_right-elem:first-child {
  margin-left: 0px;
}
.header_top_right-elem:last-child {
  margin-right: 0px;
}
.header_top_right a {
  cursor: pointer;
}

.header_bottom {
  box-sizing: border-box;
  margin-left: 15vw;
  margin-right: 15vw;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: 4.5vh;
}
.header_bottom > a {
  font-size: 16px;
  cursor: pointer;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 10%;
  height: 100%;
  margin-left: 1vh;
  margin-right: 1vh;
}
.header_bottom > a:hover {
  color: white;
  font-weight: bold;
}
.header_bottom > a:hover::after {
  position: absolute;
  content: "";
  width: 60%;
  height: 4px;
  background-color: white;
  bottom: -0.5vh;
}

a.on-click-nav-li {
  color: white;
  font-weight: bold;
}
.header_bottom .on-click-nav-li::after {
  position: absolute;
  content: "";
  width: 60%;
  height: 4px;
  background-color: white;
  bottom: -0.5vh;
}
.header_bottom > a:hover::after {
  position: absolute;
  content: "";
  width: 60%;
  height: 4px;
  background-color: white;
  bottom: -0.5vh;
}
.header_bottom a:nth-last-child(2) {
  width: 17%;
}
</style>
