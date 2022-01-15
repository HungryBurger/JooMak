<template>
  <div id="storeDetailPage">
    <div id="store-detail-page_top">
      <img
        id="store-detail-page_top_img"
        :src="storeSimpleInfo.image.representativeImg"
        alt="representativeImg"
      />
      <div id="store-detail-page_top_info">
        <div class="top_info_left">
          <div class="img_wrap">
            <img :src="storeSimpleInfo.image.logoImg" alt="logoImg" />
          </div>
          <div class="title_wrap">
            <div class="interest_box" @click="onClickInterestBox">
              <img :src="imageIsInterestedPath" alt="관심 매장" />
              <span>관심 매장</span>
            </div>
            <h3>{{ storeSimpleInfo.name }}</h3>
            <div class="title_wrap_bottom">
              <div class="star_box">
                <img :src="imageStarPath" alt="icon_star" />
                <span>{{ storeSimpleInfo.starAverage }}</span>
              </div>
              <div class="min-order-price_wrap">
                <span>최소주문금액</span>
                <span>{{ minOrderPrice }}</span>
              </div>
            </div>
          </div>
        </div>
        <div class="top_info_right">
          <div class="notice_top">
            <img src="@/assets/images/icon_notice.svg" alt="icon_notice" />
            <span>이 집 주모 한마디</span>
          </div>
          <div class="notice_bottom" v-html="noticeLextLine"></div>
        </div>
      </div>
    </div>
    <div
      id="store-detail-page_nav"
      :class="{ 'on-alert-modal': onAddressConfigRequestModal }"
    >
      <div
        class="tab"
        @click="onClickTab('menu')"
        :class="{ 'current-tab': tab === 'menu' }"
      >
        차림표
        <div v-if="tab === 'menu'" id="detail-page_menu-nav">
          <div
            class="detail-page_menu-nav_li_wrap"
            :class="{
              'current-product-group': currentProductGroup === productIndex,
            }"
            v-for="(product, productIndex) in products.allProducts"
            :key="product.groupIdx"
            @click.stop="onClickMenuNav(productIndex)"
          >
            <div class="detail-page_menu-nav_li">
              {{ product.groupName }}
            </div>
          </div>
        </div>
      </div>
      <div
        class="tab"
        @click="onClickTab('intro')"
        :class="{ 'current-tab': tab === 'intro' }"
      >
        주막 소개
      </div>
      <div
        class="tab"
        @click="onClickTab('review')"
        :class="{ 'current-tab': tab === 'review' }"
      >
        나그네 생생리뷰
      </div>
      <div id="detail-page_scroll-top_btn" @click="onClickScrollTopBtn">
        <img src="@/assets/images/icon_arrow-top.svg" alt="icon_arrow-top" />
      </div>
      <store-detail-page-menu-select-modal></store-detail-page-menu-select-modal>
    </div>
    <div
      id="store-detail-page_bottom"
      :class="{
        'on-menu-tab': tab === 'menu',
        'on-intro-tab': tab === 'intro',
        'on-review-tab': tab === 'review',
        'nav-on-fixed': navOnFixed,
      }"
    >
      <store-detail-page-menu-select-tab
        v-if="tab === 'menu'"
        :products="products"
      ></store-detail-page-menu-select-tab>
      <store-detail-page-store-intro-tab
        v-else-if="tab === 'intro'"
      ></store-detail-page-store-intro-tab>
      <store-detail-page-store-review-tab
        v-else-if="tab === 'review'"
      ></store-detail-page-store-review-tab>
    </div>
  </div>
</template>

<script>
import StoreDetailPageMenuSelectTab from "@/components/client/product/store/pages/StoreDetailPageMenuSelectTab.vue";
import StoreDetailPageStoreIntroTab from "@/components/client/product/store/pages/StoreDetailPageStoreIntroTab.vue";
import StoreDetailPageStoreReviewTab from "@/components/client/product/store/pages/StoreDetailPageStoreReviewTab.vue";
import StoreDetailPageMenuSelectModal from "@/components/client/product/store/components/StoreDetailPageMenuSelectModal.vue";
import { mapActions, mapState } from "vuex";
import { SET_CURRENT_PAGE } from "@/store/modules/common.js";
import { TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE } from "@/store/modules/product.js";

