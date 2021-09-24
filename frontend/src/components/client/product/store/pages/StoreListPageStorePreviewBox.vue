<template>
  <div id="store-preview-box">
    <div id="store-preview-box_header">
      <div
        :class="{ 'on-info': previewTab === 'info' }"
        @click="onClickPreviewTab('info')"
      >
        매장 정보
      </div>
      <div
        :class="{ 'on-review': previewTab === 'review' }"
        @click="onClickPreviewTab('review')"
      >
        리뷰
      </div>
    </div>
    <div id="store-preview-box_main-wrap">
      <div id="store-preview-box_main">
        <div
          id="preview_home"
          class="store-preview-box_main-content"
          v-if="previewTab === 'info'"
        >
          <div class="preview_home_top">
            <h3>{{ previewHome.name }}</h3>
            <div class="interest_box" @click="onClickInterestBox">
              <img :src="isInterested" alt="관심 매장" />
              <span>관심 매장</span>
            </div>
          </div>
          <div class="preview_home_middle">
            <div
              class="preview_img_wrap"
              v-for="previewImage in previewHome.image.previewImages"
              :key="previewImage.idx"
            >
              <img :src="previewImage.img" :alt="previewImage.imgAlt" />
            </div>
            <div id="preview_logo_wrap">
              <img
                :src="previewHome.image.logoImg"
                :alt="previewHome.image.logoImagAlt"
              />
            </div>
          </div>
          <div class="preview_home_bottom">
            <store-list-page-preview-info-slot :slotInfo="slotInfo.review">
              <div id="preview_slot_review">
                <div>
                  <span>주문자 리뷰</span
                  ><span>{{ previewHome.numberOfReview }}</span>
                </div>
                <div>
                  <span>사장님 댓글</span
                  ><span>{{ previewHome.numberOfOwnerReview }}</span>
                </div>
              </div>
            </store-list-page-preview-info-slot>
            <hr />
            <store-list-page-preview-info-slot :slotInfo="slotInfo.order">
              <div id="preview_slot_order">
                <div>
                  <span>총 주문 횟수</span>
                  <span>{{ totalOrder }}</span>
                </div>
                <div>
                  <span>1달 간 주문 횟수</span>
                  <span>{{ monthOrder }}</span>
                </div>
              </div>
            </store-list-page-preview-info-slot>
            <hr />
            <store-list-page-preview-info-slot
              :slotInfo="slotInfo.businessHours"
            >
              <div
                id="preview_slot_business-hours"
                v-html="businessHoursNextLine"
              ></div>
            </store-list-page-preview-info-slot>
          </div>
        </div>

        <div
          id="preview_review"
          class="store-preview-box_main-content"
          v-else-if="previewTab === 'review'"
        >
          리뷰 미리보기 부분입니다
        </div>
      </div>
    </div>
    <div
      id="preview_switch"
      @click="onClickPreviewSwitch"
      :class="{ 'off-preview': !onPreviewBox }"
    >
      <img
        v-if="onPreviewBox"
        src="@/assets/images/store-list_arrow-left.svg"
        alt="arrow-left"
      />
      <img
        v-else-if="!onPreviewBox"
        src="@/assets/images/store-list_arrow-right.svg"
        alt="arrow-right"
      />
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { SET_ON_PREVIEW_BOX, SET_PREVIEW_TAB } from "@/store/modules/common.js";
import StoreListPagePreviewInfoSlot from "../components/StoreListPagePreviewInfoSlot.vue";
import { TOGGLE_INTEREST_BOX } from "@/store/modules/product.js";

