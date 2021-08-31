<template>
  <div id="header">
    헤더입니다<br />
    <router-link to="/">Home</router-link> |
    <router-link to="/member/login">Login</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/store-list/korean">한식</router-link> |
    <router-link to="/store-list/western">양식</router-link>
  </div>
</template>

<script>
export default {
  computed: {},
  methods: {},
};
</script>

<style scoped>
#header {
  width: 500px;
  height: 100px;
  background-color: red;
}
</style>
