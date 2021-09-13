<template>
  <router-link
    v-if="currentAddress"
    :to="`/store-list/${category.en}`"
    @click="onClickCategory(category.en, 'storeListPage')"
  >
    <div class="home-page_category" :data-category="category.en">
      <div class="category_letter">
        <img :src="letterPath" :alt="category.en + '_letter'" />
      </div>
      <div class="category_image">
        <img :src="imgPath" :alt="category.en + '_image'" />
      </div>
    </div>
  </router-link>

  <!-- fake component -->
  <a
    v-else-if="!currentAddress"
    @click="onClickCategory(category.en, 'storeListPage')"
  >
    <div class="home-page_category" :data-category="category.en">
      <div class="category_letter">
        <img :src="letterPath" :alt="category.en + '_letter'" />
      </div>
      <div class="category_image">
        <img :src="imgPath" :alt="category.en + '_image'" />
      </div>
    </div>
  </a>
</template>

<script>
import { mapState } from "vuex";
import { TOGGLE_ON_HOME, SET_CURRENT_PAGE } from "@/store/modules/common.js";
import { SET_CURRENT_CATEGORY } from "@/store/modules/product.js";

export default {
  props: ["category", "categoryIndex"],
  computed: {
    ...mapState("common", ["onHome", "currentPage"]),
    ...mapState("member", ["currentAddress"]),
    letterPath() {
      return require(`@/assets/images/letter_${this.category.en}.svg`);
    },
    imgPath() {
      return require(`@/assets/images/home-img_${this.category.en}.png`);
    },
  },
  methods: {
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
  },
};
</script>

<style scoped>
a {
  width: 100%;
  height: 57vh;
}
.home-page_category {
  overflow: hidden;
  position: relative;
  cursor: pointer;
  /* margin: 20px; */
  /* width: 20vw; */
  width: 100%;
  height: 100%;
  background-color: white;
  border-radius: 30px;
}

.home-page_category:hover::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  border: 5px solid white;
  border-radius: 30px;
}
.home-page_category[data-category="korean"]:hover {
  background-color: #f6f6f6;
}
.home-page_category[data-category="western"]:hover {
  background-color: #ffec9d;
}
.home-page_category[data-category="japanese"]:hover {
  background-color: #ffa579;
}
.home-page_category[data-category="chinese"]:hover {
  background-color: #fe292f;
}
.home-page_category[data-category="flour-based"]:hover {
  background-color: #e98825;
}
.home-page_category[data-category="jokbal"]:hover {
  background-color: #a16e3b;
}
.home-page_category[data-category="chicken"]:hover {
  background-color: #f0cf49;
}
.home-page_category[data-category="pizza"]:hover {
  background-color: #f69708;
}
.home-page_category[data-category="burger"]:hover {
  background-color: #fd9f54;
}
.home-page_category[data-category="dessert"]:hover {
  background-color: #fed6d6;
}
.home-page_category[data-category="night-food"]:hover {
  background: linear-gradient(
    180deg,
    #475d98 0%,
    rgba(155, 114, 170, 0.4) 100%
  );
}

.category_letter {
  position: relative;
  height: 40%;
}
.category_letter > img {
  position: absolute;
  top: 25%;
  left: 8%;
  width: 8vw;
  height: auto;
}

.category_image {
  position: relative;
  height: 60%;
}
.category_image > img {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 100%;
  height: auto;
}
</style>
