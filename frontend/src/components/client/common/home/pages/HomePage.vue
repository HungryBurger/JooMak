<template>
  <div id="homePage">
    <span>홈페이지 입니다</span><br />
    <span>{{ commonData }}</span>
  </div>
</template>

<script>
export default {
  computed: {
    commonData() {
      console.log("git test");
      console.log("git test2");
      return this.$store.state.common.commonData;
    },
  },
  methods: {},
};
</script>

<style scoped>
#homePage {
  width: 500px;
  height: 300px;
  background-color: gray;
}
</style>