export default {
  components: {
    StoreDetailPageMenuSelectTab,
    StoreDetailPageStoreIntroTab,
    StoreDetailPageStoreReviewTab,
    StoreDetailPageMenuSelectModal,
  },
  data() {
    return {
      tab: "menu",
      navOnFixed: false,
      currentProductGroup: 0,
      arrayOfProductBoxAbsoluteTop: [],
    };
  },
  computed: {
    ...mapState("common", ["currentPage", "onAddressConfigRequestModal"]),
    ...mapState("product", ["storeSimpleInfo", "products"]),
    imageIsInterestedPath() {
      if (!this.storeSimpleInfo.isInterested) {
        return require("@/assets/images/icon_heart_empty.svg");
      } else {
        return require("@/assets/images/icon_heart_full.svg");
      }
    },
    imageStarPath() {
      return require("@/assets/images/icon_star.svg");
    },
    minOrderPrice() {
      let num = this.storeSimpleInfo.minOrderPrice;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    noticeLextLine() {
      return this.storeSimpleInfo.notice.replaceAll("\n", "<br />");
    },
  },
  methods: {
    ...mapActions("product", [`${TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE}`]),
    /* 상단 매장 정보 영역 */
    onClickInterestBox() {
      this.TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE();
    },

    /* Nav */
    checkCurrentScrollY() {
      const storeDetailPageNav = document.querySelector(
        "#store-detail-page_nav"
      );
      if (window.scrollY >= window.innerHeight) {
        storeDetailPageNav.style.position = "fixed";
        this.navOnFixed = true;
      } else {
        storeDetailPageNav.style.position = "relative";
        this.navOnFixed = false;
      }
    },
    onScrollForNavTab() {
      this.checkCurrentScrollY();
    },
    onClickTab(clickedTab) {
      scrollTo(0, window.innerHeight);
      this.tab = clickedTab;
      this.checkCurrentScrollY();
    },
    onClickMenuNav(productIndex) {
      scrollTo(0, this.arrayOfProductBoxAbsoluteTop[productIndex] + 1); // 미세한 오차로 인해 1px을 더 이동
    },
    onClickScrollTopBtn() {
      scrollTo(0, 0);
    },

    /* 메뉴 선택 탭 */
    setArrayOfProductBoxAbsoluteTop() {
      const absoluteTops = [];
      const currentProductGroupBox = document.querySelectorAll(
        ".product-group-box"
      );
      for (let i = 0; i < currentProductGroupBox.length; i++) {
        let productBoxAbsoluteTop =
          currentProductGroupBox[i].getBoundingClientRect().top +
          window.pageYOffset;
        const storeDetailPageNav = document.querySelector(
          "#store-detail-page_nav"
        );
        const detailPageMenuNav = document.querySelector(
          "#detail-page_menu-nav"
        );
        const navHeight =
          storeDetailPageNav.offsetHeight + detailPageMenuNav.offsetHeight;
        const viewportHeight = window.innerHeight;
        absoluteTops.push(
          productBoxAbsoluteTop - navHeight - viewportHeight * 0.05
        );
        // this.arrayOfProductBoxAbsoluteTop에 직접 push하지 않는 이유 :
        // 만약 직접 push 한다면,
        // resize 시 새로운 절대 좌표들이 갱신되지 않고 그 뒤에 push 되기만 할 것이기 때문
      }
      this.arrayOfProductBoxAbsoluteTop = absoluteTops;
    },
    onScrollForProductList() {
      let currentProductBoxAbsoluteScrollY;
      let nextProductBoxAbsoluteScrollY;
      for (let i = 0; i < this.arrayOfProductBoxAbsoluteTop.length; i++) {
        currentProductBoxAbsoluteScrollY = this.arrayOfProductBoxAbsoluteTop[i];
        nextProductBoxAbsoluteScrollY = this.arrayOfProductBoxAbsoluteTop[
          i + 1
        ];
        if (
          window.scrollY >= currentProductBoxAbsoluteScrollY &&
          window.scrollY < nextProductBoxAbsoluteScrollY
        ) {
          this.currentProductGroup = i;
        }
      }
    },

    read(idx) {
      this.$axios
        .get("https://reqres.in/api/users?page=" + idx)
        .then((res) => {
          console.log("메뉴선택 페이지(매장 상세정보 열람용) axios 통신 성공");
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    if (this.currentPage !== "storeDetailPgae") {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, "storeDetailPage");
    }
  },
  mounted() {
    // console.log("현재 라우트는 아래와 같다");
    // console.log(this.$route);
    // console.log("axios 테스트 2");
    this.read(this.$route.params.idx);

    this.setArrayOfProductBoxAbsoluteTop(); // productBoxes에 모든 .product-group-box의 top 절대좌표 추가
    window.addEventListener("resize", this.setArrayOfProductBoxAbsoluteTop);
    window.addEventListener("resize", this.onScrollForProductList);

    window.addEventListener("scroll", this.onScrollForNavTab);
    window.addEventListener("scroll", this.onScrollForProductList);
  },
  beforeUnmount() {
    window.removeEventListener("scroll", this.onScrollForNavTab);
    window.removeEventListener("scroll", this.onScrollForProductList);

    window.removeEventListener("resize", this.setArrayOfProductBoxAbsoluteTop);
    window.removeEventListener("resize", this.onScrollForProductList);
  },
};
</script>

<style scoped>
#storeDetailPage {
  width: 100%;
}

#store-detail-page_top {
  overflow: hidden;
  position: relative;
  width: 100%;
  height: 88vh;
}
#store-detail-page_top_img {
  width: 100%;
  height: auto;
}
#store-detail-page_top_info {
  display: flex;
  justify-content: space-between;
  gap: 3vw;
  padding: 5vh 10vw;
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 25vh;
  background-color: rgba(0, 0, 0, 0.5);
}
#store-detail-page_top_info .top_info_left {
  color: white;
  display: flex;
  justify-content: space-between;
  gap: 5vh;
  height: 100%;
}
#store-detail-page_top_info .top_info_left .img_wrap {
  padding: 1vh;
  overflow: hidden;
  width: 15vh;
  height: 15vh;
  border-radius: 3vh;
  background-color: #ffdd1b;
}
#store-detail-page_top_info .top_info_left .img_wrap > img {
  height: 100%;
  width: auto;
}
#store-detail-page_top_info .top_info_left .title_wrap {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-between;
  height: 100%;
}
#store-detail-page_top_info .top_info_left .interest_box {
  cursor: pointer;
}
#store-detail-page_top_info .top_info_left .interest_box > img,
#store-detail-page_top_info .top_info_left .star_box > img {
  height: 16px;
  width: auto;
}
#store-detail-page_top_info .top_info_left h3 {
  font-weight: bold;
  margin: 0;
}
#store-detail-page_top_info .top_info_left span {
  padding-left: 1vh;
  font-size: 16px;
}
#store-detail-page_top_info .top_info_left .title_wrap_bottom {
  display: flex;
  gap: 5vh;
}
#store-detail-page_top_info
  .top_info_left
  .min-order-price_wrap
  > span:nth-last-child(1) {
  font-weight: bold;
}

