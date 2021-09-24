<template>
  <li class="store-list-page_li">
    <div class="store-list-page_li_left" @click="onClickLiLeft(store.idx)">
      <div class="li_logo_wrap">
        <img :src="store.logoImg" :alt="store.logoImgAlt" />
      </div>
      <div class="li_info_wrap">
        <span class="li_info_top">{{ store.name }}</span>
        <div class="li_info_middle">
          <div class="li_info_middle_left">
            <img src="@/assets/images/icon_star.svg" alt="icon_star" />
            <span>{{ store.starAverage }}</span>
          </div>
          <div class="li_info_middle_right">
            <img :src="arrivalTimeInfo.imgPath" :alt="arrivalTimeInfo.alt" />
            <span>{{ arrivalTimeInfo.status }}</span>
          </div>
        </div>
        <div class="li_info_bottom">
          <span>리뷰&nbsp;&nbsp;{{ store.numberOfReview }}</span>
          <span>|</span>
          <span>사장님 댓글&nbsp;&nbsp;{{ store.numberOfOwnerReview }}</span>
        </div>
      </div>
    </div>
    <router-link
      :to="`/store/${store.idx}`"
      class="store-list-page_li_right"
      @click="changePage('storeDetailPage', store.idx)"
    >
      <div class="li_right_front">
        <img
          src="@/assets/images/store-list-page_li_arrow-right.svg"
          alt="li_arrow-right"
        />
      </div>
      <div class="li_right_back">
        <img
          src="@/assets/images/icon_joomo_basic.svg"
          alt="icon_joomo_basic"
        />
      </div>
    </router-link>
  </li>
</template>

<script>
import axios from "axios";
import { SET_CURRENT_PAGE } from "@/store/modules/common.js";
import { SET_PREVIEW_HOME } from "@/store/modules/product.js";
import { mapActions } from "vuex";

export default {
  props: ["store"],
  computed: {
    arrivalTimeInfo() {
      // 브레이크
      if (this.store.minutes === -1) {
        return {
          imgPath: require("@/assets/images/icon_arrival-time_break.svg"),
          status: "브레이크 중",
          alt: "break",
        };
      }
      // 60분 이상
      else if (this.store.minutes >= 60) {
        return {
          imgPath: require("@/assets/images/icon_arrival-time_over-60.svg"),
          status: "1시간 이상",
          alt: "over 60",
        };
      }
      // 40 - 60분
      else if (this.store.minutes >= 40) {
        return {
          imgPath: require("@/assets/images/icon_arrival-time_40-to-60.svg"),
          status: "40 ~ 60 분",
          alt: "40 to 60",
        };
      }
      // 40분 이내
      else {
        return {
          imgPath: require("@/assets/images/icon_arrival-time_in-40.svg"),
          status: "40분 이내",
          alt: "in 40",
        };
      }
    },
  },
  methods: {
    ...mapActions("product", [`${SET_PREVIEW_HOME}`]),
    // axios preview 정보 요청 함수
    getPreviewHome(idx) {
      axios
        .get("https://reqres.in/api/users?page=" + idx) // 임시 url로 요청. 추후 수정 예정
        .then((res) => {
          console.log(res);
          // this.SET_PREVIEW_HOME(res); // res를 store의 previewHome에 저장
        })
        .catch((err) => {
          console.log(err);
        });
    },
    onClickLiLeft(idx) {
      this.getPreviewHome(idx);
    },
    changePage(pageName, idx) {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, pageName);
      this.read(idx);
    },
    read(idx) {
      axios
        .get("https://reqres.in/api/users?page=" + idx)
        .then((res) => {
          console.log("매장리스트 페이지(미리보기창 용) axios 통신 성공");
          console.log(res.data.data);
        })
        .catch((err) => {
          cosonle.log(err);
        });
    },
  },
};
</script>

<style scoped>
.store-list-page_li {
  display: flex;
  cursor: pointer;
  display: flex;
  align-items: center;
  width: 100%;
  height: 12vh;
  padding-left: 1vh;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
}
.store-list-page_li:hover,
.store-list-page_li:hover .li_logo_wrap {
  border-color: #ffdd1b;
}

.store-list-page_li span:not(.li_info_top) {
  font-size: 12px;
}

.store-list-page_li_left {
  width: 83%;
  display: flex;
  align-items: center;
}

.li_logo_wrap {
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 10vh;
  height: 10vh;
  padding: 0.5vh;
}
.li_logo_wrap > img {
  width: 100%;
  height: augo;
}

.li_info_wrap {
  width: 80%;
  padding-left: 2vh;
  display: flex;
  flex-direction: column;
  gap: 0.5vh;
}

.li_info_middle {
  display: flex;
}
.li_info_middle_left,
.li_info_middle_right {
  display: flex;
  align-items: center;
}
.li_info_middle span {
  padding-left: 1vh;
  /* line-height: 1.3; */
  text-align: center;
}
.li_info_middle_left > img {
  height: 1.8vh;
  width: auto;
}
.li_info_middle_right {
  padding-left: 5vh;
}
.li_info_middle_right > img {
  height: 1.5vh;
  width: auto;
}
.li_info_bottom {
  display: flex;
}
.li_info_bottom > span:nth-child(2) {
  padding: 0 3vh;
}

.store-list-page_li_right {
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  overflow: hidden;
  position: relative;
  left: 1px;
  width: 17%;
  height: calc(100% + 2px);
}
.li_right_front,
.li_right_back {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}
.li_right_front {
  transition: 0.7s;
  z-index: 10;
  background-color: #ffdd1b;
}
.store-list-page_li_right:hover .li_right_front {
  transform: translateX(75%);
}
.store-list-page_li_right:hover .li_right_back > img {
  transform: translateX(-70%);
}
.li_right_front > img {
  width: auto;
  height: 17%;
}
.li_right_back {
  width: calc(100% - 1px);
  background-color: #b88154;
}
.li_right_back > img {
  transition: 0.7s;
  position: absolute;
  right: -20%;
  width: 60%;
  height: auto;
}
</style>
