<template>
  <li>
    <div>
      <span>[&nbsp;{{ singleOption.optionGroupName }}&nbsp;]&nbsp;</span>
      <span>{{ selectedOption.optionName }}</span>
    </div>
    <!-- <span>{{ selectedOptionPrice }}</span> -->
    <number-with-comma-span
      :num="selectedOption.price"
      textFront="+&nbsp;"
    ></number-with-comma-span>
  </li>
</template>

<script>
import NumberWithCommaSpan from "@/components/client/common/share/components/NumberWithCommaSpan.vue";

export default {
  props: ["singleOption"],
  components: {
    NumberWithCommaSpan,
  },
  computed: {
    selectedOption() {
      const optionList = this.singleOption.optionList;
      for (let i = 0; i < optionList.length; i++) {
        if (this.singleOption.selectedOptionIdx === optionList[i].optionIdx) {
          return optionList[i];
        }
      }
    },
  },
};
</script>

<style></style>
