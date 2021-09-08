<template>
  <div id="homePage">
    <span>홈페이지 입니다</span><br />
    <span>{{ commonData }}</span>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState("common", ["commonData"]),

    // commonData() {
    //   return this.$store.state.common.commonData;
    // },
  },
  methods: {},
};
</script>

<style scoped>
#homePage {
  width: 500px;
  height: 5000px;
  background-color: gray;
}
</style>
