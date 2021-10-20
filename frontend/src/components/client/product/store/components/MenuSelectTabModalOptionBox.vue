<template>
  <div class="option-box" :class="{ 'no-option': !optionGroup }">
    <div class="option-box_title">
      <span>
        {{ optionGroup.optionGroupName }}
      </span>
    </div>
    <div class="option-box_content">
      <ul>
        <menu-select-tab-modal-option-box-li
          v-for="optionInfo in optionGroup.optionList"
          :key="optionInfo.optionIdx"
          :optionGroup="optionGroup"
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
      optionGroup: {},
    };
  },
  created() {
    if (this.singleOption) {
      this.optionGroup = this.singleOption;
    } else if (this.multiOption) {
      this.optionGroup = this.multiOption;
    }
  },
};
</script>

<style></style>
