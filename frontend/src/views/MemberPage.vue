<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script>
import LoginPage from "../components/client/member/pages/LoginPage.vue";
import MemberEntryPage from "../components/client/member/pages/MemberEntryPage.vue";
import MemberEntryCompletePage from "../components/client/member/pages/MemberEntryCompletePage.vue";

export default {
  components: {
    LoginPage,
    MemberEntryPage,
    MemberEntryCompletePage
  },
};
</script>
