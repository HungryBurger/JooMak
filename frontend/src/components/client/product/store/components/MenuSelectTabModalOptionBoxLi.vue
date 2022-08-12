<template>
  <li>
    <div
      class="option_li"
      @click="
        onClickOptionLi({
          optionInfo,
          singleOption,
          multiOption,
          selectedItemForm,
        })
      "
    >
      <div class="option_li_left">
        <div v-if="singleOption" class="check-box_wrap">
          <img
            v-if="optionGroup.selectedOptionIdx === optionInfo.optionIdx"
            :src="imgPathSingleY"
            alt="checked"
          />
          <img
            v-else-if="optionGroup.selectedOptionIdx !== optionInfo.optionIdx"
            :src="imgPathSingleN"
            alt="unchecked"
          />
        </div>
        <div v-else-if="multiOption" class="check-box_wrap">
          <img
            v-if="optionInfo.onSelected"
            :src="imgPathMultiY"
            alt="checked"
          />
          <img
            v-else-if="!optionInfo.onSelected"
            :src="imgPathMultiN"
            alt="unchecked"
          />
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
import { mapActions, mapState } from "vuex";
import { TOGGLE_OPTION_LI } from "@/store/modules/order.js";

export default {
  props: ["optionGroup", "optionInfo", "singleOption", "multiOption"],
  computed: {
    ...mapState("order", ["selectedItemForm"]),
    imgPathSingleY() {
      return require("@/assets/images/icon_check-only_y.svg");
    },
    imgPathSingleN() {
      return require("@/assets/images/icon_check-only_n.svg");
    },
    imgPathMultiY() {
      return require("@/assets/images/icon_check-multi_y.svg");
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
  methods: {
    ...mapActions("order", [TOGGLE_OPTION_LI]),
    onClickOptionLi({
      optionInfo,
      singleOption,
      multiOption,
      selectedItemForm,
    }) {
      this.TOGGLE_OPTION_LI({
        optionInfo,
        singleOption,
        multiOption,
        selectedItemForm,
      });
    },
  },
  mounted() {},
};
</script>

<style></style>
