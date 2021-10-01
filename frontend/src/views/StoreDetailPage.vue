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
    <div id="store-detail-page_nav">
      <div class="tab" @click="onClickTab('menu')">차림표</div>
      <div class="tab" @click="onClickTab('intro')">주막 소개</div>
      <div class="tab" @click="onClickTab('review')">나그네 생생리뷰</div>
    </div>
    <div id="store-detail-page_bottom">
      <store-detail-page-menu-select-tab
        v-if="tab === 'menu'"
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
import axios from "axios";
import StoreDetailPageMenuSelectTab from "@/components/client/product/store/pages/StoreDetailPageMenuSelectTab.vue";
import StoreDetailPageStoreIntroTab from "@/components/client/product/store/pages/StoreDetailPageStoreIntroTab.vue";
import StoreDetailPageStoreReviewTab from "@/components/client/product/store/pages/StoreDetailPageStoreReviewTab.vue";
import { mapActions, mapState } from "vuex";
import { SET_CURRENT_PAGE } from "@/store/modules/common.js";
import { TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE } from "@/store/modules/product.js";

export default {
  components: {
    StoreDetailPageMenuSelectTab,
    StoreDetailPageStoreIntroTab,
    StoreDetailPageStoreReviewTab,
  },
  data() {
    return {
      tab: "menu",
    };
  },
  computed: {
    ...mapState("common", ["currentPage"]),
    ...mapState("product", ["storeSimpleInfo"]),
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
    onClickInterestBox() {
      this.TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE();
    },
    onClickTab(clickedTab) {
      this.tab = clickedTab;
    },
    read(idx) {
      axios
        .get("https://reqres.in/api/users?page=" + idx)
        .then((res) => {
          // console.log("메뉴선택 페이지(매장 상세정보 열람용) axios 통신 성공");
          // console.log(res.data.data);
        })
        .catch((err) => {
          cosonle.log(err);
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
  },
};
</script>

<style scoped>
#storeDetailPage {
  width: 100%;
  height: 5000px;
  background-color: yellow;
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
  display: flex;
  justify-content: space-between;
}
#store-detail-page_nav .tab {
  cursor: pointer;
  color: blue;
}
</style>
