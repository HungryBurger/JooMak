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
import { SET_CURRENT_HOME_COORDS } from "@/store/modules/common.js";

export default {
  computed: {
    ...mapState("common", ["currentHomeCoords"]),
    ...mapGetters("product", ["homeCategories"]),
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
      console.log(this.currentHomeCoords);
    },
  },
  mounted() {
    console.log(this.homeCategories);
    window.addEventListener("scroll", this.onScroll);
  },
  beforeDestroy() {
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
  position: relative;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  width: 100%;
  height: 100%;
  background: url("../assets/images/home_night.png");
  background-size: 100% auto;
  background-repeat: no-repeat;
  background-position: bottom -220px right 0;
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
  padding-top: 12vh;
  width: 87vw;
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
