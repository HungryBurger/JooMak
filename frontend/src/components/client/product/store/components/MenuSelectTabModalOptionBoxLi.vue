<template>
  <li>
    <div class="option_li">
      <div class="option_li_left">
        <div v-if="singleOption" class="check-box_wrap">
          <img :src="imgPathSingleN" alt="unchecked" />
        </div>
        <div v-else-if="multiOption" class="check-box_wrap">
          <img :src="imgPathMultiN" alt="unchecked" />
        </div>
        <span class="option_name">{{ optionInfo.optionName }}</span>
      </div>
      <div class="option_li_right">
        <span class="option_price">{{ optionPrice }}</span>
      </div>
    </div>
  </li>
</template>

<script>
export default {
  props: ["optionInfo", "singleOption", "multiOption"],
  computed: {
    imgPathSingleN() {
      return require("@/assets/images/icon_check-only_n.svg");
    },
    imgPathMultiN() {
      return require("@/assets/images/icon_check-multi_n.svg");
    },
    optionPrice() {
      if (this.optionInfo.price !== 0) {
        let num = this.optionInfo.price;
        return `+ ${num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}`;
      } else {
        return "";
      }
    },
  },
};
</script>

<style></style>
