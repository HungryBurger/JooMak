<template>
  <div id="cartPage_wrap" :class="{ 'off-item': onItem === false }">
    <template v-if="onItem === true">
      <div id="cartPage">
        <div class="left">
          <div class="top">
            <h2>
              주모의 보따리
              <img :src="iconBottariClosePath" alt="icon_bottari-close" />
              <span></span>
            </h2>
          </div>

          <div class="bottom">
            <div class="store">
              <div>
                <div class="img_wrap">
                  <img
                    :src="responseData.store.img"
                    alt="장바구니 매장 이미지"
                  />
                </div>
                <h4>{{ responseData.store.name }}</h4>
              </div>
              <router-link :to="`/store/${responseData.store.idx}`">
                <button>이 매장에서 더 고르기</button>
              </router-link>
            </div>

            <div class="product">
              <div class="buttons">
                <button
                  class="select-all_btn"
                  :class="{ on: selectCounter === cartList.length }"
                  @click="onClickSelectAllBtn"
                >
                  전체 선택
                </button>
                <button
                  class="select-del_btn"
                  :class="{ on: selectCounter > 0 }"
                  @click="onClickSelectDelBtn"
                >
                  선택 삭제
                </button>
              </div>

              <ul>
                <li
                  v-for="(prt, i) in cartList"
                  :key="i"
                  :class="{ selected: prt.selected }"
                  @click="onClickPrt(prt.productIdx)"
                >
                  <div class="check-box_wrap">
                    <img
                      v-if="prt.selected"
                      :src="imgPathSingleY"
                      alt="checked"
                    />
                    <img v-else :src="imgPathSingleN" alt="unchecked" />
                  </div>
                  <div class="prt-img_wrap">
                    <img :src="prt.img" alt="prt.name" />
                  </div>
                  <div class="bold">{{ prt.name }}</div>
                  <div></div>
                  <div>
                    <NumberWithCommaSpan
                      class="bold"
                      :num="prt.price"
                      textBack="&nbsp;&nbsp;원"
                    />
                  </div>
                </li>
              </ul>
            </div>
          </div>

          <div id="cart-page_scroll-top_btn" @click="onClickScrollTopBtn">
            <img
              src="@/assets/images/icon_arrow-top.svg"
              alt="icon_arrow-top"
            />
          </div>
        </div>

        <div class="right">
          <div class="top">
            <h5>선택 메뉴</h5>
            <template v-if="selectCounter > 0">
              hihi
            </template>
            <template v-else>
              <span>선택하신 메뉴가 없습니다.</span>
            </template>
          </div>

          <div
            class="link_order"
            @click="onClickOrderLink"
            :class="{ on: selectCounter > 0 }"
          >
            선택상품 주문하기
          </div>
        </div>
      </div>
    </template>

    <template v-else-if="onItem === false">
      <div id="cartPage">
        <div class="top">
          <h2>
            주모의 보따리
            <img :src="iconBottariClosePath" alt="icon_bottari-close" />
            <span></span>
          </h2>
          <span></span>

          <h4>주모의 보따리가 텅텅 비어있습니다...</h4>
        </div>

        <div class="bottom">
          <img
            class="icon_joomo-sad"
            :src="iconJoomoSadPath"
            alt="icon_joomo-sad"
          />
          <svg
            class="icon_thinking-bubble"
            width="424"
            height="285"
            viewBox="0 0 424 285"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M390.5 273.5C390.5 274.254 390.159 275.173 389.127 276.231C388.084 277.301 386.454 278.379 384.243 279.338C379.83 281.253 373.559 282.5 366.5 282.5C359.441 282.5 353.17 281.253 348.757 279.338C346.546 278.379 344.916 277.301 343.873 276.231C342.841 275.173 342.5 274.254 342.5 273.5C342.5 272.746 342.841 271.827 343.873 270.769C344.916 269.699 346.546 268.621 348.757 267.662C353.17 265.747 359.441 264.5 366.5 264.5C373.559 264.5 379.83 265.747 384.243 267.662C386.454 268.621 388.084 269.699 389.127 270.769C390.159 271.827 390.5 272.746 390.5 273.5Z"
              fill="white"
              stroke="#7F7F7F"
              stroke-width="5"
            />
            <path
              d="M348.5 230.5C348.5 232.501 347.581 234.605 345.512 236.739C343.431 238.885 340.299 240.931 336.235 242.704C328.113 246.247 316.718 248.5 304 248.5C291.282 248.5 279.887 246.247 271.765 242.704C267.701 240.931 264.569 238.885 262.488 236.739C260.419 234.605 259.5 232.501 259.5 230.5C259.5 228.499 260.419 226.395 262.488 224.261C264.569 222.115 267.701 220.069 271.765 218.296C279.887 214.753 291.282 212.5 304 212.5C316.718 212.5 328.113 214.753 336.235 218.296C340.299 220.069 343.431 222.115 345.512 224.261C347.581 226.395 348.5 228.499 348.5 230.5Z"
              fill="white"
              stroke="#7F7F7F"
              stroke-width="5"
            />
            <path
              d="M421.5 92.5C421.5 104.442 415.964 116.017 405.545 126.765C395.115 137.525 379.901 147.328 360.907 155.616C322.926 172.188 270.282 182.5 212 182.5C153.718 182.5 101.074 172.188 63.0931 155.616C44.099 147.328 28.8852 137.525 18.455 126.765C8.03639 116.017 2.5 104.442 2.5 92.5C2.5 80.5579 8.03639 68.9826 18.455 58.2349C28.8852 47.4754 44.099 37.6715 63.0931 29.384C101.074 12.8122 153.718 2.5 212 2.5C270.282 2.5 322.926 12.8122 360.907 29.384C379.901 37.6715 395.115 47.4754 405.545 58.2349C415.964 68.9826 421.5 80.5579 421.5 92.5Z"
              fill="white"
              stroke="#7F7F7F"
              stroke-width="5"
            />
            <circle class="dot dot1" cx="151" cy="100" r="10" fill="#7F7F7F" />
            <circle class="dot dot2" cx="211" cy="100" r="10" fill="#7F7F7F" />
            <circle class="dot dot3" cx="271" cy="100" r="10" fill="#7F7F7F" />
          </svg>

          <img class="icon_joomak" :src="iconJoomakPath" alt="icon_joomak" />
        </div>

        <img id="icon_cloud" :src="iconCloudPath" alt="icon_cloud" />
      </div>
    </template>
  </div>
