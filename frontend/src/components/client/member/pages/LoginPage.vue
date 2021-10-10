<template>
  <div id="loginPage">
    <span>로그인 페이지입니다</span>
    <button @click="openModal">열기</button>
    <ModalComponent @close="closeModal" v-if="modal">
      <template v-slot:header>
        <h1>
          custom header
        </h1>
      </template>
      <template v-slot:content>
        custom content
      </template>
      <template v-slot:footer>
        custom footer
      </template>
    </ModalComponent>
    <br />
    <router-link to="/member/entry">회원가입</router-link>
  </div>
</template>

<script>
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";

export default {
  components: { ModalComponent },
  data() {
    return {
      modal: false,
    };
  },
  methods: {
    openModal() {
      this.modal = true;
    },
    closeModal() {
      this.modal = false;
    },
  },
};
</script>

<style scoped>
#loginPage {
  width: 500px;
  height: 300px;
  background-color: goldenrod;
}
</style>