#store-detail-page_top_info .top_info_right {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 40%;
  height: 100%;
}
#store-detail-page_top_info .top_info_right .notice_top {
  display: flex;
  gap: 1vh;
}
#store-detail-page_top_info .top_info_right .notice_top > img {
  height: 16px;
  width: auto;
}
#store-detail-page_top_info .top_info_right .notice_top > span {
  color: white;
  font-weight: bold;
}
#store-detail-page_top_info .top_info_right .notice_bottom {
  overflow-y: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 10vh;
  background-color: white;
  border: 2px solid #ffdd1b;
  border-radius: 3vh;
  padding: 1vh;
}

#store-detail-page_nav {
  z-index: 50;
  top: 0;
  left: 0;
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 7vh;
  display: flex;
  justify-content: space-between;
}
#store-detail-page_nav.on-alert-modal {
  z-index: 1;
}
#store-detail-page_nav .tab {
  color: #5e5e5e;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 16px;
  border-right: 2px solid white;
  background-color: #e0e0e0;
  width: 100%;
  height: 100%;
  cursor: pointer;
}
#store-detail-page_nav .tab:nth-child(3) {
  border-right: none;
}
#store-detail-page_nav .tab.current-tab {
  background-color: white;
  color: #292929;
}
#store-detail-page_nav .tab:hover:not(.current-tab) {
  background-color: #efefef;
}
#detail-page_scroll-top_btn {
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  position: absolute;
  right: calc((100px + 4vw) / 2 - 5vh);
  top: 80vh;
  width: 10vh;
  height: 10vh;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius: 5vh;
}
#detail-page_scroll-top_btn > img {
  height: 2.3vh;
  width: auto;
}
#detail-page_scroll-top_btn:hover {
  background-color: rgba(0, 0, 0, 0.6);
}
#detail-page_menu-nav {
  cursor: default;
  display: flex;
  justify-content: flex-start;
  padding-left: 100px;
  font-weight: normal;
  position: absolute;
  bottom: -5vh;
  left: 0;
  width: 100%;
  height: 5vh;
  background-color: white;
}
#detail-page_menu-nav::after {
  position: absolute;
  content: "";
  width: 100%;
  height: 2px;
  display: block;
  bottom: -2px;
  left: 0;
  background-color: #f0f0f0;
}
.detail-page_menu-nav_li_wrap {
  padding: 0 2vw;
  height: 100%;
  cursor: pointer;
}
.detail-page_menu-nav_li {
  position: relative;
  display: flex;
  align-items: center;
  height: 100%;
}
.detail-page_menu-nav_li::after {
  position: relative;
  z-index: 5;
  content: "";
  display: block;
  position: absolute;
  bottom: -2px;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: transparent;
}
.detail-page_menu-nav_li_wrap:hover .detail-page_menu-nav_li {
  font-weight: bold;
}
.detail-page_menu-nav_li_wrap:hover .detail-page_menu-nav_li::after {
  background-color: #ffdd1b;
}
.detail-page_menu-nav_li_wrap.current-product-group {
  font-weight: bold;
}
.detail-page_menu-nav_li_wrap.current-product-group
  .detail-page_menu-nav_li::after {
  background-color: #ffdd1b;
}

#store-detail-page_bottom > div {
  background-color: white;
}
#store-detail-page_bottom.on-menu-tab {
  margin-top: calc(5vh + 2px);
}
#store-detail-page_bottom.on-intro-tab,
#store-detail-page_bottom.on-review-tab {
  margin-top: 0;
}
#store-detail-page_bottom.on-menu-tab.nav-on-fixed {
  margin-top: calc(12vh + 2px);
}
#store-detail-page_bottom.on-intro-tab.nav-on-fixed,
#store-detail-page_bottom.on-review-tab.nav-on-fixed {
  margin-top: 7vh;
}

/* #store-detail-page_nav .modal_card {
  padding: 0;
  min-height: 70vh;
  width: 60%;
  height: 80vh;
} */
</style>