</template>

<script>
import NumberWithCommaSpan from "../components/client/common/share/components/NumberWithCommaSpan.vue";
export default {
  components: { NumberWithCommaSpan },
  data() {
    return {
      responseData: {
        store: {},
        cartList: [],
      },

      cartList: [],
      // onItem: true,

      selectCounter: 0,
    };
  },
  computed: {
    onItem() {
      if (this.cartList.length > 0) {
        return true;
      } else {
        return false;
      }
    },

    imgPathSingleY() {
      return require("@/assets/images/icon_check-only_y.svg");
    },
    imgPathSingleN() {
      return require("@/assets/images/icon_check-only_n.svg");
    },

    iconBottariClosePath() {
      return require("@/assets/images/icon_bottari-close.svg");
    },
    iconJoomoSadPath() {
      return require("@/assets/images/icon_joomo-sad.svg");
    },
    iconJoomakPath() {
      return require("@/assets/images/icon_order_joomak.svg");
    },
    iconCloudPath() {
      return require("@/assets/images/icon_cloud.svg");
    },
  },

  created() {
    // // axios post
    // let res;
    // this.cartList = res.cartList;

    // 임시데이터
    this.responseData.store = {
      idx: 3,
      name: "KFC 부평점",
      img: require("@/assets/images/member_profile-img2.png"),
    };
    this.cartList = [
      {
        storeIdx: 3,
        groupIdx: 1,
        productIdx: 1,
        img: require("@/assets/images/detail-page_imgs/detail-page_food_box1.png"),
        name: "블랙라벨폴인치즈버거 박스",
        price: 11800,
      },
      {
        storeIdx: 3,
        groupIdx: 1,
        productIdx: 2,
        img: require("@/assets/images/detail-page_imgs/detail-page_food_box2.png"),
        name: "핫통삼겹베이컨버거 박스",
        price: 11500,
      },
      {
        storeIdx: 3,
        groupIdx: 1,
        productIdx: 3,
        img: require("@/assets/images/detail-page_imgs/detail-page_food_box3.png"),
        name: "징거더블다운맥스 박스",
        price: 11200,
      },
    ];

    // '선택' property 할당
    this.cartList.forEach((e) => {
      Object.assign(e, { selected: false });
    });
  },

  methods: {
    onClickSelectAllBtn() {
      if (this.selectCounter !== this.cartList.length) {
        this.cartList.forEach((e) => {
          e.selected = true;
        });
        this.selectCounter = this.cartList.length;
      } else {
        this.cartList.forEach((e) => {
          e.selected = false;
        });
        this.selectCounter = 0;
      }
    },
    onClickSelectDelBtn() {
      if (this.selectCounter === 0) {
        alert("선택된 상품이 없습니다.");
        return;
      }

      if (
        confirm(
          `선택된 ${this.selectCounter}개 상품을 장바구니에서 삭제하시겠습니까?`
        )
      ) {
        // axios delete 처리
        this.selectCounter = 0;

        // 임시 (* 실제 axios 처리시 없어도 됨)
        this.cartList.forEach((e) => {
          e.selected = false;
        });

        alert("삭제되었습니다.");
        return;
      } else return;
    },
    onClickPrt(prtIdx) {
      this.cartList.forEach((e) => {
        if (e.productIdx === prtIdx) {
          if (e.selected) {
            e.selected = false;
            this.selectCounter--;
          } else {
            e.selected = true;
            this.selectCounter++;
          }
          return;
        }
      });
    },
    onClickScrollTopBtn() {
      const leftDiv = document.querySelector("#cartPage > .left");
      leftDiv.scrollTo(0, 0);

      scrollTo(0, 0);
    },
    onClickOrderLink() {
      if (this.selectCounter === 0) return;

      this.$router.push({ name: "orderPage" });
    },
  },
};
</script>
