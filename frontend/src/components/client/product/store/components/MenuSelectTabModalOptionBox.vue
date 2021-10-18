<template>
  <div class="option-box" :class="{ 'no-option': !option }">
    <div class="option-box_title">
      <span>
        {{ option.optionGroupName }}
      </span>
    </div>
    <div class="option-box_content">
      <ul>
        <menu-select-tab-modal-option-box-li
          v-for="optionInfo in option.optionList"
          :key="optionInfo.optionIdx"
          :optionInfo="optionInfo"
          :singleOption="singleOption"
          :multiOption="multiOption"
        ></menu-select-tab-modal-option-box-li>
      </ul>
    </div>
  </div>
</template>

<script>
import MenuSelectTabModalOptionBoxLi from "./MenuSelectTabModalOptionBoxLi";

export default {
  props: ["singleOption", "multiOption"],
  components: {
    MenuSelectTabModalOptionBoxLi,
  },
  data() {
    return {
      option: {},
    };
  },
  created() {
    if (this.singleOption) {
      this.option = this.singleOption;
    } else if (this.multiOption) {
      this.option = this.multiOption;
    }
  },
};
</script>

<style></style>
