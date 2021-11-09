<template>
  <div
    id="homePage"
    :class="{
      morning: currentHomeCoords === 'morning',
      afternoon: currentHomeCoords === 'afternoon',
      evening: currentHomeCoords === 'evening',
      night: currentHomeCoords === 'night',
    }"
  >
    <div id="div-for-off-sticky" v-if="currentHomeCoords === 'footer'"></div>
    <div
      class="home_background-color"
      :class="{
        sticky: currentHomeCoords !== 'footer',
      }"
    >
      <div class="home_background-img">
        <div id="home_category-wrap">
          <home-page-category
            v-for="(category, index) in threeHomeCategories"
            :key="index"
            :category="category"
            :categoryIndex="index"
          ></home-page-category>
        </div>
        <div id="home_side-nav-wrap">
          <div
            class="home_side-nav_li"
            :class="{ 'on-click-side-nav': currentHomeCoords === 'morning' }"
            @click="onClickSideNav('morning')"
          >
            한식&nbsp;&nbsp;/&nbsp;&nbsp;양식&nbsp;&nbsp;/&nbsp;&nbsp;일식
          </div>
          <div
            class="home_side-nav_li"
            :class="{ 'on-click-side-nav': currentHomeCoords === 'afternoon' }"
            @click="onClickSideNav('afternoon')"
          >
            중식&nbsp;&nbsp;/&nbsp;&nbsp;분식&nbsp;&nbsp;/&nbsp;&nbsp;족발
          </div>
          <div
            class="home_side-nav_li"
            :class="{ 'on-click-side-nav': currentHomeCoords === 'evening' }"
            @click="onClickSideNav('evening')"
          >
            치킨&nbsp;&nbsp;/&nbsp;&nbsp;피자&nbsp;&nbsp;/&nbsp;&nbsp;버거
          </div>
          <div
            class="home_side-nav_li"
            :class="{
              'on-click-side-nav':
                currentHomeCoords === 'night' || currentHomeCoords === 'footer',
            }"
            @click="onClickSideNav('night')"
          >
            디저트&커피&nbsp;&nbsp;/&nbsp;&nbsp;야식
          </div>
        </div>
        <div id="home_deco-line">
          <div
            class="home_deco-line_left"
            v-if="currentHomeCoords === 'morning'"
          ></div>
          <div
            class="home_deco-line_right"
            v-if="currentHomeCoords === 'morning'"
          ></div>
        </div>
        <img
          v-if="currentHomeCoords === 'night' || currentHomeCoords === 'footer'"
          src="@/assets/images/moon-and-stars.svg"
          alt="moon-and-stars"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from "vuex";
import {
  SET_CURRENT_PAGE,
  SET_ON_HOME,
  SET_CURRENT_HOME_COORDS,
} from "@/store/modules/common.js";
import HomePageCategory from "@/components/client/common/home/components/HomePageCategory.vue";

export default {
  components: {
    HomePageCategory,
  },
  computed: {
    ...mapState("common", ["currentHomeCoords"]),
    ...mapGetters("product", ["homeCategories"]),
    threeHomeCategories() {
      let index = 0;
      switch (this.currentHomeCoords) {
        case "morning":
          index = 0;
          break;
        case "afternoon":
          index = 1;
          break;
        case "evening":
          index = 2;
          break;
        case "night":
          index = 3;
          break;
        default:
          index = 3;
          break;
      }
      return this.homeCategories[index];
    },
  },
  methods: {
    // scrollY 위치에 따라 currentHomeCoords 변경
    onScroll() {
      if (window.scrollY < window.innerHeight * this.homeCategories.length) {
        if (window.scrollY < window.innerHeight) {
          if (this.currentHomeCoords !== "morning") {
            this.$store.commit(`common/${SET_CURRENT_HOME_COORDS}`, "morning");
          }
        } else if (window.scrollY < window.innerHeight * 2) {
          if (this.currentHomeCoords !== "afternoon") {
            this.$store.commit(
              `common/${SET_CURRENT_HOME_COORDS}`,
              "afternoon"
            );
          }
        } else if (window.scrollY < window.innerHeight * 3) {
          if (this.currentHomeCoords !== "evening") {
            this.$store.commit(`common/${SET_CURRENT_HOME_COORDS}`, "evening");
          }
        } else if (window.scrollY < window.innerHeight * 4) {
          if (this.currentHomeCoords !== "night") {
            this.$store.commit(`common/${SET_CURRENT_HOME_COORDS}`, "night");
          }
        }
      } else {
        if (this.currentHomeCoords !== "footer") {
          this.$store.commit(`common/${SET_CURRENT_HOME_COORDS}`, "footer");
        }
      }
      // console.log(this.currentHomeCoords);
    },
    onClickSideNav(pageName) {
      switch (pageName) {
        case "morning":
          scrollTo(0, 0);
          return;
        case "afternoon":
          scrollTo(0, window.innerHeight);
          return;
        case "evening":
          scrollTo(0, window.innerHeight * 2);
          return;
        case "night":
          scrollTo(0, window.innerHeight * 3);
          return;
      }
    },
  },
  created() {
    if (this.currentPage !== "homePage") {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, "homePage");
    }
    this.$store.commit(`common/${SET_ON_HOME}`, true);
  },
  mounted() {
    // console.log(this.threeHomeCategories);
    window.addEventListener("scroll", this.onScroll);
  },
  updated() {
    // console.log(this.threeHomeCategories);
  },
  beforeUnmount() {
    window.removeEventListener("scroll", this.onScroll);
  },
};
</script>