export default {
  components: {
    StoreListPagePreviewInfoSlot,
  },
  data() {
    return {
      slotInfo: {
        review: {
          title: "리뷰",
          icon: require("@/assets/images/icon_preview_review.svg"),
          iconAlt: "icon_preview_review",
        },
        order: {
          title: "주문 횟수",
          icon: require("@/assets/images/icon_preview_ordering-finger.svg"),
          iconAlt: "icon_preview_order",
        },
        businessHours: {
          title: "매장 영업 시간",
          icon: require("@/assets/images/icon_preview_business-hours.svg"),
          iconAlt: "icon_preview_business-hours",
        },
      },
    };
  },
  computed: {
    ...mapState("common", ["onPreviewBox", "previewTab"]),
    ...mapState("product", ["previewHome", "previewReview"]),
    isInterested() {
      if (!this.previewHome.isInterested) {
        return require("@/assets/images/icon_heart_empty.svg");
      } else {
        return require("@/assets/images/icon_heart_full.svg");
      }
    },
    totalOrder() {
      let num = this.previewHome.totalOrder;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    monthOrder() {
      let num = this.previewHome.monthOrder;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    businessHoursNextLine() {
      return this.previewHome.businessHours.replaceAll("\n", "<br />");
    },
  },
  methods: {
    ...mapActions("product", [`${TOGGLE_INTEREST_BOX}`]),
    onClickPreviewTab(tabName) {
      if (tabName !== this.previewTab) {
        this.$store.commit(`common/${SET_PREVIEW_TAB}`, tabName);
      }
    },
    closePreviewBox() {
      const storeListPageMainWrap = document.querySelector(
        "#store-list-page_main-wrap"
      );
      const storeListPageMain = document.querySelector("#store-list-page_main");
      const scaleBox = document.querySelector("#scale-box");
      const storePreviewBox = document.querySelector("#store-preview-box");

      storeListPageMainWrap.style.width = `${document.body.offsetWidth}px`;
      storeListPageMain.style.width = `${document.body.offsetWidth * 0.8}px`;
      storePreviewBox.style.width = `${document.body.offsetWidth * 0.28}px`;
      scaleBox.style.width = 0;
    },
    openPreviewBox() {
      const storeListPageMainWrap = document.querySelector(
        "#store-list-page_main-wrap"
      );
      const storeListPageMain = document.querySelector("#store-list-page_main");
      const scaleBox = document.querySelector("#scale-box");

      storeListPageMainWrap.style.width = `${document.body.offsetWidth *
        0.72}px`;
      storeListPageMain.style.width = `${document.body.offsetWidth * 0.72}px`;
      scaleBox.style.width = `${document.body.offsetWidth * 0.28}px`;
    },
    onClickPreviewSwitch() {
      // previewBox 닫기
      if (this.onPreviewBox) {
        this.closePreviewBox();
        this.$store.commit(`common/${SET_ON_PREVIEW_BOX}`, false);
      }
      // previewBow 열기
      else {
        this.openPreviewBox();
        this.$store.commit(`common/${SET_ON_PREVIEW_BOX}`, true);
      }
    },
    resizePreviewLayout() {
      const storeListPageMainWrap = document.querySelector(
        "#store-list-page_main-wrap"
      );
      const storeListPageMain = document.querySelector("#store-list-page_main");
      const scaleBox = document.querySelector("#scale-box");
      const storePreviewBox = document.querySelector("#store-preview-box");

      storeListPageMainWrap.style.transition = "none";
      storeListPageMain.style.transition = "none";
      scaleBox.style.transition = "none";
      storePreviewBox.style.transition = "none";

      // 미리보기 창 열려있을 때 resize
      if (this.onPreviewBox) {
        this.openPreviewBox();
        storePreviewBox.style.width = `${document.body.offsetWidth * 0.28}px`;
      }
      // 미리보기 창 닫혀있을 때 resize
      else {
        this.closePreviewBox();
      }

      setTimeout(() => {
        storeListPageMainWrap.style.transition = "all 0.7s";
        storeListPageMain.style.transition = "all 0.7s";
        scaleBox.style.transition = "all 0.7s";
        storePreviewBox.style.transition = "all 0.7s";
      }, 10);

      this.resizePreviewImgRatio();
    },
    onClickInterestBox() {
      this.TOGGLE_INTEREST_BOX();
    },
    resizePreviewImgRatio() {
      const previewImgWrap = document.querySelector(".preview_img_wrap");
      const previewImgWrapRatio =
        previewImgWrap.offsetWidth / previewImgWrap.offsetHeight;

      const previewImgs = document.querySelectorAll(".preview_img_wrap > img");
      previewImgs.forEach((img) => {
        const imgRatio = img.naturalWidth / img.naturalHeight;
        if (previewImgWrapRatio < imgRatio) {
          img.style.height = "100%";
          img.style.width = "auto";
        } else {
          img.style.width = "100%";
          img.style.height = "auto";
        }
      });
    },
  },
  created() {
    // previewTab = 'info'로 초기화
    if (this.previewTab !== "info") {
      this.$store.commit(`common/${SET_PREVIEW_TAB}`, "info");
    }
  },
  mounted() {
    window.addEventListener("resize", this.resizePreviewLayout);
    this.resizePreviewImgRatio();
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.resizePreviewLayout);
  },
};
</script>

<style scoped>
#store-preview-box {
  transition: all 0.7s;
  position: relative;
  width: 28%;
  height: 100%;
  background-color: coral;
}

