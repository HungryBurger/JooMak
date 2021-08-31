<template>
  <div id="loginPage">
    <span>로그인 페이지입니다</span>
    <br />
    <router-link to="/member/entry">회원가입</router-link>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
#loginPage {
  width: 500px;
  height: 300px;
  background-color: goldenrod;
}
</style>