<style scoped>
#homePage {
  width: 100%;
  height: 400vh;
}
.home_background-color {
  width: 100%;
  height: 100vh;
  background: linear-gradient(
    180deg,
    #475d98 0%,
    rgba(155, 114, 170, 0.7) 100%
  );
}

.home_background-img {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  width: 100%;
  height: 100%;
  background: url("../assets/images/home_night.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
}

#home_category-wrap {
  z-index: 5;
  width: 55vw;
  height: 100%;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 3vw;
  justify-items: center;
  align-items: center;
}
#home_side-nav-wrap {
  font-size: 12px;
  z-index: 50;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: flex-end;
  width: 13vw;
  height: 72vh;
  position: absolute;
  right: 1.3%;
}
.home_side-nav_li {
  cursor: pointer;
  position: relative;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  box-sizing: border-box;
  width: 100%;
  height: 25%;
  padding-right: 25%;
}
.home_side-nav_li:hover::after {
  content: "";
  display: block;
  position: absolute;
  bottom: 30%;
  width: 100%;
  height: 1px;
  border-bottom: 2px solid white;
  margin-right: -25%;
}
.on-click-side-nav::after {
  content: "";
  display: block;
  position: absolute;
  bottom: 30%;
  width: 100%;
  height: 1px;
  border-bottom: 2px solid white;
  margin-right: -25%;
}

#home_deco-line {
  border: 2px solid white;
  border-top: none;
  width: 97%;
  height: 110vh;
  position: absolute;
  left: 1.5%;
  bottom: 1.5vw;
}
.morning #home_deco-line {
  border: 2px solid white;
  border-top: none;
  width: 97%;
  height: 110vh;
  position: absolute;
  top: 4.3vh;
  left: 1.5%;
}
.home_deco-line_left {
  position: absolute;
  top: 0;
  left: -2px;
  width: 2vw;
  height: 10px;
  border-top: 2px solid white;
}
.home_deco-line_right {
  position: absolute;
  top: 0;
  right: -2px;
  width: 2vw;
  height: 10px;
  border-top: 2px solid white;
}
.afternoon #home_deco-line,
.evening #home_deco-line {
  top: -5vh;
}

.home_background-img > img {
  position: absolute;
  top: 0;
  left: 6.5vw;
  padding-top: 6vh;
  width: 85vw;
}
.sticky {
  position: fixed;
}

#div-for-off-sticky {
  width: 100%;
  height: 400vh;
}

/* 아침 */
#homePage.morning > .home_background-color {
  background: linear-gradient(180deg, #ffc463 0%, #ffeea7 100%);
}
#homePage.morning .home_background-img {
  background: url("../assets/images/home_morning.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
}

/* 점심 */
#homePage.afternoon > .home_background-color {
  background: linear-gradient(237.43deg, #f2eeaa 0%, #88c5f7 34.6%);
}
#homePage.afternoon .home_background-img {
  background: url("../assets/images/home_afternoon.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
}

/* 저녁 */
#homePage.evening > .home_background-color {
  background: linear-gradient(
    180deg,
    rgba(192, 117, 149, 0.7) 0%,
    rgba(241, 155, 132, 0.7) 31.56%
  );
}
#homePage.evening .home_background-img {
  background: url("../assets/images/home_evening.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
}

/* 야밤 */
#homePage.night > .home_background-color {
  background: linear-gradient(
    180deg,
    #475d98 0%,
    rgba(155, 114, 170, 0.7) 100%
  );
}
#homePage.night .home_background-img {
  background: url("../assets/images/home_night.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
}
</style>