#store-preview-box_header {
  display: flex;
  width: 100%;
  height: 9vh;
  background-color: #ffe46a;
}
#store-preview-box_header > div {
  cursor: pointer;
  color: #858585;
  font-size: 16px;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
}
#store-preview-box_header > div.on-info {
  background-color: #fff0b1;
  color: #292929;
  border-top-right-radius: 3vh;
}
#store-preview-box_header > div.on-review {
  background-color: #fff0b1;
  color: #292929;
  border-top-left-radius: 3vh;
}

#store-preview-box_main-wrap {
  box-sizing: border-box;
  padding-top: 2.5vh;
  padding-bottom: 2.5vh;
  padding-left: 10px;
  overflow-y: scroll;
  display: flex;
  justify-content: center;
  width: 100%;
  height: 79vh;
  background-color: #fff0b1;
}
#store-preview-box_main-wrap:hover::-webkit-scrollbar-thumb {
  background-color: rgba(0, 0, 0, 0.4);
  border-radius: 10px;
}
#store-preview-box_main-wrap::-webkit-scrollbar {
  width: 10px;
  background-color: transparent;
}
#store-preview-box_main {
  padding: 4vh 3.5vh;
  width: 25vw;
  height: fit-content;
  background-color: #fff5eb;
}

/* home tap */
#preview_home {
  width: 100%;
}
.preview_home_top {
  margin-bottom: 4vh;
  display: flex;
  justify-content: space-between;
}
.preview_home_top > h3 {
  margin: 0;
  font-size: 16px;
  font-weight: bold;
}

.preview_home_top .interest_box {
  cursor: pointer;
}
.preview_home_top .interest_box > img {
  height: 14px;
  width: auto;
  margin-right: 1vh;
}

.preview_home_middle {
  margin-bottom: 4vh;
  overflow: hidden;
  border-radius: 10px;
  position: relative;
  width: 100%;
  height: 27vh;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 1px;
  grid-auto-rows: minmax(50%, 50%);
  justify-items: center;
  align-items: center;
}
.preview_img_wrap {
  cursor: pointer;
  overflow: hidden;
  background: chocolate;
  display: flex;
  align-items: center;
  width: 100%;
  height: 100%;
}
.preview_img_wrap > img {
  width: 100%;
  height: auto;
}
.preview_img_wrap:nth-child(4) {
  position: relative;
}
.preview_img_wrap:nth-child(4)::before {
  transition: 0.3s;
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  content: "";
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
}
.preview_img_wrap:nth-child(4)::after {
  transition: 0.3s;
  content: "";
  display: block;
  position: absolute;
  top: calc(50% - 1.5vh);
  left: calc(50% - 1.5vh);
  width: 3vh;
  height: 3vh;
  background: url("~@/assets/images/icon_plus_btn_gray.svg");
  background-size: 100% 100%;
}
.preview_img_wrap:nth-child(4):hover::before {
  background-color: rgba(0, 0, 0, 0.6);
}
.preview_img_wrap:nth-child(4):hover::after {
  background: url("~@/assets/images/icon_plus_btn_white.svg");
  background-size: 100% 100%;
}
#preview_logo_wrap {
  border-radius: 10px;
  padding: 0.5vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  position: absolute;
  top: calc(50% -5vh);
  left: calc(50% - 5vh);
  width: 10vh;
  height: 10vh;
}
#preview_logo_wrap > img {
  width: 100%;
  height: auto;
}

.preview_home_bottom {
  width: 100%;
  height: fit-content;
}
.preview_home_bottom span {
  font-size: 12px;
}
#preview_slot_review {
  display: flex;
  gap: 3vh;
  justify-content: space-between;
}
#preview_slot_review > div {
  display: flex;
  gap: 2vh;
}

#preview_slot_order > div {
  display: flex;
  justify-content: space-between;
}
#preview_slot_order > div:first-child {
  padding-bottom: 1vh;
}
#preview_slot_business-hours {
  line-height: 2;
}

.preview_home_bottom hr {
  background-color: #888;
}

#preview_switch {
  display: flex;
  align-items: center;
  position: absolute;
  top: 41vh;
  right: 0;
  cursor: pointer;
  width: 3vh;
  height: 6vh;
  background-color: rgba(0, 0, 0, 0.2);
  border-top-left-radius: 3vh;
  border-bottom-left-radius: 3vh;
}
#preview_switch:hover {
  background-color: rgba(0, 0, 0, 0.5);
}
#preview_switch > img {
  position: absolute;
  right: 20%;
}
#preview_switch.off-preview > img {
  position: absolute;
  left: 20%;
}
#preview_switch.off-preview {
  right: -3vh;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
  border-top-right-radius: 3vh;
  border-bottom-right-radius: 3vh;
}
</style>
