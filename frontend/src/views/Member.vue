<template>
  <div v-if="currentMode === 'login'">
    <login-page></login-page>
  </div>
  <div v-else-if="currentMode === 'entry'">
    <member-entry-page></member-entry-page>
  </div>
</template>

<script>
import LoginPage from "../components/client/member/pages/LoginPage.vue";
import MemberEntryPage from "../components/client/member/pages/MemberEntryPage.vue";

export default {
  computed: {
    currentMode() {
      return this.$route.params.mode;
    },
  },
  components: {
    LoginPage,
    MemberEntryPage,
  },
  data() {
    return {};
  },
};
</script>
