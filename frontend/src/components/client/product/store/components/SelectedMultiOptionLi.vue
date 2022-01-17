<template>
  <li
    class="selected-multi-option_li"
    :class="{ 'no-multi-option': noCheckedMultiOption }"
  >
    <div>
      <span>[&nbsp;{{ multiOption.optionGroupName }}&nbsp;]</span>
    </div>
    <ul>
      <li
        v-for="option in multiOption.optionList"
        :key="option.optionIdx"
        :class="{ unselected: !option.onSelected }"
      >
        <div v-if="option.onSelected">
          <span>{{ option.optionName }}</span>
          <number-with-comma-span
            :num="option.price"
            textFront="+&nbsp;"
          ></number-with-comma-span>
        </div>
      </li>
    </ul>
  </li>
</template>

<script>
import NumberWithCommaSpan from "@/components/client/common/share/components/NumberWithCommaSpan.vue";

export default {
  props: ["multiOption"],
  components: {
    NumberWithCommaSpan,
  },
  computed: {
    noCheckedMultiOption() {
      let nothing = true;
      let optionList = this.multiOption.optionList;
      for (let i = 0; i < optionList.length; i++) {
        if (optionList[i].onSelected) {
          nothing = false;
          break;
        }
      }
      return nothing;
    },
  },
};
</script>

<style>
.unselected {
  display: none;
}
</style>
