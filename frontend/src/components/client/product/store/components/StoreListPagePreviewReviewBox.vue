<template>
  <div class="preview_review_box">
    <div class="preview_review_box_top">
      <div>
        <div class="profile_wrap">
          <div class="profile-img_wrap">
            <img :src="profileImg" :alt="`${reviewInfo.memberNick}_img`" />
          </div>
          <span>{{ reviewInfo.memberNick }}</span>
        </div>
        <span class="order-date">{{ orderDate }}</span>
      </div>
      <div>
        <div class="star_wrap">
          <img src="@/assets/images/icon_star.svg" alt="star" />
          <span>{{ reviewInfoStar }}</span>
        </div>
      </div>
    </div>
    <div class="preview_review_box_middle">
      <div v-if="reviewInfo.pictures.length !== 0">
        <!-- carousel start -->
        <div
          id="carousel_preview_review"
          class="carousel slide"
          data-bs-ride="carousel"
        >
          <div class="carousel-indicators">
            <button
              v-for="(reviewImg, reviewImgIndex) in reviewInfo.pictures"
              :key="reviewImg.idx"
              type="button"
              data-bs-target="#carousel_preview_review"
              :data-bs-slide-to="reviewImgIndex"
              :class="{ active: reviewImgIndex === 0 }"
              :aria-current="reviewImgIndex === 0"
              :aria-label="`Slide ${reviewImgIndex + 1}`"
            ></button>
          </div>
          <div class="carousel-inner">
            <div
              v-for="(reviewImg, reviewImgIndex) in reviewInfo.pictures"
              :key="reviewImg.idx"
              class="carousel-item"
              :class="{ active: reviewImgIndex === 0 }"
              data-bs-interval="1000000000"
            >
              <img :src="reviewImg.img" class="d-block w-100" alt="" />
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carousel_preview_review"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carousel_preview_review"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        <!-- carousel end -->
      </div>
      <span v-html="reviewTextNextLine"></span>
    </div>
    <div class="preview_review_box_bottom">
      <div class="interaction_wrap">
        <div
          class="reveiw-interaction interaction_like"
          :class="{ 'on-like-or-hate': reviewInfo.onLike }"
          @click="onClickLikeBtn(reviewInfo.idx)"
        >
          <svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="#292929"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M15.5 11C16.3284 11 17 10.3284 17 9.5C17 8.67157 16.3284 8 15.5 8C14.6716 8 14 8.67157 14 9.5C14 10.3284 14.6716 11 15.5 11Z"
            />
            <path
              d="M8.5 11C9.32843 11 10 10.3284 10 9.5C10 8.67157 9.32843 8 8.5 8C7.67157 8 7 8.67157 7 9.5C7 10.3284 7.67157 11 8.5 11Z"
            />
            <path
              d="M11.99 2C6.47 2 2 6.48 2 12C2 17.52 6.47 22 11.99 22C17.52 22 22 17.52 22 12C22 6.48 17.52 2 11.99 2ZM12 20C7.58 20 4 16.42 4 12C4 7.58 7.58 4 12 4C16.42 4 20 7.58 20 12C20 16.42 16.42 20 12 20ZM7 14C7.78 16.34 9.72 18 12 18C14.28 18 16.22 16.34 17 14H7Z"
            />
          </svg>
          <span>공감</span>
          <span>{{ reviewInfo.like }}</span>
        </div>
      </div>
      <div class="interaction_wrap">
        <div
          class="reveiw-interaction interaction_hate"
          :class="{ 'on-like-or-hate': reviewInfo.onHate }"
          @click="onClickHateBtn(reviewInfo.idx)"
        >
          <svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="#292929"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M15.5 11C16.3284 11 17 10.3284 17 9.5C17 8.67157 16.3284 8 15.5 8C14.6716 8 14 8.67157 14 9.5C14 10.3284 14.6716 11 15.5 11Z"
            />
            <path
              d="M8.5 11C9.32843 11 10 10.3284 10 9.5C10 8.67157 9.32843 8 8.5 8C7.67157 8 7 8.67157 7 9.5C7 10.3284 7.67157 11 8.5 11Z"
            />
            <path
              d="M11.99 2C6.47 2 2 6.48 2 12C2 17.52 6.47 22 11.99 22C17.52 22 22 17.52 22 12C22 6.48 17.52 2 11.99 2ZM12 20C7.58 20 4 16.42 4 12C4 7.58 7.58 4 12 4C16.42 4 20 7.58 20 12C20 16.42 16.42 20 12 20ZM12 14C9.67 14 7.68 15.45 6.88 17.5H8.55C9.24 16.31 10.52 15.5 12 15.5C13.48 15.5 14.75 16.31 15.45 17.5H17.12C16.32 15.45 14.33 14 12 14Z"
            />
          </svg>
          <span>비공감</span>
          <span>{{ reviewInfo.hate }}</span>
        </div>
      </div>
      <div class="interaction_wrap">
        <div class="reveiw-interaction interaction_comment">
          <svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="#292929"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M22.8 4.8H20.4V15.6H4.8V18C4.8 18.66 5.34 19.2 6 19.2H19.2L24 24V6C24 5.34 23.46 4.8 22.8 4.8ZM18 12V1.2C18 0.54 17.46 0 16.8 0H1.2C0.54 0 0 0.54 0 1.2V18L4.8 13.2H16.8C17.46 13.2 18 12.66 18 12Z"
            />
          </svg>
          <span>댓글</span>
          <span>{{ reviewInfo.comment }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import {
  CLICK_PREVIEW_LIKE_BTN,
  CLICK_PREVIEW_HATE_BTN,
} from "@/store/modules/product.js";

export default {
  props: ["reviewInfo"],
  computed: {
    profileImg() {
      return this.reviewInfo.memberImg;
    },
    orderDate() {
      const time = this.reviewInfo.date.replaceAll("-", ".");
      const week = ["일", "월", "화", "수", "목", "금", "토"];
      const day = week[new Date(this.reviewInfo.date).getDay()];
      return `${time}(${day}) 주문`;
    },
    reviewInfoStar() {
      return this.reviewInfo.star.toFixed(1);
    },
    reviewTextNextLine() {
      return this.reviewInfo.reviewText.replaceAll("\n", "<br />");
    },
  },
  methods: {
    ...mapActions("product", [
      `${CLICK_PREVIEW_LIKE_BTN}`,
      `${CLICK_PREVIEW_HATE_BTN}`,
    ]),
    onClickLikeBtn(reviewIdx) {
      this.CLICK_PREVIEW_LIKE_BTN(reviewIdx);
    },
    onClickHateBtn(reviewIdx) {
      this.CLICK_PREVIEW_HATE_BTN(reviewIdx);
    },
  },
};
</script>

<style>
.preview_review_box {
  margin-top: 1vh;
  background-color: white;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.preview_review_box,
.preview_review_box span {
  font-size: 12px;
}
.preview_review_box > div {
  width: calc(100% + 1px);
  padding-left: 2vh;
  padding-right: 2vh;
}

/* top */
.preview_review_box_top {
  padding-top: 2vh;
  padding-bottom: 1vh;
}
.preview_review_box_top > div:first-child {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.preview_review_box_top > div:nth-child(2) {
  display: flex;
  justify-content: flex-end;
  padding-top: 1vh;
}

.preview_review_box .profile_wrap {
  display: flex;
  align-items: center;
  gap: 2vh;
}
.preview_review_box .profile-img_wrap {
  background-color: #fff0b1;
  overflow: hidden;
  width: 5vh;
  height: 5vh;
  border-radius: 5vh;
}
.preview_review_box .profile-img_wrap > img {
  width: 100%;
  height: auto;
}
.preview_review_box .profile_wrap > span {
  font-size: 14px;
  font-weight: bold;
}
.preview_review_box .order-date {
  font-size: 12px;
  color: #858585;
}
.preview_review_box .star_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 4vw;
  height: 3vh;
  border: 1px solid #ffdd1b;
  border-radius: 8px;
}
.preview_review_box .star_wrap > img {
  height: 1.8vh;
  width: auto;
}
.preview_review_box .star_wrap > span {
  padding-left: 1vh;
}

/* middle */
.preview_review_box_middle {
  padding-top: 1vh;
  padding-bottom: 2vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2vh;
}
.preview_review_box_middle > div,
.preview_review_box_middle > span {
  width: 80%;
}

/* bottom */
.preview_review_box_bottom {
  padding-top: 2vh;
  padding-bottom: 2vh;
  border-top: 1px solid #e0e0e0;
  display: flex;
  justify-content: space-between;
}
.preview_review_box_bottom > .interaction_wrap {
  cursor: pointer;
}
.preview_review_box_bottom .reveiw-interaction > svg {
  height: 2.9vh;
  width: auto;
}
.preview_review_box_bottom .reveiw-interaction.interaction_comment > svg {
  height: 2.5vh;
}
.preview_review_box_bottom .reveiw-interaction > span:nth-last-child(2) {
  padding-left: 0.3vh;
}
.preview_review_box_bottom .reveiw-interaction > span:nth-last-child(1) {
  padding-left: 1vh;
  font-size: 14px;
}
.preview_review_box_bottom .reveiw-interaction:hover > span:nth-last-child(2) {
  font-weight: bold;
}
.on-like-or-hate > svg {
  fill: #ff4c3c;
}
.on-like-or-hate > span:nth-last-child(2) {
  color: #ff4c3c;
  font-weight: bold;
}
</style>
