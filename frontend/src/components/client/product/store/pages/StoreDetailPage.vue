<template>
  <div id="storeDetailPage">
    <span>매장상세 페이지 입니다</span><br />
    <!-- <div>{{}}</div> 가게 이름 란 -->
    <div id="store-detail-page-nav">
      <div class="tab" @click="onClickTab('menu')">차림표</div>
      <div class="tab" @click="onClickTab('intro')">주막 소개</div>
      <div class="tab" @click="onClickTab('review')">나그네 생생리뷰</div>
    </div>
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
</template>

<script>
import axios from "axios";
import StoreDetailPageMenuSelectTab from "./StoreDetailPageMenuSelectTab.vue";
import StoreDetailPageStoreIntroTab from "./StoreDetailPageStoreIntroTab.vue";
import StoreDetailPageStoreReviewTab from "./StoreDetailPageStoreReviewTab.vue";

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
  methods: {
    onClickTab(clickedTab) {
      this.tab = clickedTab;
    },
    read(idx) {
      axios
        .get("https://reqres.in/api/users?page=" + idx)
        .then((res) => {
          console.log("메뉴선택 페이지(매장 상세정보 열람용) axios 통신 성공");
          console.log(res.data.data);
        })
        .catch((err) => {
          cosonle.log(err);
        });
    },
  },
  mounted() {
    console.log("현재 라우트는 아래와 같다");
    console.log(this.$route);
    console.log("axios 테스트 2");
    this.read(this.$route.params.idx);
  },
};
</script>

<style scoped>
#storeDetailPage {
  width: 500px;
  height: 5000px;
  background-color: yellow;
}
#store-detail-page-nav {
  display: flex;
  justify-content: space-between;
}
#store-detail-page-nav .tab {
  cursor: pointer;
  color: blue;
}
</style>
