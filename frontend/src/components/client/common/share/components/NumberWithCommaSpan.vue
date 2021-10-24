<template>
  <span>{{ textFront }}{{ applyNumberWithComma }}{{ textBack }}</span>
</template>

<script>
export default {
  props: ["num", "textFront", "textBack"],
  computed: {
    applyNumberWithComma() {
      let num = this.num;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style></style>
